import groovy.sql.Sql
import org.codehaus.groovy.grails.commons.metaclass.GroovyDynamicMethodsInterceptor
import org.codehaus.groovy.grails.web.metaclass.BindDynamicMethod
import grails.transaction.Transactional

@Transactional
class NetWinService {
    def dataSource
    def dataService
    def dateService
    def toolsService

    NetWinService() {
        GroovyDynamicMethodsInterceptor i = new GroovyDynamicMethodsInterceptor(this)
        i.addDynamicMethodInvocation(new BindDynamicMethod())
    }

    def getNw200List(params) { //回傳Nw200(連結)
        params.max = params.int('max')
        params.offset = params.int('offset')
        def nw200I = Nw200.createCriteria().list(params) {
            if (params.pType) {
                eq("type", params.pType)
            }
            if (params.pTypeList) {
                inList("type", params.pTypeList)
            }
        }
        return nw200I
    }

    def getNw300List(params) { //取得Nw300(彩球)
        params.max = params.int('max')
        params.offset = params.int('offset')
        def nw300I = Nw300.createCriteria().list(params) {
            if (params.pYyyymmS && params.pYyyymmE) {
                ge("opendt", params.pYyyymmS)
                lt("opendt", params.pYyyymmE - 1)
            }
            if (params.pOpendt) {
                ge("opendt", params.pOpendt)
                lt("opendt", params.pOpendt + 1)
            }
            if (params.pPeriods) {
                eq("periods", params.pPeriods)
            }

            if (params.pType) {
                eq("type", params.pType)
            }

            if (params.pTypeList) {
                inList("type", params.pTypeList)
            }
            order("opendt", "desc")
            order("periods", "desc")
        }
        return nw300I
    }

    def getNw400List(params) { //回傳Nw400(文章)
        params.max = params.int('max')
        params.offset = params.int('offset')
        def nw400I = Nw400.createCriteria().list(params) {
            if (params.pType) {
                eq("type", params.pType)
            }

            order("idx", "asc")
        }
        return nw400I
    }

    def getNw500List(params) { //回傳Nw500(清單)
        params.max = params.int('max')
        params.offset = params.int('offset')
        def nw500I = Nw500.createCriteria().list(params) {
            if (params.pType) {
                eq("type", params.pType)
            }
        }
        return nw500I
    }


    def getNw400(params) { //取得Nw400(文章) Data
        def nw400I = Nw400.get(params.id)
        return nw400I
    }

    def saveNw400(params) { //更新Nw400(文章) Data
        def nw400I = Nw400.get(params.id)

        bindData(nw400I, params)
        nw400I.manLastUpdated = "ADMIN"

        if (!nw400I.hasErrors()) {
            nw400I.save(flush: true)
        }

        return nw400I
    }

    def updateNw400BrowsCnts(params) { //更新閱讀次數後回傳Nw400
        def nw400I = Nw400.get(params.id)
        nw400I.browsercnts = ((nw400I?.browsercnts ?: 0) + 1)
        nw400I.manLastUpdated = "BROWSER"
        nw400I.save(flush: true)
        return nw400I
    }

    def getHistoryAnyalysis1(params) { //歷史數據: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "DECODE(SUM(CASE WHEN NW31.NO = ${it} THEN (CASE WHEN NW31.ISSPNO = 1 THEN 2 ELSE 1 END) ELSE 0 END),2,'SPNO',1,'NO','') NO${it}, "
        }

        def unspnoSql = ""
        if ((params.int('pUnSPNO') ?: 0)) {
            unspnoSql = "AND NW31.ISSPNO IN (0)"
        } else {
            unspnoSql = "AND NW31.ISSPNO IN (1,0)"
        }

        def mainSql = """
                       SELECT
                        NW3.PERIODS,
                        NW3.OPENDT,
                        ${nosSql}
                        0 END
                        FROM (
                            SELECT
                            NW3.OBJID,
                            NW3.TYPE,
                            NW3.PERIODS,
                            NW3.OPENDT
                            FROM NW300 NW3
                            WHERE 1 = :pNum
                            AND NW3.TYPE = :pType
                            AND ROWNUM <= :max
                            ORDER BY NW3.PERIODS DESC
                        ) NW3
                        LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                        WHERE 1=1
                        ${unspnoSql}
                        GROUP BY NW3.PERIODS, NW3.OPENDT
                        ORDER BY NW3.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = (params.int('max')?:25) > 200 ? 200 : (params.int('max')?:25) //require
        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getHistoryAnyalysis2(params) { //歷史數據: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.columnsSPNOs = dataService."lotto${params.pType}".SPNOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "DECODE(SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 0 THEN 1 ELSE 0 END),2,'SPNO',1,'NO','') NO${it}, "
        }

        def spnosSql = ""
        result.columnsSPNOs.each { it ->
            spnosSql += "DECODE(SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 1 THEN 2 ELSE 0 END),2,'SPNO',1,'NO','') SPNO${it}, "
        }

        def mainSql = """
                       SELECT
                        NW3.PERIODS,
                        NW3.OPENDT,
                        ${nosSql}
                        ${spnosSql}
                        0 END
                        FROM (
                            SELECT
                            NW3.OBJID,
                            NW3.TYPE,
                            NW3.PERIODS,
                            NW3.OPENDT
                            FROM NW300 NW3
                            WHERE 1 = :pNum
                            AND NW3.TYPE = :pType
                            AND ROWNUM <= :max
                            ORDER BY NW3.PERIODS DESC
                        ) NW3
                        LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                        GROUP BY NW3.PERIODS, NW3.OPENDT
                        ORDER BY NW3.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "03" //require
        condition.max = (params.int('max')?:25) > 200 ? 200 : (params.int('max')?:25) //require
        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getHistoryAnyalysis3(params) { //歷史數據: 3星彩, 4星彩
        def result = [:]

        result.columnIDXS = dataService."lotto${params.pType}".IDXs
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnIDXS.IDX.each { it ->
            result.columnsNOs.each { it2 ->
                nosSql += "DECODE(SUM(CASE WHEN NW31.NO = ${it2} AND NW31.OPIDX = ${it} THEN 1 ELSE 0 END),2,'SPNO',1,'NO','') NO${it}${it2}, "
            }
        }

        def mainSql = """
                       SELECT
                        NW3.PERIODS,
                        NW3.OPENDT,
                        ${nosSql}
                        0 END
                        FROM (
                            SELECT
                            NW3.OBJID,
                            NW3.TYPE,
                            NW3.PERIODS,
                            NW3.OPENDT
                            FROM NW300 NW3
                            WHERE 1 = :pNum
                            AND NW3.TYPE = :pType
                            AND ROWNUM <= :max
                            ORDER BY NW3.PERIODS DESC
                        ) NW3
                        LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                        GROUP BY NW3.PERIODS, NW3.OPENDT
                        ORDER BY NW3.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = (params.int('max')?:25) > 200 ? 200 : (params.int('max')?:25) //require

        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getHistoryAnyalysis4(params) { //歷史數據: 賓果
    }

    def getCntsOpenAnalysis1(params) { //出現次數分析: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "SUM(CASE WHEN NW31.NO = ${it} THEN 1 ELSE 0 END) NO${it}, "
        }

        def unspnoSql = ""
        if ((params.int('pUnSPNO') ?: 0)) {
            unspnoSql = "AND NW31.ISSPNO IN (0)"
        } else {
            unspnoSql = "AND NW31.ISSPNO IN (1,0)"
        }

        def mainSql = """
                            SELECT
                            ${nosSql}
                            0 END
                            FROM (
                                SELECT
                                NW3.OBJID,
                                NW3.TYPE,
                                NW3.PERIODS,
                                NW3.OPENDT
                                FROM NW300 NW3
                                WHERE 1 = :pNum
                                AND NW3.TYPE = :pType
                                AND ROWNUM <= :max
                                ORDER BY NW3.PERIODS DESC
                            ) NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            WHERE 1=1
                            ${unspnoSql}
                            ORDER BY NW3.PERIODS DESC
                        """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = (params.int('max')?:25) > 200 ? 200 : (params.int('max')?:25) //require

        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].max { it.value }.value
        result.list = resultList

        return result

    }

    def getCntsOpenAnalysis2(params) { //出現次數分析: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.columnsSPNOs = dataService."lotto${params.pType}".SPNOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 0 THEN 1 ELSE 0 END) NO${it}, "
        }

        def spnosSql = ""
        result.columnsSPNOs.each { it ->
            spnosSql += "SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 1 THEN 1 ELSE 0 END) SPNO${it}, "
        }

        def mainSql = """
                            SELECT
                            ${nosSql}
                            ${spnosSql}
                            0 END
                            FROM (
                                SELECT
                                NW3.OBJID,
                                NW3.TYPE,
                                NW3.PERIODS,
                                NW3.OPENDT
                                FROM NW300 NW3
                                WHERE 1 = :pNum
                                AND NW3.TYPE = :pType
                                AND ROWNUM <= :max
                                ORDER BY NW3.PERIODS DESC
                            ) NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            ORDER BY NW3.PERIODS DESC
                        """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = (params.int('max')?:25) > 200 ? 200 : (params.int('max')?:25) //require

        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].max { it.value }.value
        result.list = resultList
        return result

    }

    def getLastOpenAnalysis1(params) { //最久未開分析: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]

        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "MAX(NW3.FIXPERIODS) - NVL(MAX(CASE WHEN NW31.NO = ${it} THEN NW3.FIXPERIODS END),0) NO${it}, "
        }

        def unspnoSql = ""
        if ((params.int('pUnSPNO') ?: 0)) {
            unspnoSql = "AND NW31.ISSPNO IN (0)"
        } else {
            unspnoSql = "AND NW31.ISSPNO IN (1,0)"
        }

        def mainSql = """
                            SELECT
                            ${nosSql}
                            0 END
                            FROM (
                                SELECT
                                ROW_NUMBER() OVER(ORDER BY NW3T.OPENDT ASC,NW3T.PERIODS ASC) FIXPERIODS,
                                NW3T.*
                                FROM (
                                    SELECT
                                    NW3.OBJID,
                                    NW3.TYPE,
                                    NW3.PERIODS,
                                    NW3.OPENDT
                                    FROM NW300 NW3
                                    WHERE 1 = :pNum
                                    AND NW3.TYPE = :pType
                                    AND ROWNUM <= :max
                                    ORDER BY NW3.PERIODS DESC
                                ) NW3T
                            ) NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            WHERE 1=1
                            ${unspnoSql}
                            GROUP BY 1
                        """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = (params.int('max')?:25) > 200 ? 200 : (params.int('max')?:25) //require

        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].max { it.value }.value
        result.list = resultList

        return result
    }

    def getLastOpenAnalysis2(params) { //最久未開分析: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.columnsSPNOs = dataService."lotto${params.pType}".SPNOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "MAX(NW3.FIXPERIODS) - NVL(MAX(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 0 THEN NW3.FIXPERIODS END),0) NO${it}, "
        }

        def spnosSql = ""
        result.columnsSPNOs.each { it ->
            spnosSql += "MAX(NW3.FIXPERIODS) - NVL(MAX(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 1 THEN NW3.FIXPERIODS END),0) SPNO${it}, "
        }

        def mainSql = """
                            SELECT
                            ${nosSql}
                            ${spnosSql}
                            0 END
                            FROM (
                                SELECT
                                ROW_NUMBER() OVER(ORDER BY NW3T.OPENDT ASC,NW3T.PERIODS ASC) FIXPERIODS,
                                NW3T.*
                                FROM (
                                    SELECT
                                    NW3.OBJID,
                                    NW3.TYPE,
                                    NW3.PERIODS,
                                    NW3.OPENDT
                                    FROM NW300 NW3
                                    WHERE 1 = :pNum
                                    AND NW3.TYPE = :pType
                                    AND ROWNUM <= :max
                                    ORDER BY NW3.PERIODS DESC
                                ) NW3T
                            ) NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            GROUP BY 1
                        """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = (params.int('max')?:25) > 200 ? 200 : (params.int('max')?:25) //require
        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].max { it.value }.value
        result.list = resultList

        return result
    }

    def getLastNumberAnalysis1(params) { //尾數分析: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { (it.toInteger() - 1) % 10 }

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "SUM(CASE WHEN NW31.NO = ${it} THEN 1 ELSE 0 END) NO${it}, "
        }

        def unspnoSql = ""
        if ((params.int('pUnSPNO') ?: 0)) {
            unspnoSql = "AND NW31.ISSPNO IN (0)"
        } else {
            unspnoSql = "AND NW31.ISSPNO IN (1,0)"
        }

        def mainSql = """
                            SELECT
                            ${nosSql}
                            0 END
                            FROM (
                                SELECT
                                NW3.OBJID,
                                NW3.TYPE,
                                NW3.PERIODS,
                                NW3.OPENDT
                                FROM NW300 NW3
                                WHERE 1 = :pNum
                                AND NW3.TYPE = :pType
                                AND ROWNUM <= :max
                                ORDER BY NW3.PERIODS DESC
                            ) NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            WHERE 1=1
                            ${unspnoSql}
                            ORDER BY NW3.PERIODS DESC
                        """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = (params.int('max')?:25) > 200 ? 200 : (params.int('max')?:25) //require

        def resultList = query.rows(mainSql, condition)

        result.createColumn = [] //算出需要產生td欄位
        def cnts = 0
        result.columnsNOs.collect { it.toInteger() % 10 }.unique().each { it ->
            cnts += result.columnsNOs.findAll { it2 -> (it2.toInteger() % 10) == it }.size()
            result.createColumn += cnts
        }

        def sumCnts = 0
        def sumIndex = 0;
        result.columnsCNTS = []
        result.columnsNOs.eachWithIndex { elem, index ->
            sumCnts += resultList[0]."NO${elem}"
            sumIndex += 1
            if (index + 1 in result.createColumn) {
                result.columnsCNTS += [
                        column: sumIndex,
                        num   : sumCnts
                ]
                sumCnts = 0
                sumIndex = 0
            }
        }
        result.maxNum = result.columnsCNTS.num.max()
        result.list = resultList

        return result
    }

    def getLastNumberAnalysis2(params) { //尾數分析: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { (it.toInteger() - 1) % 10 }
        result.columnsSPNOs = dataService."lotto${params.pType}".SPNOs.sort { (it.toInteger() - 1) % 10 }

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 0 THEN 1 ELSE 0 END) NO${it}, "
        }

        def spnosSql = ""
        result.columnsSPNOs.each { it ->
            spnosSql += "SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 1 THEN 1 ELSE 0 END) SPNO${it}, "
        }

        def mainSql = """
                            SELECT
                            ${nosSql}
                            ${spnosSql}
                            0 END
                            FROM (
                                SELECT
                                NW3.OBJID,
                                NW3.TYPE,
                                NW3.PERIODS,
                                NW3.OPENDT
                                FROM NW300 NW3
                                WHERE 1 = :pNum
                                AND NW3.TYPE = :pType
                                AND ROWNUM <= :max
                                ORDER BY NW3.PERIODS DESC
                            ) NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            ORDER BY NW3.PERIODS DESC
                        """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = (params.int('max')?:25) > 200 ? 200 : (params.int('max')?:25) //require

        def resultList = query.rows(mainSql, condition)

        result.createColumn = [] //算出需要產生td欄位
        def cnts = 0
        result.columnsNOs.collect { it.toInteger() % 10 }.unique().each { it ->
            cnts += result.columnsNOs.findAll { it2 -> (it2.toInteger() % 10) == it }.size()
            result.createColumn += cnts
        }

        result.columnsSPNOs.collect { it.toInteger() % 10 }.unique().each { it ->
            cnts += result.columnsSPNOs.findAll { it2 -> (it2.toInteger() % 10) == it }.size()
            result.createColumn += cnts
        }

        def sumCnts = 0
        def sumIndex = 0;
        result.columnsCNTS = []
        result.columnsNOs.eachWithIndex { elem, index ->
            sumCnts += resultList[0]."NO${elem}"
            sumIndex += 1
            if (index + 1 in result.createColumn) {
                result.columnsCNTS += [
                        column: sumIndex,
                        num   : sumCnts
                ]
                sumCnts = 0
                sumIndex = 0
            }
        }

        result.columnsSPNOs.eachWithIndex { elem, index ->
            result.columnsCNTS += [
                    column: 1,
                    num   : resultList[0]."SPNO${elem}"
            ]
        }

        result.maxNum = result.columnsCNTS.num.max()
        result.list = resultList

        return result
    }


    def getContinueAnyalysis1(params) { // 連續分析: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "DECODE(SUM(CASE WHEN NW31.NO = ${it} THEN (CASE WHEN (NVL(NW31B.NO,0) > 0 OR NVL(NW31C.NO,0) > 0) THEN 3 ELSE (CASE WHEN NW31.ISSPNO = 1 THEN 2 ELSE 1 END) END) ELSE 0 END),3,'CTNO',2,'SPNO',1,'NO','') NO${it}, "
        }

        def unspnoSql = ""
        if ((params.int('pUnSPNO') ?: 0)) {
            unspnoSql = "AND NW31.ISSPNO IN (0)"
        } else {
            unspnoSql = "AND NW31.ISSPNO IN (1,0)"
        }

        def mainSql = """
                       SELECT
                        NW3.PERIODS,
                        NW3.OPENDT,
                        ${nosSql}
                        0 END
                        FROM (
                            SELECT
                            NW3.OBJID,
                            NW3.TYPE,
                            NW3.PERIODS,
                            NW3.OPENDT
                            FROM NW300 NW3
                            WHERE 1 = :pNum
                            AND NW3.TYPE = :pType
                            AND ROWNUM <= :max
                            ORDER BY NW3.PERIODS DESC
                        ) NW3
                        LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                        LEFT JOIN NW301 NW31B ON NW31.NW300ID = NW31B.NW300ID AND NW31.NO = (NW31B.NO+1) AND NW31.ISSPNO = NW31B.ISSPNO
                        LEFT JOIN NW301 NW31C ON NW31.NW300ID = NW31C.NW300ID AND NW31.NO = (NW31C.NO-1) AND NW31.ISSPNO = NW31C.ISSPNO
                        WHERE 1=1
                        ${unspnoSql}
                        GROUP BY NW3.PERIODS, NW3.OPENDT
                        ORDER BY NW3.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = (params.int('max')?:25) > 200 ? 200 : (params.int('max')?:25) //require

        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getContinueAnyalysis2(params) { //連續分析: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.columnsSPNOs = dataService."lotto${params.pType}".SPNOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "DECODE(SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 0 THEN (CASE WHEN (NVL(NW31B.NO,0) > 0 OR NVL(NW31C.NO,0) > 0) THEN 3 ELSE 1 END) ELSE 0 END),3,'CTNO',2,'SPNO',1,'NO','') NO${it}, "
        }

        def spnosSql = ""
        result.columnsSPNOs.each { it ->
            spnosSql += "DECODE(SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 1 THEN 2 ELSE 0 END),2,'SPNO',1,'NO','') SPNO${it}, "
        }

        def mainSql = """
                       SELECT
                        NW3.PERIODS,
                        NW3.OPENDT,
                        ${nosSql}
                        ${spnosSql}
                        0 END
                        FROM (
                            SELECT
                            NW3.OBJID,
                            NW3.TYPE,
                            NW3.PERIODS,
                            NW3.OPENDT
                            FROM NW300 NW3
                            WHERE 1 = :pNum
                            AND NW3.TYPE = :pType
                            AND ROWNUM <= :max
                            ORDER BY NW3.PERIODS DESC
                        ) NW3
                        LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                        LEFT JOIN NW301 NW31B ON NW31.NW300ID = NW31B.NW300ID AND NW31.NO = (NW31B.NO+1) AND NW31.ISSPNO = NW31B.ISSPNO
                        LEFT JOIN NW301 NW31C ON NW31.NW300ID = NW31C.NW300ID AND NW31.NO = (NW31C.NO-1) AND NW31.ISSPNO = NW31C.ISSPNO
                        GROUP BY NW3.PERIODS, NW3.OPENDT
                        ORDER BY NW3.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = (params.int('max')?:25) > 200 ? 200 : (params.int('max')?:25) //require

        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }


    def getRepeatAnyalysis1(params) { // 連開分析: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = "", nosSql2 = ""
        result.columnsNOs.each { it ->
            nosSql += "DECODE((case when (NW3.NO${it} > 0 and (LEAD(NW3.NO${it}) OVER (ORDER BY NW3.PERIODS DESC) > 0)) or (NW3.NO${it} > 0 and (LAG(NW3.NO${it}) OVER (ORDER BY NW3.PERIODS DESC)) > 0) then 4 ELSE NW3.NO${it} END),4,'RPNO',2,'SPNO',1,'NO','') NO${it}, "
            nosSql2 += "SUM(CASE WHEN NW31.NO = ${it} THEN (CASE WHEN NW31.ISSPNO = 1 THEN 2 ELSE 1 END) ELSE 0 END) NO${it}, "
        }

        def unspnoSql = ""
        if ((params.int('pUnSPNO') ?: 0)) {
            unspnoSql = "AND NW31.ISSPNO IN (0)"
        } else {
            unspnoSql = "AND NW31.ISSPNO IN (1,0)"
        }

        def mainSql = """
                        SELECT
                        NW3.PERIODS,
                        NW3.OPENDT,
                        ${nosSql}
                        0 END
                        FROM ( SELECT
                            NW3.PERIODS,
                            NW3.OPENDT,
                            ${nosSql2}
                            0 END
                            FROM (
                                SELECT
                                NW3.OBJID,
                                NW3.TYPE,
                                NW3.PERIODS,
                                NW3.OPENDT
                                FROM NW300 NW3
                                WHERE 1 = :pNum
                                AND NW3.TYPE = :pType
                                AND ROWNUM <= :max
                                ORDER BY NW3.PERIODS DESC
                            ) NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            WHERE 1=1
                            ${unspnoSql}
                            GROUP BY NW3.PERIODS, NW3.OPENDT
                        ) NW3
                        ORDER BY NW3.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.int('max') ?: 25 //require

        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }


    def getRepeatAnyalysis2(params) { // 連開分析: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.columnsSPNOs = dataService."lotto${params.pType}".SPNOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = "", nosSql2 = ""
        result.columnsNOs.each { it ->
            nosSql += "DECODE((case when (NW3.NO${it} > 0 and (LEAD(NW3.NO${it}) OVER (ORDER BY NW3.PERIODS DESC) > 0)) or (NW3.NO${it} > 0 and (LAG(NW3.NO${it}) OVER (ORDER BY NW3.PERIODS DESC)) > 0) then 4 ELSE NW3.NO${it} END),4,'RPNO',2,'SPNO',1,'NO','') NO${it}, "
            nosSql2 += "SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 0 THEN 1 ELSE 0 END) NO${it}, "
        }

        def spnosSql = "", spnosSql2 = ""
        result.columnsSPNOs.each { it ->
            spnosSql += "DECODE((case when (NW3.SPNO${it} > 0 and (LEAD(NW3.SPNO${it}) OVER (ORDER BY NW3.PERIODS DESC) > 0)) or (NW3.SPNO${it} > 0 and (LAG(NW3.SPNO${it}) OVER (ORDER BY NW3.PERIODS DESC)) > 0) then 4 ELSE NW3.SPNO${it} END),4,'RPNO',2,'SPNO',1,'NO','') SPNO${it}, "
            spnosSql2 += "SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 1 THEN 2 ELSE 0 END) SPNO${it}, "
        }

        def mainSql = """
                        SELECT
                        NW3.PERIODS,
                        NW3.OPENDT,
                        ${nosSql}
                        ${spnosSql}
                        0 END
                        FROM ( SELECT
                            NW3.PERIODS,
                            NW3.OPENDT,
                            ${nosSql2}
                            ${spnosSql2}
                            0 END
                            FROM (
                                SELECT
                                NW3.OBJID,
                                NW3.TYPE,
                                NW3.PERIODS,
                                NW3.OPENDT
                                FROM NW300 NW3
                                WHERE 1 = :pNum
                                AND NW3.TYPE = :pType
                                AND ROWNUM <= :max
                                ORDER BY NW3.PERIODS DESC
                            ) NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            GROUP BY NW3.PERIODS, NW3.OPENDT
                        ) NW3
                        ORDER BY NW3.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.int('max') ?: 25 //require

//        println "sql = " + toolsService.transPRSSql(mainSql, condition)

        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getBingoNewestDays(params) { //查詢賓果資料最近14天
        def query = new Sql(dataSource)

        def mainSql = """
                        SELECT
                        NW3.OPENDT
                        FROM (
                            SELECT
                            DISTINCT TO_CHAR(NW3.OPENDT, 'YYYYMMDD') OPENDT
                            FROM NW300 NW3
                            WHERE 1=1
                            AND NW3.TYPE = '11'
                            ORDER BY OPENDT DESC
                        ) NW3
                        WHERE 1=1
                        AND ROWNUM <= 14
                  """

        def resultList = query.rows(mainSql)?.OPENDT

        return resultList

    }

    def getBingoAnyalysis4(params) { // 賓果開獎號碼
        def result = [:]

        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }

        def query = new Sql(dataSource)

        def nosSql = "", spNosSql = "", rcntNosSql = "", lcntNosSql = "", repNosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "NW3.NO${it}, "
            spNosSql += "NW3.SPNO${it}, "
            rcntNosSql += "NW3.RCNTNO${it}, "
            rcntNosSql += "NW3.LCNTNO${it}, "
            repNosSql += "(CASE WHEN (NW3.NO${it} > 0 AND (LEAD(NW3.NO${it}) OVER (ORDER BY NW3.PERIODS DESC) > 0)) THEN 1 ELSE 0 END) REPNO${it}, "
        }

        def nosSql2 = "", spNosSql2 = "", rcntNosSql2= "", lcntNosSql2 = ""
        result.columnsNOs.each { it ->
            nosSql2 += "SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 0 THEN 1 ELSE 0 END) NO${it}, "
            spNosSql2 += "SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 1 THEN 1 ELSE 0 END) SPNO${it}, "
            rcntNosSql2 += "SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 0 AND NVL(NW31B.NO,0) > 0 THEN 1 ELSE 0 END) RCNTNO${it}, "
            rcntNosSql2 += "SUM(CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 0 AND NVL(NW31C.NO,0) > 0 THEN 1 ELSE 0 END) LCNTNO${it}, "
        }

        def mainSql = """
                        SELECT
                        NW3.PERIODS,
                        NW3.OPENDT,
                        NW3.RESULT,
                        ${nosSql}
                        ${spNosSql}
                        ${rcntNosSql}
                        ${lcntNosSql}
                        ${repNosSql}
                        0 END
                        FROM ( SELECT
                            NW3.PERIODS,
                            NW3.OPENDT,
                            NW3.RESULT,
                            ${nosSql2}
                            ${spNosSql2}
                            ${rcntNosSql2}
                            ${lcntNosSql2}
                            0 END
                            FROM (
                                SELECT
                                NW3.OBJID,
                                NW3.TYPE,
                                NW3.PERIODS,
                                NW3.OPENDT,
                                NW3.RESULT
                                FROM NW300 NW3
                                WHERE 1 = :pNum
                                AND NW3.TYPE = :pType
                                AND ROWNUM <= :max
                                AND TRUNC(NW3.OPENDT) = TO_DATE(:pOpendt,'yyyymmdd')
                                ORDER BY NW3.PERIODS DESC
                            ) NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            LEFT JOIN NW301 NW31B ON NW31.NW300ID = NW31B.NW300ID AND NW31.NO = (NW31B.NO+1) AND NW31.ISSPNO = NW31B.ISSPNO
                            LEFT JOIN NW301 NW31C ON NW31.NW300ID = NW31C.NW300ID AND NW31.NO = (NW31C.NO-1) AND NW31.ISSPNO = NW31C.ISSPNO
                            GROUP BY NW3.PERIODS, NW3.OPENDT,NW3.RESULT
                        ) NW3
                        ORDER BY NW3.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "11" //require
        condition.pOpendt = params.pOpendt ?: "20150906"
        condition.max = params.int('max') ?: 203 //require

//        println "sql = " + toolsService.transPRSSql(mainSql, condition)
        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    /**
     * 賓果分析: 本期球號
     * @return
     */
    def getbingoAnalysisA() {
        def s = new Sql(dataSource)
        def sql = """
select
LPAD(a.NO,2,'0') NO,
(
case when a.no in (
   select x.no from nw301 x where x.nw300id in(
      select y.objid from nw300 y where y.type = '11' and y.PERIODS = (
      select max(x.aa)-1 from (
select max(B.PERIODS) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
      )
   )
) then 3 else 1 end
) ISC,
(
select max(x.aa) from (
select max(B.PERIODS) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
) PERIODS
 from nw301 a
where a.nw300id = (
select c.objid from nw300 c
where C.TYPE = '11'
and C.PERIODS =
(
select max(x.aa) from (
select max(B.PERIODS) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
)
)
and A.ISSPNO = 0
order by A.NO
                  """

        def result = s.rows(sql)

        return result
    }

    /**
     * 賓果分析: 熱門球號
     * @return
     */
    def getbingoAnalysisB() {
        def s = new Sql(dataSource)
        def sql = """
select
LPAD (x.NO, 2, '0') NO, x.CNT1 NUM
from (
SELECT
NW3.OPENDT,
NW31.NO,
COUNT(1) CNT1,
(MAX(MAX(NW3.CNT)) OVER()) - MAX(NW3.CNT) CNT2,
0 END
FROM (
    SELECT
    ROW_NUMBER() OVER(ORDER BY NW3.PERIODS ASC) CNT,
    NW3.OBJID,
    NW3.TYPE,
    NW3.PERIODS,
    NW3.OPENDT
    FROM NW300 NW3
    WHERE 1 = 1
    AND NW3.TYPE = '11'
    --and trunc(nw3.OPENDT) = to_date('2015/08/25','yyyy/MM/dd')
    and trunc(nw3.OPENDT) = (
    select max(x.aa) from (
select max(trunc(B.OPENDT)) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
    )
) NW3
LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID AND NW31.ISSPNO = 0
WHERE 1=1
GROUP BY NW3.OPENDT,NW31.NO
ORDER BY COUNT(1) DESC
) x
where rownum <= 10
order by x.CNT1 desc, x.no
                  """

        def result = s.rows(sql)

        return result
    }

    /**
     * 賓果分析: 冷門球號
     * @return
     */
    def getbingoAnalysisC() {
        def s = new Sql(dataSource)
        def sql = """
select
LPAD (x.NO, 2, '0') NO, x.CNT2 NUM
from (
SELECT
NW3.OPENDT,
NW31.NO,
COUNT(1) CNT1,
(MAX(MAX(NW3.CNT)) OVER()) - MAX(NW3.CNT) CNT2,
0 END
FROM (
    SELECT
    ROW_NUMBER() OVER(ORDER BY NW3.PERIODS ASC) CNT,
    NW3.OBJID,
    NW3.TYPE,
    NW3.PERIODS,
    NW3.OPENDT
    FROM NW300 NW3
    WHERE 1 = 1
    AND NW3.TYPE = '11'
    --and trunc(nw3.OPENDT) = to_date('2015/08/25','yyyy/MM/dd')
    and trunc(nw3.OPENDT) =(
    select max(x.aa) from (
select max(trunc(B.OPENDT)) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
    )
) NW3
LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID AND NW31.ISSPNO = 0
WHERE 1=1
GROUP BY NW3.OPENDT,NW31.NO
ORDER BY COUNT(1) DESC
) x
where rownum <= 10
order by x.CNT2, X.NO
                  """

        def result = s.rows(sql)

        return result
    }

    /**
     * 賓果分析: 熱門連莊
     * @return
     */
    def getbingoAnalysisD() {
        def s = new Sql(dataSource)
        def sql = """
                  select
sum(ISC01) ISC01,
sum(ISC02) ISC02,
sum(ISC03) ISC03,
sum(ISC04) ISC04,
sum(ISC05) ISC05,
sum(ISC06) ISC06,
sum(ISC07) ISC07,
sum(ISC08) ISC08,
sum(ISC09) ISC09,
sum(ISC10) ISC10,
sum(ISC11) ISC11,
sum(ISC12) ISC12,
sum(ISC13) ISC13,
sum(ISC14) ISC14,
sum(ISC15) ISC15,
sum(ISC16) ISC16,
sum(ISC17) ISC17,
sum(ISC18) ISC18,
sum(ISC19) ISC19,
sum(ISC20) ISC20,
sum(ISC21) ISC21,
sum(ISC22) ISC22,
sum(ISC23) ISC23,
sum(ISC24) ISC24,
sum(ISC25) ISC25,
sum(ISC26) ISC26,
sum(ISC27) ISC27,
sum(ISC28) ISC28,
sum(ISC29) ISC29,
sum(ISC30) ISC30,
sum(ISC31) ISC31,
sum(ISC32) ISC32,
sum(ISC33) ISC33,
sum(ISC34) ISC34,
sum(ISC35) ISC35,
sum(ISC36) ISC36,
sum(ISC37) ISC37,
sum(ISC38) ISC38,
sum(ISC39) ISC39,
sum(ISC40) ISC40,
sum(ISC41) ISC41,
sum(ISC42) ISC42,
sum(ISC43) ISC43,
sum(ISC44) ISC44,
sum(ISC45) ISC45,
sum(ISC46) ISC46,
sum(ISC47) ISC47,
sum(ISC48) ISC48,
sum(ISC49) ISC49,
sum(ISC50) ISC50,
sum(ISC51) ISC51,
sum(ISC52) ISC52,
sum(ISC53) ISC53,
sum(ISC54) ISC54,
sum(ISC55) ISC55,
sum(ISC56) ISC56,
sum(ISC57) ISC57,
sum(ISC58) ISC58,
sum(ISC59) ISC59,
sum(ISC60) ISC60,
sum(ISC61) ISC61,
sum(ISC62) ISC62,
sum(ISC63) ISC63,
sum(ISC64) ISC64,
sum(ISC65) ISC65,
sum(ISC66) ISC66,
sum(ISC67) ISC67,
sum(ISC68) ISC68,
sum(ISC69) ISC69,
sum(ISC70) ISC70,
sum(ISC71) ISC71,
sum(ISC72) ISC72,
sum(ISC73) ISC73,
sum(ISC74) ISC74,
sum(ISC75) ISC75,
sum(ISC76) ISC76,
sum(ISC77) ISC77,
sum(ISC78) ISC78,
sum(ISC79) ISC79,
sum(ISC80) ISC80
from (
select y.PERIODS,
(case when y.NO01 = 1 and lag(y.no01) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC01,
(case when y.NO02 = 1 and lag(y.no02) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC02,
(case when y.NO03 = 1 and lag(y.no03) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC03,
(case when y.NO04 = 1 and lag(y.no04) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC04,
(case when y.NO05 = 1 and lag(y.no05) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC05,
(case when y.NO06 = 1 and lag(y.no06) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC06,
(case when y.NO07 = 1 and lag(y.no07) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC07,
(case when y.NO08 = 1 and lag(y.no08) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC08,
(case when y.NO09 = 1 and lag(y.no09) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC09,
(case when y.NO10 = 1 and lag(y.no10) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC10,
(case when y.NO11 = 1 and lag(y.no11) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC11,
(case when y.NO12 = 1 and lag(y.no12) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC12,
(case when y.NO13 = 1 and lag(y.no13) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC13,
(case when y.NO14 = 1 and lag(y.no14) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC14,
(case when y.NO15 = 1 and lag(y.no15) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC15,
(case when y.NO16 = 1 and lag(y.no16) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC16,
(case when y.NO17 = 1 and lag(y.no17) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC17,
(case when y.NO18 = 1 and lag(y.no18) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC18,
(case when y.NO19 = 1 and lag(y.no19) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC19,
(case when y.NO20 = 1 and lag(y.no20) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC20,
(case when y.NO21 = 1 and lag(y.no21) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC21,
(case when y.NO22 = 1 and lag(y.no22) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC22,
(case when y.NO23 = 1 and lag(y.no23) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC23,
(case when y.NO24 = 1 and lag(y.no24) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC24,
(case when y.NO25 = 1 and lag(y.no25) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC25,
(case when y.NO26 = 1 and lag(y.no26) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC26,
(case when y.NO27 = 1 and lag(y.no27) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC27,
(case when y.NO28 = 1 and lag(y.no28) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC28,
(case when y.NO29 = 1 and lag(y.no29) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC29,
(case when y.NO30 = 1 and lag(y.no30) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC30,
(case when y.NO31 = 1 and lag(y.no31) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC31,
(case when y.NO32 = 1 and lag(y.no32) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC32,
(case when y.NO33 = 1 and lag(y.no33) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC33,
(case when y.NO34 = 1 and lag(y.no34) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC34,
(case when y.NO35 = 1 and lag(y.no35) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC35,
(case when y.NO36 = 1 and lag(y.no36) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC36,
(case when y.NO37 = 1 and lag(y.no37) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC37,
(case when y.NO38 = 1 and lag(y.no38) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC38,
(case when y.NO39 = 1 and lag(y.no39) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC39,
(case when y.NO40 = 1 and lag(y.no40) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC40,
(case when y.NO41 = 1 and lag(y.no41) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC41,
(case when y.NO42 = 1 and lag(y.no42) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC42,
(case when y.NO43 = 1 and lag(y.no43) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC43,
(case when y.NO44 = 1 and lag(y.no44) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC44,
(case when y.NO45 = 1 and lag(y.no45) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC45,
(case when y.NO46 = 1 and lag(y.no46) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC46,
(case when y.NO47 = 1 and lag(y.no47) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC47,
(case when y.NO48 = 1 and lag(y.no48) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC48,
(case when y.NO49 = 1 and lag(y.no49) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC49,
(case when y.NO50 = 1 and lag(y.no50) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC50,
(case when y.NO51 = 1 and lag(y.no51) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC51,
(case when y.NO52 = 1 and lag(y.no52) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC52,
(case when y.NO53 = 1 and lag(y.no53) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC53,
(case when y.NO54 = 1 and lag(y.no54) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC54,
(case when y.NO55 = 1 and lag(y.no55) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC55,
(case when y.NO56 = 1 and lag(y.no56) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC56,
(case when y.NO57 = 1 and lag(y.no57) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC57,
(case when y.NO58 = 1 and lag(y.no58) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC58,
(case when y.NO59 = 1 and lag(y.no59) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC59,
(case when y.NO60 = 1 and lag(y.no60) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC60,
(case when y.NO61 = 1 and lag(y.no61) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC61,
(case when y.NO62 = 1 and lag(y.no62) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC62,
(case when y.NO63 = 1 and lag(y.no63) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC63,
(case when y.NO64 = 1 and lag(y.no64) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC64,
(case when y.NO65 = 1 and lag(y.no65) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC65,
(case when y.NO66 = 1 and lag(y.no66) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC66,
(case when y.NO67 = 1 and lag(y.no67) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC67,
(case when y.NO68 = 1 and lag(y.no68) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC68,
(case when y.NO69 = 1 and lag(y.no69) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC69,
(case when y.NO70 = 1 and lag(y.no70) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC70,
(case when y.NO71 = 1 and lag(y.no71) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC71,
(case when y.NO72 = 1 and lag(y.no72) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC72,
(case when y.NO73 = 1 and lag(y.no73) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC73,
(case when y.NO74 = 1 and lag(y.no74) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC74,
(case when y.NO75 = 1 and lag(y.no75) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC75,
(case when y.NO76 = 1 and lag(y.no76) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC76,
(case when y.NO77 = 1 and lag(y.no77) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC77,
(case when y.NO78 = 1 and lag(y.no78) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC78,
(case when y.NO79 = 1 and lag(y.no79) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC79,
(case when y.NO80 = 1 and lag(y.no80) over (order by y.PERIODS) = 1 then 1 else 0 end) ISC80
from (
SELECT
       A.PERIODS,
       sum((case when b.no = 1 then 1 else 0 end)) NO01,
       sum((case when b.no = 2 then 1 else 0 end)) NO02,
       sum((case when b.no = 3 then 1 else 0 end)) NO03,
       sum((case when b.no = 4 then 1 else 0 end)) NO04,
       sum((case when b.no = 5 then 1 else 0 end)) NO05,
       sum((case when b.no = 6 then 1 else 0 end)) NO06,
       sum((case when b.no = 7 then 1 else 0 end)) NO07,
       sum((case when b.no = 8 then 1 else 0 end)) NO08,
       sum((case when b.no = 9 then 1 else 0 end)) NO09,
       sum((case when b.no =10 then 1 else 0 end)) NO10,
       sum((case when b.no =11 then 1 else 0 end)) NO11,
       sum((case when b.no =12 then 1 else 0 end)) NO12,
       sum((case when b.no =13 then 1 else 0 end)) NO13,
       sum((case when b.no =14 then 1 else 0 end)) NO14,
       sum((case when b.no =15 then 1 else 0 end)) NO15,
       sum((case when b.no =16 then 1 else 0 end)) NO16,
       sum((case when b.no =17 then 1 else 0 end)) NO17,
       sum((case when b.no =18 then 1 else 0 end)) NO18,
       sum((case when b.no =19 then 1 else 0 end)) NO19,
       sum((case when b.no =20 then 1 else 0 end)) NO20,
       sum((case when b.no =21 then 1 else 0 end)) NO21,
       sum((case when b.no =22 then 1 else 0 end)) NO22,
       sum((case when b.no =23 then 1 else 0 end)) NO23,
       sum((case when b.no =24 then 1 else 0 end)) NO24,
       sum((case when b.no =25 then 1 else 0 end)) NO25,
       sum((case when b.no =26 then 1 else 0 end)) NO26,
       sum((case when b.no =27 then 1 else 0 end)) NO27,
       sum((case when b.no =28 then 1 else 0 end)) NO28,
       sum((case when b.no =29 then 1 else 0 end)) NO29,
       sum((case when b.no =30 then 1 else 0 end)) NO30,
       sum((case when b.no =31 then 1 else 0 end)) NO31,
       sum((case when b.no =32 then 1 else 0 end)) NO32,
       sum((case when b.no =33 then 1 else 0 end)) NO33,
       sum((case when b.no =34 then 1 else 0 end)) NO34,
       sum((case when b.no =35 then 1 else 0 end)) NO35,
       sum((case when b.no =36 then 1 else 0 end)) NO36,
       sum((case when b.no =37 then 1 else 0 end)) NO37,
       sum((case when b.no =38 then 1 else 0 end)) NO38,
       sum((case when b.no =39 then 1 else 0 end)) NO39,
       sum((case when b.no =40 then 1 else 0 end)) NO40,
       sum((case when b.no =41 then 1 else 0 end)) NO41,
       sum((case when b.no =42 then 1 else 0 end)) NO42,
       sum((case when b.no =43 then 1 else 0 end)) NO43,
       sum((case when b.no =44 then 1 else 0 end)) NO44,
       sum((case when b.no =45 then 1 else 0 end)) NO45,
       sum((case when b.no =46 then 1 else 0 end)) NO46,
       sum((case when b.no =47 then 1 else 0 end)) NO47,
       sum((case when b.no =48 then 1 else 0 end)) NO48,
       sum((case when b.no =49 then 1 else 0 end)) NO49,
       sum((case when b.no =50 then 1 else 0 end)) NO50,
       sum((case when b.no =51 then 1 else 0 end)) NO51,
       sum((case when b.no =52 then 1 else 0 end)) NO52,
       sum((case when b.no =53 then 1 else 0 end)) NO53,
       sum((case when b.no =54 then 1 else 0 end)) NO54,
       sum((case when b.no =55 then 1 else 0 end)) NO55,
       sum((case when b.no =56 then 1 else 0 end)) NO56,
       sum((case when b.no =57 then 1 else 0 end)) NO57,
       sum((case when b.no =58 then 1 else 0 end)) NO58,
       sum((case when b.no =59 then 1 else 0 end)) NO59,
       sum((case when b.no =60 then 1 else 0 end)) NO60,
       sum((case when b.no =61 then 1 else 0 end)) NO61,
       sum((case when b.no =62 then 1 else 0 end)) NO62,
       sum((case when b.no =63 then 1 else 0 end)) NO63,
       sum((case when b.no =64 then 1 else 0 end)) NO64,
       sum((case when b.no =65 then 1 else 0 end)) NO65,
       sum((case when b.no =66 then 1 else 0 end)) NO66,
       sum((case when b.no =67 then 1 else 0 end)) NO67,
       sum((case when b.no =68 then 1 else 0 end)) NO68,
       sum((case when b.no =69 then 1 else 0 end)) NO69,
       sum((case when b.no =70 then 1 else 0 end)) NO70,
       sum((case when b.no =71 then 1 else 0 end)) NO71,
       sum((case when b.no =72 then 1 else 0 end)) NO72,
       sum((case when b.no =73 then 1 else 0 end)) NO73,
       sum((case when b.no =74 then 1 else 0 end)) NO74,
       sum((case when b.no =75 then 1 else 0 end)) NO75,
       sum((case when b.no =76 then 1 else 0 end)) NO76,
       sum((case when b.no =77 then 1 else 0 end)) NO77,
       sum((case when b.no =78 then 1 else 0 end)) NO78,
       sum((case when b.no =79 then 1 else 0 end)) NO79,
       sum((case when b.no =80 then 1 else 0 end)) NO80
  FROM NW300 a LEFT JOIN nw301 b ON a.objid = b.nw300id
 WHERE     1 = 1
       AND a.TYPE = '11'
       --AND trunc(a.OPENDT) = TO_DATE ('2015/08/25', 'yyyy/MM/dd')
       AND trunc(a.OPENDT) = (
    select max(x.aa) from (
select max(trunc(B.OPENDT)) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
    )
       and B.ISSPNO = 0
       group by a.PERIODS
       order by a.PERIODS
       ) y
       order by y.PERIODS
       ) z
                  """

        def result = s.firstRow(sql)

        return result
    }

    /**
     * 賓果分析: 熱門跳期
     * @return
     */
    def getbingoAnalysisE() {
        def s = new Sql(dataSource)
        def sql = """
                  select
sum(ISC01) ISC01,
sum(ISC02) ISC02,
sum(ISC03) ISC03,
sum(ISC04) ISC04,
sum(ISC05) ISC05,
sum(ISC06) ISC06,
sum(ISC07) ISC07,
sum(ISC08) ISC08,
sum(ISC09) ISC09,
sum(ISC10) ISC10,
sum(ISC11) ISC11,
sum(ISC12) ISC12,
sum(ISC13) ISC13,
sum(ISC14) ISC14,
sum(ISC15) ISC15,
sum(ISC16) ISC16,
sum(ISC17) ISC17,
sum(ISC18) ISC18,
sum(ISC19) ISC19,
sum(ISC20) ISC20,
sum(ISC21) ISC21,
sum(ISC22) ISC22,
sum(ISC23) ISC23,
sum(ISC24) ISC24,
sum(ISC25) ISC25,
sum(ISC26) ISC26,
sum(ISC27) ISC27,
sum(ISC28) ISC28,
sum(ISC29) ISC29,
sum(ISC30) ISC30,
sum(ISC31) ISC31,
sum(ISC32) ISC32,
sum(ISC33) ISC33,
sum(ISC34) ISC34,
sum(ISC35) ISC35,
sum(ISC36) ISC36,
sum(ISC37) ISC37,
sum(ISC38) ISC38,
sum(ISC39) ISC39,
sum(ISC40) ISC40,
sum(ISC41) ISC41,
sum(ISC42) ISC42,
sum(ISC43) ISC43,
sum(ISC44) ISC44,
sum(ISC45) ISC45,
sum(ISC46) ISC46,
sum(ISC47) ISC47,
sum(ISC48) ISC48,
sum(ISC49) ISC49,
sum(ISC50) ISC50,
sum(ISC51) ISC51,
sum(ISC52) ISC52,
sum(ISC53) ISC53,
sum(ISC54) ISC54,
sum(ISC55) ISC55,
sum(ISC56) ISC56,
sum(ISC57) ISC57,
sum(ISC58) ISC58,
sum(ISC59) ISC59,
sum(ISC60) ISC60,
sum(ISC61) ISC61,
sum(ISC62) ISC62,
sum(ISC63) ISC63,
sum(ISC64) ISC64,
sum(ISC65) ISC65,
sum(ISC66) ISC66,
sum(ISC67) ISC67,
sum(ISC68) ISC68,
sum(ISC69) ISC69,
sum(ISC70) ISC70,
sum(ISC71) ISC71,
sum(ISC72) ISC72,
sum(ISC73) ISC73,
sum(ISC74) ISC74,
sum(ISC75) ISC75,
sum(ISC76) ISC76,
sum(ISC77) ISC77,
sum(ISC78) ISC78,
sum(ISC79) ISC79,
sum(ISC80) ISC80
from (
select y.PERIODS,
(case when y.NO01 = 1 and lag(y.no01) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC01,
(case when y.NO02 = 1 and lag(y.no02) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC02,
(case when y.NO03 = 1 and lag(y.no03) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC03,
(case when y.NO04 = 1 and lag(y.no04) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC04,
(case when y.NO05 = 1 and lag(y.no05) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC05,
(case when y.NO06 = 1 and lag(y.no06) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC06,
(case when y.NO07 = 1 and lag(y.no07) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC07,
(case when y.NO08 = 1 and lag(y.no08) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC08,
(case when y.NO09 = 1 and lag(y.no09) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC09,
(case when y.NO10 = 1 and lag(y.no10) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC10,
(case when y.NO11 = 1 and lag(y.no11) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC11,
(case when y.NO12 = 1 and lag(y.no12) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC12,
(case when y.NO13 = 1 and lag(y.no13) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC13,
(case when y.NO14 = 1 and lag(y.no14) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC14,
(case when y.NO15 = 1 and lag(y.no15) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC15,
(case when y.NO16 = 1 and lag(y.no16) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC16,
(case when y.NO17 = 1 and lag(y.no17) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC17,
(case when y.NO18 = 1 and lag(y.no18) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC18,
(case when y.NO19 = 1 and lag(y.no19) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC19,
(case when y.NO20 = 1 and lag(y.no20) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC20,
(case when y.NO21 = 1 and lag(y.no21) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC21,
(case when y.NO22 = 1 and lag(y.no22) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC22,
(case when y.NO23 = 1 and lag(y.no23) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC23,
(case when y.NO24 = 1 and lag(y.no24) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC24,
(case when y.NO25 = 1 and lag(y.no25) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC25,
(case when y.NO26 = 1 and lag(y.no26) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC26,
(case when y.NO27 = 1 and lag(y.no27) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC27,
(case when y.NO28 = 1 and lag(y.no28) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC28,
(case when y.NO29 = 1 and lag(y.no29) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC29,
(case when y.NO30 = 1 and lag(y.no30) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC30,
(case when y.NO31 = 1 and lag(y.no31) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC31,
(case when y.NO32 = 1 and lag(y.no32) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC32,
(case when y.NO33 = 1 and lag(y.no33) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC33,
(case when y.NO34 = 1 and lag(y.no34) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC34,
(case when y.NO35 = 1 and lag(y.no35) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC35,
(case when y.NO36 = 1 and lag(y.no36) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC36,
(case when y.NO37 = 1 and lag(y.no37) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC37,
(case when y.NO38 = 1 and lag(y.no38) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC38,
(case when y.NO39 = 1 and lag(y.no39) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC39,
(case when y.NO40 = 1 and lag(y.no40) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC40,
(case when y.NO41 = 1 and lag(y.no41) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC41,
(case when y.NO42 = 1 and lag(y.no42) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC42,
(case when y.NO43 = 1 and lag(y.no43) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC43,
(case when y.NO44 = 1 and lag(y.no44) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC44,
(case when y.NO45 = 1 and lag(y.no45) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC45,
(case when y.NO46 = 1 and lag(y.no46) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC46,
(case when y.NO47 = 1 and lag(y.no47) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC47,
(case when y.NO48 = 1 and lag(y.no48) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC48,
(case when y.NO49 = 1 and lag(y.no49) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC49,
(case when y.NO50 = 1 and lag(y.no50) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC50,
(case when y.NO51 = 1 and lag(y.no51) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC51,
(case when y.NO52 = 1 and lag(y.no52) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC52,
(case when y.NO53 = 1 and lag(y.no53) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC53,
(case when y.NO54 = 1 and lag(y.no54) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC54,
(case when y.NO55 = 1 and lag(y.no55) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC55,
(case when y.NO56 = 1 and lag(y.no56) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC56,
(case when y.NO57 = 1 and lag(y.no57) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC57,
(case when y.NO58 = 1 and lag(y.no58) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC58,
(case when y.NO59 = 1 and lag(y.no59) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC59,
(case when y.NO60 = 1 and lag(y.no60) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC60,
(case when y.NO61 = 1 and lag(y.no61) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC61,
(case when y.NO62 = 1 and lag(y.no62) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC62,
(case when y.NO63 = 1 and lag(y.no63) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC63,
(case when y.NO64 = 1 and lag(y.no64) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC64,
(case when y.NO65 = 1 and lag(y.no65) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC65,
(case when y.NO66 = 1 and lag(y.no66) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC66,
(case when y.NO67 = 1 and lag(y.no67) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC67,
(case when y.NO68 = 1 and lag(y.no68) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC68,
(case when y.NO69 = 1 and lag(y.no69) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC69,
(case when y.NO70 = 1 and lag(y.no70) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC70,
(case when y.NO71 = 1 and lag(y.no71) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC71,
(case when y.NO72 = 1 and lag(y.no72) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC72,
(case when y.NO73 = 1 and lag(y.no73) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC73,
(case when y.NO74 = 1 and lag(y.no74) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC74,
(case when y.NO75 = 1 and lag(y.no75) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC75,
(case when y.NO76 = 1 and lag(y.no76) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC76,
(case when y.NO77 = 1 and lag(y.no77) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC77,
(case when y.NO78 = 1 and lag(y.no78) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC78,
(case when y.NO79 = 1 and lag(y.no79) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC79,
(case when y.NO80 = 1 and lag(y.no80) over (order by y.PERIODS) = 0 then 1 else 0 end) ISC80
from (
SELECT
       A.PERIODS,
       sum((case when b.no = 1 then 1 else 0 end)) NO01,
       sum((case when b.no = 2 then 1 else 0 end)) NO02,
       sum((case when b.no = 3 then 1 else 0 end)) NO03,
       sum((case when b.no = 4 then 1 else 0 end)) NO04,
       sum((case when b.no = 5 then 1 else 0 end)) NO05,
       sum((case when b.no = 6 then 1 else 0 end)) NO06,
       sum((case when b.no = 7 then 1 else 0 end)) NO07,
       sum((case when b.no = 8 then 1 else 0 end)) NO08,
       sum((case when b.no = 9 then 1 else 0 end)) NO09,
       sum((case when b.no =10 then 1 else 0 end)) NO10,
       sum((case when b.no =11 then 1 else 0 end)) NO11,
       sum((case when b.no =12 then 1 else 0 end)) NO12,
       sum((case when b.no =13 then 1 else 0 end)) NO13,
       sum((case when b.no =14 then 1 else 0 end)) NO14,
       sum((case when b.no =15 then 1 else 0 end)) NO15,
       sum((case when b.no =16 then 1 else 0 end)) NO16,
       sum((case when b.no =17 then 1 else 0 end)) NO17,
       sum((case when b.no =18 then 1 else 0 end)) NO18,
       sum((case when b.no =19 then 1 else 0 end)) NO19,
       sum((case when b.no =20 then 1 else 0 end)) NO20,
       sum((case when b.no =21 then 1 else 0 end)) NO21,
       sum((case when b.no =22 then 1 else 0 end)) NO22,
       sum((case when b.no =23 then 1 else 0 end)) NO23,
       sum((case when b.no =24 then 1 else 0 end)) NO24,
       sum((case when b.no =25 then 1 else 0 end)) NO25,
       sum((case when b.no =26 then 1 else 0 end)) NO26,
       sum((case when b.no =27 then 1 else 0 end)) NO27,
       sum((case when b.no =28 then 1 else 0 end)) NO28,
       sum((case when b.no =29 then 1 else 0 end)) NO29,
       sum((case when b.no =30 then 1 else 0 end)) NO30,
       sum((case when b.no =31 then 1 else 0 end)) NO31,
       sum((case when b.no =32 then 1 else 0 end)) NO32,
       sum((case when b.no =33 then 1 else 0 end)) NO33,
       sum((case when b.no =34 then 1 else 0 end)) NO34,
       sum((case when b.no =35 then 1 else 0 end)) NO35,
       sum((case when b.no =36 then 1 else 0 end)) NO36,
       sum((case when b.no =37 then 1 else 0 end)) NO37,
       sum((case when b.no =38 then 1 else 0 end)) NO38,
       sum((case when b.no =39 then 1 else 0 end)) NO39,
       sum((case when b.no =40 then 1 else 0 end)) NO40,
       sum((case when b.no =41 then 1 else 0 end)) NO41,
       sum((case when b.no =42 then 1 else 0 end)) NO42,
       sum((case when b.no =43 then 1 else 0 end)) NO43,
       sum((case when b.no =44 then 1 else 0 end)) NO44,
       sum((case when b.no =45 then 1 else 0 end)) NO45,
       sum((case when b.no =46 then 1 else 0 end)) NO46,
       sum((case when b.no =47 then 1 else 0 end)) NO47,
       sum((case when b.no =48 then 1 else 0 end)) NO48,
       sum((case when b.no =49 then 1 else 0 end)) NO49,
       sum((case when b.no =50 then 1 else 0 end)) NO50,
       sum((case when b.no =51 then 1 else 0 end)) NO51,
       sum((case when b.no =52 then 1 else 0 end)) NO52,
       sum((case when b.no =53 then 1 else 0 end)) NO53,
       sum((case when b.no =54 then 1 else 0 end)) NO54,
       sum((case when b.no =55 then 1 else 0 end)) NO55,
       sum((case when b.no =56 then 1 else 0 end)) NO56,
       sum((case when b.no =57 then 1 else 0 end)) NO57,
       sum((case when b.no =58 then 1 else 0 end)) NO58,
       sum((case when b.no =59 then 1 else 0 end)) NO59,
       sum((case when b.no =60 then 1 else 0 end)) NO60,
       sum((case when b.no =61 then 1 else 0 end)) NO61,
       sum((case when b.no =62 then 1 else 0 end)) NO62,
       sum((case when b.no =63 then 1 else 0 end)) NO63,
       sum((case when b.no =64 then 1 else 0 end)) NO64,
       sum((case when b.no =65 then 1 else 0 end)) NO65,
       sum((case when b.no =66 then 1 else 0 end)) NO66,
       sum((case when b.no =67 then 1 else 0 end)) NO67,
       sum((case when b.no =68 then 1 else 0 end)) NO68,
       sum((case when b.no =69 then 1 else 0 end)) NO69,
       sum((case when b.no =70 then 1 else 0 end)) NO70,
       sum((case when b.no =71 then 1 else 0 end)) NO71,
       sum((case when b.no =72 then 1 else 0 end)) NO72,
       sum((case when b.no =73 then 1 else 0 end)) NO73,
       sum((case when b.no =74 then 1 else 0 end)) NO74,
       sum((case when b.no =75 then 1 else 0 end)) NO75,
       sum((case when b.no =76 then 1 else 0 end)) NO76,
       sum((case when b.no =77 then 1 else 0 end)) NO77,
       sum((case when b.no =78 then 1 else 0 end)) NO78,
       sum((case when b.no =79 then 1 else 0 end)) NO79,
       sum((case when b.no =80 then 1 else 0 end)) NO80
  FROM NW300 a LEFT JOIN nw301 b ON a.objid = b.nw300id
 WHERE     1 = 1
       AND a.TYPE = '11'
       --AND trunc(a.OPENDT) = TO_DATE ('2015/08/25', 'yyyy/MM/dd')
       AND trunc(a.OPENDT) = (
    select max(x.aa) from (
select max(trunc(B.OPENDT)) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
    )
       and B.ISSPNO = 0
       group by a.PERIODS
       order by a.PERIODS
       ) y
       order by y.PERIODS
       ) z
                  """

        def result = s.firstRow(sql)

        return result
    }

    /**
     * 賓果分析: 二連號
     * @return
     */
    def getbingoAnalysisF() {
        def s = new Sql(dataSource)
        def sql = """
select
substr(y.goodno,1,2) NOA,
substr(y.goodno,3,2) NOB,
y.NUM
from (
SELECT x.goodno, COUNT (x.goodno) NUM
    FROM (SELECT NW3.opendt,
                 LPAD (NW31B.NO, 2, '0') || LPAD (NW31.NO, 2, '0') GOODNO,
                 (NW31.NO - NW31B.NO) r
            FROM NW300 NW3
                 LEFT JOIN NW301 NW31
                    ON NW3.OBJID = NW31.NW300ID AND NW31.ISSPNO = 0
                 LEFT JOIN NW301 NW31B
                    ON     NW31.NW300ID = NW31B.NW300ID
                       AND NW31.OPIDX > NW31B.OPIDX
                       AND NW31B.ISSPNO = 0
           WHERE 1 = 1 AND NW3.TYPE = '11' AND NW31B.NO > 0
           --and trunc(NW3.OPENDT) = to_date('2015/08/25','yyyy/MM/dd')
           and trunc(NW3.OPENDT) = (
    select max(x.aa) from (
select max(trunc(B.OPENDT)) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
    )
           ) x
   WHERE x.r = 1
GROUP BY x.goodno
ORDER BY COUNT (x.goodno) DESC
) y
where rownum <= 8
                  """

        def result = s.rows(sql)

        return result
    }

    /**
     * 賓果分析: 三連號
     * @return
     */
    def getbingoAnalysisG() {
        def s = new Sql(dataSource)
        def sql = """
  select
  substr(y.goodno,1,2) NOA,
substr(y.goodno,3,2) NOB,
substr(y.goodno,5,2) NOC,
y.NUM
  from (
  SELECT x.goodno, COUNT (x.goodno) NUM
    FROM (SELECT NW3.opendt,
                    LPAD (NW31C.NO, 2, '0')
                 || LPAD (NW31B.NO, 2, '0')
                 || LPAD (NW31.NO, 2, '0')
                    GOODNO,
                 (CASE
                     WHEN (NW31C.NO + 1 = NW31B.NO AND NW31B.NO + 1 = NW31.NO) THEN 1 ELSE 0
                  END)
                    r
            FROM NW300 NW3
                 LEFT JOIN NW301 NW31
                    ON NW3.OBJID = NW31.NW300ID AND NW31.ISSPNO = 0
                 LEFT JOIN NW301 NW31B
                    ON     NW31.NW300ID = NW31B.NW300ID
                       AND NW31.NO > NW31B.NO
                       AND NW31B.ISSPNO = 0
                 LEFT JOIN NW301 NW31C
                    ON     NW31B.NW300ID = NW31C.NW300ID
                       AND NW31B.NO > NW31C.NO
                       AND NW31C.ISSPNO = 0
           WHERE 1 = 1 AND NW3.TYPE = '11' AND NW31B.NO > 0 AND NW31C.NO > 0
           --and trunc(NW3.OPENDT) = to_date('2015/08/25','yyyy/MM/dd')
           and trunc(NW3.OPENDT) = (
    select max(x.aa) from (
select max(trunc(B.OPENDT)) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
    )
           ) x
   WHERE x.r = 1
GROUP BY x.goodno
ORDER BY COUNT (x.goodno) DESC
) y
where rownum <= 5
                  """

        def result = s.rows(sql)

        return result
    }

    /**
     * 賓果分析: 四連號
     * @return
     */
    def getbingoAnalysisH() {
        def s = new Sql(dataSource)
        def sql = """
                  select
substr(y.goodno,1,2) NOA,
substr(y.goodno,3,2) NOB,
substr(y.goodno,5,2) NOC,
substr(y.goodno,7,2) NOD,
y.NUM
from (
SELECT x.goodno, COUNT (x.goodno) NUM
    FROM (
SELECT
    NW3.opendt,
    LPAD(NW31D.NO,2,'0') || LPAD(NW31C.NO,2,'0') || LPAD(NW31B.NO,2,'0') || LPAD(NW31.NO,2,'0') GOODNO,
    (CASE
              WHEN (NW31D.NO + 1 = NW31C.NO AND NW31C.NO + 1 = NW31B.NO AND NW31B.NO + 1 = NW31.NO) THEN 1 ELSE 0
    END) r
    FROM NW300 NW3
    LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID AND NW31.ISSPNO =0
    LEFT JOIN NW301 NW31B ON NW3.OBJID  = NW31B.NW300ID AND NW31.NO > NW31B.NO AND NW31B.ISSPNO =0
    LEFT JOIN NW301 NW31C ON NW3.OBJID  = NW31C.NW300ID AND NW31B.NO > NW31C.NO AND NW31C.ISSPNO =0
    LEFT JOIN NW301 NW31D ON NW3.OBJID  = NW31D.NW300ID AND NW31C.NO > NW31D.NO AND NW31D.ISSPNO =0
    WHERE 1=1
    AND NW3.TYPE = '11'
    AND NW31B.NO > 0
    AND NW31C.NO > 0
    AND NW31D.NO > 0
    --and trunc(NW3.OPENDT) = to_date('2015/08/25','yyyy/MM/dd')
    and trunc(NW3.OPENDT) = (
    select max(x.aa) from (
select max(trunc(B.OPENDT)) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
    )
) x
   WHERE x.r = 1
GROUP BY x.goodno
ORDER BY COUNT (x.goodno) DESC) y
where rownum <= 4
                  """

        def result = s.rows(sql)

        return result
    }

    /**
     * 賓果分析: 熱門頭號&熱門尾號
     * @return
     */
    def getbingoAnalysisI() {
        def s = new Sql(dataSource)
        def sql = """
                  select d.no from (
select
c.NO, count(1)
from (
select
(case when a.NO<10 then 0
         when a.NO>=10 and a.NO<20 then 1
         when a.NO>=20 and a.NO<30 then 2
         when a.NO>=30 and a.NO<40 then 3
         when a.NO>=40 and a.NO<50 then 4
         when a.NO>=50 and a.NO<60 then 5
         when a.NO>=60 and a.NO<70 then 6
         when a.NO>=70 and a.NO<80 then 7
         when a.NO=80 then 8
  end) NO
 from nw301 a
where exists (
select b.objid from nw300 b
where b.type = '11'
and trunc(B.OPENDT) = to_date('2015/08/25','yyyy/MM/dd')
and a.nw300id = b.objid
)
and A.ISSPNO = 0
order by A.NO
) c
group by c.NO
order by count(1) desc
) d
where rownum <= 3
union all
select d.no from (
select
c.NO, count(1)
from (
select
(case when mod(a.NO,10)=0 then 0
         when mod((a.NO+9),10)=0 then 1
         when mod((a.NO+8),10)=0 then 2
         when mod((a.NO+7),10)=0 then 3
         when mod((a.NO+6),10)=0 then 4
         when mod((a.NO+5),10)=0 then 5
         when mod((a.NO+4),10)=0 then 6
         when mod((a.NO+3),10)=0 then 7
         when mod((a.NO+2),10)=0 then 8
         when mod((a.NO+1),10)=0 then 9
  end) NO
 from nw301 a
where exists (
select b.objid from nw300 b
where b.type = '11'
--and trunc(B.OPENDT) = to_date('2015/08/25','yyyy/MM/dd')
and trunc(B.OPENDT) = (
    select max(x.aa) from (
select max(trunc(B.OPENDT)) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
    )
and a.nw300id = b.objid
)
and A.ISSPNO = 0
order by A.NO
) c
group by c.NO
order by count(1) desc
) d
where rownum <= 3
                  """

        def result = s.rows(sql)

        return result
    }

    /**
     * 賓果分析: 二同出
     * @return
     */
    def getbingoAnalysisJ() {
        def s = new Sql(dataSource)
        def sql = """
select
substr(tp.goodno,1,2) NOA,
substr(tp.goodno,3,2) NOB,
tp.NUM
from (
    SELECT
    NW3.opendt,
    LPAD(NW31B.NO,2,'0') || LPAD(NW31.NO,2,'0') GOODNO,
    COUNT(1) NUM
    FROM NW300 NW3
    LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID AND NW31.ISSPNO =0
    LEFT JOIN NW301 NW31B ON NW31.NW300ID = NW31B.NW300ID AND NW31.OPIDX > NW31B.OPIDX AND NW31B.ISSPNO =0
    WHERE 1=1
    AND NW3.TYPE = '11'
    AND NW31B.NO > 0
    --and trunc(NW3.OPENDT) = to_date('2015/08/25','yyyy/MM/dd')
    and trunc(NW3.OPENDT) = (
    select max(x.aa) from (
select max(trunc(B.OPENDT)) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
    )
    GROUP BY NW3.opendt,LPAD(NW31B.NO,2,'0') || LPAD(NW31.NO,2,'0')
    ORDER BY COUNT(1) DESC
) tp
where 1=1
and rownum <= 8
                  """

        def result = s.rows(sql)

        return result
    }

    /**
     * 賓果分析: 三同出
     * @return
     */
    def getbingoAnalysisK() {
        def s = new Sql(dataSource)
        def sql = """
select
substr(tp.goodno,1,2) NOA,
substr(tp.goodno,3,2) NOB,
substr(tp.goodno,5,2) NOC,
tp.NUM
from (
    SELECT
    NW3.opendt,
    LPAD(NW31C.NO,2,'0') || LPAD(NW31B.NO,2,'0') || LPAD(NW31.NO,2,'0') GOODNO,
    COUNT(1) NUM
    FROM NW300 NW3
    LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID AND NW31.ISSPNO =0
    LEFT JOIN NW301 NW31B ON NW31.NW300ID = NW31B.NW300ID AND NW31.NO > NW31B.NO AND NW31B.ISSPNO =0
    LEFT JOIN NW301 NW31C ON NW31B.NW300ID = NW31C.NW300ID AND NW31B.NO > NW31C.NO AND NW31C.ISSPNO =0
    WHERE 1=1
    AND NW3.TYPE = '11'
    AND NW31B.NO > 0
    AND NW31C.NO > 0
    --and trunc(NW3.OPENDT) = to_date('2015/08/25','yyyy/MM/dd')
    and trunc(NW3.OPENDT) = (
    select max(x.aa) from (
select max(trunc(B.OPENDT)) aa from nw300 b
where b.type = '11'
group by trunc(B.OPENDT)
) x
group by 1
    )
    GROUP BY NW3.opendt,LPAD(NW31C.NO,2,'0') || LPAD(NW31B.NO,2,'0') || LPAD(NW31.NO,2,'0')
    ORDER BY COUNT(1) DESC
) tp
where 1=1
and rownum <= 5
                  """

        def result = s.rows(sql)

        return result
    }

}
