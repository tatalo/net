import groovy.sql.Sql
import org.codehaus.groovy.grails.commons.metaclass.GroovyDynamicMethodsInterceptor
import org.codehaus.groovy.grails.web.metaclass.BindDynamicMethod
import grails.transaction.Transactional

@Transactional
class NetWinService {
    def dataSource
    def dataService
    def toolsService

    NetWinService() {
        GroovyDynamicMethodsInterceptor i = new GroovyDynamicMethodsInterceptor(this)
        i.addDynamicMethodInvocation(new BindDynamicMethod())
    }

    def getNw200List(params) { //回傳Nw200(連結)
        def nw200I = Nw200.createCriteria().list(params) {
            if (params.pType) {
                eq("type", params.pType)
            }
        }
        return nw200I
    }

    def getNw300List(params) { //取得Nw300(彩球)
        def nw300I = Nw300.createCriteria().list(params) {
            if (params.pYyyymm) {
                ge("opendt", params.pYyyymmS)
                lt("opendt", params.pYyyymmE - 1)
            }
            if (params.pOpendt) {
                eq("opendt", params.pOpendt)
            }
            if (params.pPeriods) {
                eq("periods", params.pPeriods)
            }

            eq("type", params.pType)
            order("opendt", "desc")
            order("periods", "desc")
        }
        return nw300I
    }

    def getNw400List(params) { //回傳Nw400(文章)
        def nw400I = Nw400.createCriteria().list(params) {
            eq("type", params.pType)

            order("idx", "asc")
        }
        return nw400I
    }

    def getNw500List(params) { //回傳Nw500(清單)
        def nw500I = Nw500.createCriteria().list(params) {
            eq("type", params.pType)
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

    def getHistoryDataAnyalysis1(params) { //歷史數據: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "DECODE(SUM(CASE WHEN NW31.NO = ${it} THEN (CASE WHEN NW31.ISSPNO = 1 THEN 2 ELSE 1 END) ELSE 0 END),2,'SPNO',1,'NO','') NO${it}, "
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
        condition.max = params.max ? params.max as Integer : 25 //require
        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getHistoryDataAnyalysis2(params) { //歷史數據: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO
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
        condition.max = params.max ? params.max as Integer : 25 //require
        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getHistoryDataAnyalysis3(params) { //歷史數據: 3星彩, 4星彩
        def result = [:]

        result.columnIDXS = dataService."lotto${params.pType}".IDXs
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

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
        condition.max = params.max ? params.max as Integer : 25 //require

        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getHistoryDataAnyalysis4(params) { //歷史數據: 賓果
    }

    def getCntsOpenAnalysis1(params) { //出現次數分析: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "SUM(CASE WHEN NW31.NO = ${it} THEN 1 ELSE 0 END) NO${it}, "
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
                            ORDER BY NW3.PERIODS DESC
                        """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.max ? params.max as Integer : 25 //require

        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].max { it.value }.value
        result.list = resultList

        return result

    }

    def getCntsOpenAnalysis2(params) { //出現次數分析: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO
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
        condition.max = params.max ? params.max as Integer : 25 //require

        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].max { it.value }.value
        result.list = resultList

        return result

    }

    def getCntsOpenAnalysis3(params) { //出現次數分析: 3星彩, 4星彩
        def result = [:]
        result.columnIDXS = dataService."lotto${params.pType}".IDXs
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnIDXS.IDX.each { it ->
            result.columnsNOs.each { it2 ->
                nosSql += "SUM(CASE WHEN NW31.NO = ${it2} AND NW31.OPIDX = ${it} THEN 1 ELSE 0 END) NO${it}${it2}, "
            }
        }
        result.columnsNOs.each { it ->
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
                            ORDER BY NW3.PERIODS DESC
                        """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.max ? params.max as Integer : 25 //require

        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].max { it.value }.value
        result.list = resultList

        return result

    }

    def getLastOpenAnalysis1(params) { //最久未開分析: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]

        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "MAX(NW3.FIXPERIODS) - NVL(MAX(CASE WHEN NW31.NO = ${it} THEN NW3.FIXPERIODS END),0) NO${it}, "
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
                            GROUP BY 1
                        """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.max ? params.max as Integer : 25 //require

//        println "sql = " + toolsService.transPRSSql(mainSql, condition)
        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].max { it.value }.value
        result.list = resultList

        return result
    }

    def getLastOpenAnalysis2(params) { //最久未開分析: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO
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
        condition.max = params.max ? params.max as Integer : 25 //require
        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].max { it.value }.value
        result.list = resultList

        return result
    }

    def getLastOpenAnalysis3(params) { //最久未開分析: 3星彩, 4星彩
        def result = [:]
        result.columnIDXS = dataService."lotto${params.pType}".IDXs
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnIDXS.IDX.each { it ->
            result.columnsNOs.each { it2 ->
                nosSql += "NVL(MAX(REPLACE(NWMAX.PER,'/','')) - MAX((CASE WHEN NW31.NO = ${it2} AND NW31.OPIDX = ${it} THEN REPLACE(NW3.PERIODS,'/','') END)),:max) NO${it}${it2}, "
            }
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
                           LEFT JOIN (
                                SELECT
                                MAX(NW32.PERIODS) PER
                                FROM NW300 NW32
                                WHERE 1 = :pNum
                                AND NW32.TYPE = :pType
                           ) NWMAX ON 1=1
                           WHERE 1=1
                           ORDER BY NW3.PERIODS DESC
                        """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.max ? params.max as Integer : 25 //require

        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].max { it.value }.value
        result.list = resultList

        return result
    }

    def getLastNumberAnalysis1(params) { //尾數分析: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { (it.toInteger() - 1) % 10 }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
            nosSql += "SUM(CASE WHEN NW31.NO = ${it} THEN 1 ELSE 0 END) NO${it}, "
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
                            ORDER BY NW3.PERIODS DESC
                        """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.max ? params.max as Integer : 25 //require

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
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO
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
        condition.max = params.max ? params.max as Integer : 25 //require

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


    def getContinueDataAnyalysis1(params) { //歷史數據: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each { it ->
                nosSql += "DECODE(SUM(CASE WHEN NW31.NO = ${it} THEN (CASE WHEN (NVL(NW31B.NO,0) > 0 OR NVL(NW31C.NO,0) > 0) THEN 3 ELSE (CASE WHEN NW31.ISSPNO = 1 THEN 2 ELSE 1 END) END) ELSE 0 END),3,'CTNO',2,'SPNO',1,'NO','') NO${it}, "
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
                        GROUP BY NW3.PERIODS, NW3.OPENDT
                        ORDER BY NW3.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.max ? params.max as Integer : 25 //require

//        println "sql = " + toolsService.transPRSSql(mainSql, condition)

        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getContinueDataAnyalysis2(params) { //歷史數據: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort { it.toInteger() }
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO
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
        condition.max = params.max ? params.max as Integer : 25 //require

//        println "sql = " + toolsService.transPRSSql(mainSql, condition)

        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

}
