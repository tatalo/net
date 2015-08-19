import groovy.sql.Sql
import org.codehaus.groovy.grails.commons.metaclass.GroovyDynamicMethodsInterceptor
import org.codehaus.groovy.grails.web.metaclass.BindDynamicMethod
import grails.transaction.Transactional

@Transactional
class NetWinService {
    def dataSource
    def toolsService

    NetWinService() {
        GroovyDynamicMethodsInterceptor i = new GroovyDynamicMethodsInterceptor(this)
        i.addDynamicMethodInvocation(new BindDynamicMethod())
    }

    static void main(String[] args){
    }

    def getNw200List(params) { //回傳Nw200 List
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

    def getLottoList(params) {
//        println "params getLottoList = " + params

        def result = [:]

        def query = new Sql(dataSource)
        def mainSql = """
                        SELECT
                        *
                        FROM (
                            SELECT
                            NW3.PERIODS,
                            TRUNC(NW3.OPENDT) OPENDT,
                            SUM(DECODE(NW31.NO,1,DECODE(NW31.ISSPNO,1,2,1),0)) NO01, SUM(DECODE(NW31.NO,2,DECODE(NW31.ISSPNO,1,2,1),0)) NO02,
                            SUM(DECODE(NW31.NO,3,DECODE(NW31.ISSPNO,1,2,1),0)) NO03, SUM(DECODE(NW31.NO,4,DECODE(NW31.ISSPNO,1,2,1),0)) NO04,
                            SUM(DECODE(NW31.NO,5,DECODE(NW31.ISSPNO,1,2,1),0)) NO05, SUM(DECODE(NW31.NO,6,DECODE(NW31.ISSPNO,1,2,1),0)) NO06,
                            SUM(DECODE(NW31.NO,7,DECODE(NW31.ISSPNO,1,2,1),0)) NO07, SUM(DECODE(NW31.NO,8,DECODE(NW31.ISSPNO,1,2,1),0)) NO08,
                            SUM(DECODE(NW31.NO,9,DECODE(NW31.ISSPNO,1,2,1),0)) NO09, SUM(DECODE(NW31.NO,10,DECODE(NW31.ISSPNO,1,2,1),0)) NO10,
                            SUM(DECODE(NW31.NO,11,DECODE(NW31.ISSPNO,1,2,1),0)) NO11, SUM(DECODE(NW31.NO,12,DECODE(NW31.ISSPNO,1,2,1),0)) NO12,
                            SUM(DECODE(NW31.NO,13,DECODE(NW31.ISSPNO,1,2,1),0)) NO13, SUM(DECODE(NW31.NO,14,DECODE(NW31.ISSPNO,1,2,1),0)) NO14,
                            SUM(DECODE(NW31.NO,15,DECODE(NW31.ISSPNO,1,2,1),0)) NO15, SUM(DECODE(NW31.NO,16,DECODE(NW31.ISSPNO,1,2,1),0)) NO16,
                            SUM(DECODE(NW31.NO,17,DECODE(NW31.ISSPNO,1,2,1),0)) NO17, SUM(DECODE(NW31.NO,18,DECODE(NW31.ISSPNO,1,2,1),0)) NO18,
                            SUM(DECODE(NW31.NO,19,DECODE(NW31.ISSPNO,1,2,1),0)) NO19, SUM(DECODE(NW31.NO,20,DECODE(NW31.ISSPNO,1,2,1),0)) NO20,
                            SUM(DECODE(NW31.NO,21,DECODE(NW31.ISSPNO,1,2,1),0)) NO21, SUM(DECODE(NW31.NO,22,DECODE(NW31.ISSPNO,1,2,1),0)) NO22,
                            SUM(DECODE(NW31.NO,23,DECODE(NW31.ISSPNO,1,2,1),0)) NO23, SUM(DECODE(NW31.NO,24,DECODE(NW31.ISSPNO,1,2,1),0)) NO24,
                            SUM(DECODE(NW31.NO,25,DECODE(NW31.ISSPNO,1,2,1),0)) NO25, SUM(DECODE(NW31.NO,26,DECODE(NW31.ISSPNO,1,2,1),0)) NO26,
                            SUM(DECODE(NW31.NO,27,DECODE(NW31.ISSPNO,1,2,1),0)) NO27, SUM(DECODE(NW31.NO,28,DECODE(NW31.ISSPNO,1,2,1),0)) NO28,
                            SUM(DECODE(NW31.NO,29,DECODE(NW31.ISSPNO,1,2,1),0)) NO29, SUM(DECODE(NW31.NO,30,DECODE(NW31.ISSPNO,1,2,1),0)) NO30,
                            SUM(DECODE(NW31.NO,31,DECODE(NW31.ISSPNO,1,2,1),0)) NO31, SUM(DECODE(NW31.NO,32,DECODE(NW31.ISSPNO,1,2,1),0)) NO32,
                            SUM(DECODE(NW31.NO,33,DECODE(NW31.ISSPNO,1,2,1),0)) NO33, SUM(DECODE(NW31.NO,34,DECODE(NW31.ISSPNO,1,2,1),0)) NO34,
                            SUM(DECODE(NW31.NO,35,DECODE(NW31.ISSPNO,1,2,1),0)) NO35, SUM(DECODE(NW31.NO,36,DECODE(NW31.ISSPNO,1,2,1),0)) NO36,
                            SUM(DECODE(NW31.NO,37,DECODE(NW31.ISSPNO,1,2,1),0)) NO37, SUM(DECODE(NW31.NO,38,DECODE(NW31.ISSPNO,1,2,1),0)) NO38,
                            SUM(DECODE(NW31.NO,39,DECODE(NW31.ISSPNO,1,2,1),0)) NO39, SUM(DECODE(NW31.NO,40,DECODE(NW31.ISSPNO,1,2,1),0)) NO40,
                            SUM(DECODE(NW31.NO,41,DECODE(NW31.ISSPNO,1,2,1),0)) NO41, SUM(DECODE(NW31.NO,42,DECODE(NW31.ISSPNO,1,2,1),0)) NO42,
                            SUM(DECODE(NW31.NO,43,DECODE(NW31.ISSPNO,1,2,1),0)) NO43, SUM(DECODE(NW31.NO,44,DECODE(NW31.ISSPNO,1,2,1),0)) NO44,
                            SUM(DECODE(NW31.NO,45,DECODE(NW31.ISSPNO,1,2,1),0)) NO45, SUM(DECODE(NW31.NO,46,DECODE(NW31.ISSPNO,1,2,1),0)) NO46,
                            SUM(DECODE(NW31.NO,47,DECODE(NW31.ISSPNO,1,2,1),0)) NO47, SUM(DECODE(NW31.NO,48,DECODE(NW31.ISSPNO,1,2,1),0)) NO48,
                            SUM(DECODE(NW31.NO,49,DECODE(NW31.ISSPNO,1,2,1),0)) NO49
                            FROM NW300 NW3
                            LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                            WHERE 1 = :pNum
                            AND NW3.TYPE = :pType
                            GROUP BY TRUNC(NW3.OPENDT), PERIODS
                            ORDER BY PERIODS DESC
                        ) X
                        WHERE 1=1
                        AND ROWNUM <= :pRows
                        ORDER BY X.PERIODS DESC
                  """

        def condition = [:]
        condition.pNum = 1 //default parameters, avoid condition is null then happen exception
        condition.pType = params.pType ?: "01" //require
        condition.pRows = params.pRows ?: 25 //require

        println "condition = " + condition

//        def test = toolsService.transPRSSql(mainSql,condition)

        def resultList = query.rows(mainSql, condition)


        result.list = resultList
        result.counts = resultList.size()
        result.rowCounts = 49

//        println "result = " + result

        return result
    }
}
