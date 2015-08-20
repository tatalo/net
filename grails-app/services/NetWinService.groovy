import groovy.sql.Sql
import org.codehaus.groovy.grails.commons.metaclass.GroovyDynamicMethodsInterceptor
import org.codehaus.groovy.grails.web.metaclass.BindDynamicMethod
import grails.transaction.Transactional

@Transactional
class NetWinService {
    def dataSource
    def dataService
    def grailsApplication

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

    def getHistoryDataAnyalysis1(params) {
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs
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
                            ORDER BY PERIODS DESC
                        ) X
                        WHERE 1=1
                        AND ROWNUM <= :max
                        ORDER BY X.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.max ?: 25 //require

        println "condition = " + condition

        def resultList = query.rows(mainSql, condition)

//        println "type = " + resultList.type[0].getClass()

        result.list = resultList
        result.counts = resultList.size()

        return result
    }


    def getHistoryDataAnyalysis2(params) { //威力彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs
        result.haveSPNO = dataService."lotto${params.pType}".haveSPNO
        result.columnsSPNOs = dataService."lotto${params.pType}".SPNOs

        def query = new Sql(dataSource)

        def nosSql = ""
        result.columnsNOs.each {it
            it = String.format('%02d', it)
            nosSql += "SUM(DECODE(NW31.NO,${it},DECODE(NW31.ISSPNO,1,0,1),0)) NO${it}, "
        }

        def spnosSql = ""
        result.columnsNOs.each {it
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
                            ORDER BY PERIODS DESC
                        ) X
                        WHERE 1=1
                        AND ROWNUM <= :max
                        ORDER BY X.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "03" //require
        condition.max = params.max ?: 25 //require

        println "condition = " + condition

        def resultList = query.rows(mainSql, condition)

//        println "type = " + resultList.type[0].getClass()

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getHistoryDataAnyalysis3(params) { //3星彩, 4星彩
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs
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
                            ORDER BY PERIODS DESC
                        ) X
                        WHERE 1=1
                        AND ROWNUM <= :max
                        ORDER BY X.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.max ?: 25 //require

        println "condition = " + condition

        def resultList = query.rows(mainSql, condition)

//        println "type = " + resultList.type[0].getClass()

        result.list = resultList
        result.counts = resultList.size()

        return result
    }

    def getHistoryDataAnyalysis4(params) { //賓果
        def result = [:]
        result.columnsNOs = dataService."lotto${params.pType}".NOs
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
                            ORDER BY PERIODS DESC
                        ) X
                        WHERE 1=1
                        AND ROWNUM <= :max
                        ORDER BY X.PERIODS DESC
                  """
        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.max = params.max ?: 25 //require

        println "condition = " + condition

        def resultList = query.rows(mainSql, condition)

//        println "type = " + resultList.type[0].getClass()

        result.list = resultList
        result.counts = resultList.size()

        return result
    }
}
