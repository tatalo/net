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

    static void main(String[] args){
    }

    def getNw200List(params) { //回傳Nw200 List
        println "params.pType = " + params.pType

        def nw200I = Nw200.findAll() {
            eq("type", params.pType)
        }
        return nw200I
    }

    def getNw400List(params) { //回傳Nw400 List
        def nw400I = Nw400.findAll(params) {
            eq("type", params.pType)

            order("idx", "asc")
        }
        return nw400I
    }

    def getNw400(params) { //取得Nw400
        def nw400I = Nw400.get(params.id)
        return nw400I
    }

    def saveNw400(params) { //更新Nw400
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
        nw400I.browsercnts = ((nw400I?.browsercnts?:0)+1)
        nw400I.manLastUpdated = "BROWSER"
        nw400I.save(flush: true)
        return nw400I
    }

    def getNw500List(params) { //回傳Nw500 List
        def nw500I = Nw500.findAll() {
            eq("type", params.pType)
        }
        return nw500I
    }

    def getHistoryDataAnyalysis1(params) { //歷史數據: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort()
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each {it
            it = String.format('%02d', it)
            nosSql += "SUM(DECODE(NW31.NO,${it},DECODE(NW31.ISSPNO,1,2,1),0)) NO${it}, "
        }

        def mainSql = """
                        SELECT
                        *
                        FROM (
                            SELECT
                            NW3.PERIODS,
                            TRUNC(NW3.OPENDT) OPENDT,
                            ${nosSql}
                            0 END
                            FROM NW300 NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            WHERE 1 = :pNum
                            AND NW3.TYPE = :pType
                            GROUP BY TRUNC(NW3.OPENDT), PERIODS
                            ORDER BY NW3.PERIODS DESC
                        ) X
                        WHERE 1=1
                        AND ROWNUM <= :max
                        ORDER BY X.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.max ?: 25 //require
        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }


    def getHistoryDataAnyalysis2(params) { //歷史數據: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort()
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO
        result.columnsSPNOs = dataService."lotto${params.pType}".SPNOs.sort()

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each {it
            it = String.format('%02d', it)
            nosSql += "SUM(DECODE(NW31.NO,${it},DECODE(NW31.ISSPNO,1,0,1),0)) NO${it}, "
        }

        def spnosSql = ""
        result.columnsSPNOs.each {it
            it = String.format('%02d', it)
            spnosSql += "SUM(DECODE(NW31.NO,${it},DECODE(NW31.ISSPNO,1,2,0),0)) SPNO${it}, "
        }

        def mainSql = """
                        SELECT
                        *
                        FROM (
                            SELECT
                            NW3.PERIODS,
                            TRUNC(NW3.OPENDT) OPENDT,
                            ${nosSql}
                            ${spnosSql}
                            0 END
                            FROM NW300 NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            WHERE 1 = :pNum
                            AND NW3.TYPE = :pType
                            GROUP BY TRUNC(NW3.OPENDT), PERIODS
                            ORDER BY NW3.PERIODS DESC
                        ) X
                        WHERE 1=1
                        AND ROWNUM <= :max
                        ORDER BY X.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "03" //require
        condition.max = params.max ?: 25 //require
        def resultList = query.rows(mainSql, condition)

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getHistoryDataAnyalysis3(params) { //歷史數據: 3星彩, 4星彩
    }

    def getHistoryDataAnyalysis4(params) { //歷史數據: 賓果
    }

    def getCntsOpenAnalysis1(params) { //出現次數分析: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort()
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each {it
            it = String.format('%02d', it)
            nosSql += "SUM(DECODE(NW31.NO,${it},DECODE(NW31.ISSPNO,1,1,1),0)) NO${it}, "
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
        condition.max = params.max ?: 25 //require

//        println "sql = " + toolsService.transPRSSql(mainSql,condition)

        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].collect {it.value}.max()
        result.list = resultList
        result.counts = resultList.size()

        return result

    }

    def getCntsOpenAnalysis2(params) { //出現次數分析: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort()
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO
        result.columnsSPNOs = dataService."lotto${params.pType}".SPNOs.sort()


        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each {it
            it = String.format('%02d', it)
            nosSql += "SUM(DECODE(NW31.NO,${it},DECODE(NW31.ISSPNO,1,0,1),0)) NO${it}, "
        }

        def spnosSql = ""
        result.columnsSPNOs.each {it
            it = String.format('%02d', it)
            spnosSql += "SUM(DECODE(NW31.NO,${it},DECODE(NW31.ISSPNO,1,1,0),0)) SPNO${it}, "
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
        condition.max = params.max ?: 25 //require

        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].collect {it.value}.max()
        result.list = resultList
        result.counts = resultList.size()

        return result

    }

    def getLastOpenAnalysis1(params) { //最久未開分析: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort()
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each {it
            it = String.format('%02d', it)
            nosSql += "NVL(MAX(REPLACE(NWMAX.PER,'/','')) - MAX((CASE WHEN NW31.NO = ${it} THEN REPLACE(NW3.PERIODS,'/','') END)),:max) NO${it}, "
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
        condition.max = params.max ?: 25 //require
        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].collect {it.value}.max()
        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getLastOpenAnalysis2(params) { //最久未開分析: 威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort()
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO
        result.columnsSPNOs = dataService."lotto${params.pType}".SPNOs.sort()

        def query = new Sql(dataSource)


        def nosSql = ""
        result.columnsNOs.each {it
            it = String.format('%02d', it)
            nosSql += "NVL(MAX(REPLACE(NWMAX.PER,'/','')) - MAX((CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 0 THEN REPLACE(NW3.PERIODS,'/','') END)),:max) NO${it}, "
        }

        def spnosSql = ""
        result.columnsSPNOs.each {it
            it = String.format('%02d', it)
            spnosSql += "NVL(MAX(REPLACE(NWMAX.PER,'/','')) - MAX((CASE WHEN NW31.NO = ${it} AND NW31.ISSPNO = 1 THEN REPLACE(NW3.PERIODS,'/','') END)),:max) SPNO${it}, "
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
        condition.max = params.max ?: 25 //require
        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].collect {it.value}.max()
        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getLastNumberAnalysis1(params) { //尾數分析: 六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs.sort{(it-1)%10}
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO

        result.createColumn = [] //算出需要產生td欄位
        def cnts = 0
        result.columnsNOs.collect{it%10}.unique().each{ it
            cnts += result.columnsNOs.findAll{it2 -> (it2%10) == it}.size()
            result.createColumn += cnts
        }

        println "result.creatColumn = " + result.createColumn

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each {it
            it = String.format('%02d', it)
            nosSql += "SUM(DECODE(NW31.NO,${it},DECODE(NW31.ISSPNO,1,1,1),0)) NO${it}, "
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
        condition.max = params.max ?: 25 //require

//        println "sql = " + toolsService.transPRSSql(mainSql,condition)

        def resultList = query.rows(mainSql, condition)

        result.maxNum = resultList[0].collect {it.value}.max()

//        resultList[0].collect {
//            println "it = " + it
//            println "it2 = " + it2
//            cnts += result.columnsNOs.findAll{it2 -> (it2%10) == it}.size()
//            result.createColumn += cnts
//        }

        result.list = resultList
        result.counts = resultList.size()

        return result
    }
    def getLastNumberAnalysis2(params) { //尾數分析: 威力彩
    }
}
