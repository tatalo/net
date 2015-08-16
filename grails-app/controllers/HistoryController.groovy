import groovy.sql.*

class HistoryController {

    def dataSource

    def showBigLuckToa() {
        def showpage = params?.showpage?:20 //近幾期
        def sdt = params?.sdt //開始日期
        def edt = params?.edt //結束日期
        def speriods = params?.speriods //開始期數
        def eperiods = params?.eperiods //結束期數
        def s = new Sql(dataSource)

        def sql = """
                  SELECT * FROM (
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
                  WHERE 1=1
                  AND NW3.TYPE = '08'
                  GROUP BY TRUNC(NW3.OPENDT), PERIODS
                  ) X
                  WHERE ROWNUM <= 20
                  ORDER BY X.PERIODS DESC
                  """
        def result1 = s.rows(sql)

        def sql2 = """
                  select
                  sum(x.NO01) NO01, sum(x.NO02) NO02, sum(x.NO03) NO03, sum(x.NO04) NO04,
                  sum(x.NO05) NO05, sum(x.NO06) NO06, sum(x.NO07) NO07, sum(x.NO08) NO08,
                  sum(x.NO09) NO09, sum(x.NO10) NO10, sum(x.NO11) NO11, sum(x.NO12) NO12,
                  sum(x.NO13) NO13, sum(x.NO14) NO14, sum(x.NO15) NO15, sum(x.NO16) NO16,
                  sum(x.NO17) NO17, sum(x.NO18) NO18, sum(x.NO19) NO19, sum(x.NO20) NO20,
                  sum(x.NO21) NO21, sum(x.NO22) NO22, sum(x.NO23) NO23, sum(x.NO24) NO24,
                  sum(x.NO25) NO25, sum(x.NO26) NO26, sum(x.NO27) NO27, sum(x.NO28) NO28,
                  sum(x.NO29) NO29, sum(x.NO30) NO30, sum(x.NO31) NO31, sum(x.NO32) NO32,
                  sum(x.NO33) NO33, sum(x.NO34) NO34, sum(x.NO35) NO35, sum(x.NO36) NO36,
                  sum(x.NO37) NO37, sum(x.NO38) NO38, sum(x.NO39) NO39, sum(x.NO40) NO40,
                  sum(x.NO41) NO41, sum(x.NO42) NO42, sum(x.NO43) NO43, sum(x.NO44) NO44,
                  sum(x.NO45) NO45, sum(x.NO46) NO46, sum(x.NO47) NO47, sum(x.NO48) NO48,
                  sum(x.NO49) NO49
                  from
                  (
                  SELECT
                  SUM(DECODE(NW31.NO,1,1,0)) NO01, SUM(DECODE(NW31.NO,2,1,0)) NO02, SUM(DECODE(NW31.NO,3,1,0)) NO03,
                  SUM(DECODE(NW31.NO,4,1,0)) NO04, SUM(DECODE(NW31.NO,5,1,0)) NO05, SUM(DECODE(NW31.NO,6,1,0)) NO06,
                  SUM(DECODE(NW31.NO,7,1,0)) NO07, SUM(DECODE(NW31.NO,8,1,0)) NO08, SUM(DECODE(NW31.NO,9,1,0)) NO09,
                  SUM(DECODE(NW31.NO,10,1,0)) NO10, SUM(DECODE(NW31.NO,11,1,0)) NO11, SUM(DECODE(NW31.NO,12,1,0)) NO12,
                  SUM(DECODE(NW31.NO,13,1,0)) NO13, SUM(DECODE(NW31.NO,14,1,0)) NO14, SUM(DECODE(NW31.NO,15,1,0)) NO15,
                  SUM(DECODE(NW31.NO,16,1,0)) NO16, SUM(DECODE(NW31.NO,17,1,0)) NO17, SUM(DECODE(NW31.NO,18,1,0)) NO18,
                  SUM(DECODE(NW31.NO,19,1,0)) NO19, SUM(DECODE(NW31.NO,20,1,0)) NO20, SUM(DECODE(NW31.NO,21,1,0)) NO21,
                  SUM(DECODE(NW31.NO,22,1,0)) NO22, SUM(DECODE(NW31.NO,23,1,0)) NO23, SUM(DECODE(NW31.NO,24,1,0)) NO24,
                  SUM(DECODE(NW31.NO,25,1,0)) NO25, SUM(DECODE(NW31.NO,26,1,0)) NO26, SUM(DECODE(NW31.NO,27,1,0)) NO27,
                  SUM(DECODE(NW31.NO,28,1,0)) NO28, SUM(DECODE(NW31.NO,29,1,0)) NO29, SUM(DECODE(NW31.NO,30,1,0)) NO30,
                  SUM(DECODE(NW31.NO,31,1,0)) NO31, SUM(DECODE(NW31.NO,32,1,0)) NO32, SUM(DECODE(NW31.NO,33,1,0)) NO33,
                  SUM(DECODE(NW31.NO,34,1,0)) NO34, SUM(DECODE(NW31.NO,35,1,0)) NO35, SUM(DECODE(NW31.NO,36,1,0)) NO36,
                  SUM(DECODE(NW31.NO,37,1,0)) NO37, SUM(DECODE(NW31.NO,38,1,0)) NO38, SUM(DECODE(NW31.NO,39,1,0)) NO39,
                  SUM(DECODE(NW31.NO,40,1,0)) NO40, SUM(DECODE(NW31.NO,41,1,0)) NO41, SUM(DECODE(NW31.NO,42,1,0)) NO42,
                  SUM(DECODE(NW31.NO,43,1,0)) NO43, SUM(DECODE(NW31.NO,44,1,0)) NO44, SUM(DECODE(NW31.NO,45,1,0)) NO45,
                  SUM(DECODE(NW31.NO,46,1,0)) NO46, SUM(DECODE(NW31.NO,47,1,0)) NO47, SUM(DECODE(NW31.NO,48,1,0)) NO48,
                  SUM(DECODE(NW31.NO,49,1,0)) NO49
                  FROM NW300 NW3
                  LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                  WHERE 1=1
                  AND NW3.TYPE = '08'
                  GROUP BY TRUNC(NW3.OPENDT), PERIODS
                  ) x
                  where rownum <= 100
                  """
        def result2 = s.rows(sql2)
        def list1 = []
        def maxNum = 0

        if (result2 != null) {
            result2[0].eachWithIndex {
                node, index ->
                    list1 << node.value
            }
            maxNum = (list1.max())?.toInteger()
        }

        def sql3 = """
                   SELECT
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 1 THEN NW3.PERIODS END)) NO01, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 2 THEN NW3.PERIODS END)) NO02,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 3 THEN NW3.PERIODS END)) NO03, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 4 THEN NW3.PERIODS END)) NO04,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 5 THEN NW3.PERIODS END)) NO05, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 6 THEN NW3.PERIODS END)) NO06,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 7 THEN NW3.PERIODS END)) NO07, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 8 THEN NW3.PERIODS END)) NO08,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 9 THEN NW3.PERIODS END)) NO09, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 10 THEN NW3.PERIODS END)) NO10,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 11 THEN NW3.PERIODS END)) NO11, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 12 THEN NW3.PERIODS END)) NO12,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 13 THEN NW3.PERIODS END)) NO13, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 14 THEN NW3.PERIODS END)) NO14,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 15 THEN NW3.PERIODS END)) NO15, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 16 THEN NW3.PERIODS END)) NO16,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 17 THEN NW3.PERIODS END)) NO17, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 18 THEN NW3.PERIODS END)) NO18,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 19 THEN NW3.PERIODS END)) NO19, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 20 THEN NW3.PERIODS END)) NO20,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 21 THEN NW3.PERIODS END)) NO21, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 22 THEN NW3.PERIODS END)) NO22,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 23 THEN NW3.PERIODS END)) NO23, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 24 THEN NW3.PERIODS END)) NO24,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 25 THEN NW3.PERIODS END)) NO25, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 26 THEN NW3.PERIODS END)) NO26,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 27 THEN NW3.PERIODS END)) NO27, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 28 THEN NW3.PERIODS END)) NO28,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 29 THEN NW3.PERIODS END)) NO29, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 30 THEN NW3.PERIODS END)) NO30,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 31 THEN NW3.PERIODS END)) NO31, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 32 THEN NW3.PERIODS END)) NO32,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 33 THEN NW3.PERIODS END)) NO33, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 34 THEN NW3.PERIODS END)) NO34,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 35 THEN NW3.PERIODS END)) NO35, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 36 THEN NW3.PERIODS END)) NO36,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 37 THEN NW3.PERIODS END)) NO37, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 38 THEN NW3.PERIODS END)) NO38,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 39 THEN NW3.PERIODS END)) NO39, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 40 THEN NW3.PERIODS END)) NO40,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 41 THEN NW3.PERIODS END)) NO41, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 42 THEN NW3.PERIODS END)) NO42,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 43 THEN NW3.PERIODS END)) NO43, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 44 THEN NW3.PERIODS END)) NO44,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 45 THEN NW3.PERIODS END)) NO45, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 46 THEN NW3.PERIODS END)) NO46,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 47 THEN NW3.PERIODS END)) NO47, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 48 THEN NW3.PERIODS END)) NO48,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 49 THEN NW3.PERIODS END)) NO49
                   FROM NW300 NW3
                   LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                   LEFT JOIN (
                      SELECT
                      MAX(NW32.PERIODS) PER
                      FROM NW300 NW32
                      WHERE 1=1
                      and nw32.TYPE = '08'
                      and nw32.opendt between to_date('20140101','yyyymmdd') and to_date('20141202','yyyymmdd')
                   ) NWMAX ON 1=1
                   WHERE 1=1
                   AND NW3.TYPE = '08'
                   and nw3.opendt between to_date('20140101','yyyymmdd') and to_date('20141202','yyyymmdd')
                   """

        def result3 = s.rows(sql3)
        def list2 = []
        def everNum = 0

        if (result3 != null) {
            result3[0].eachWithIndex {
                node, index ->
                    list2 << node.value
            }
            everNum = (list2.max())?.toInteger()
        }


        render(view: 'index', model: [nw300InstanceList: result1, nw300CountInstance: result2, maxNum: maxNum, nw300EverInstance: result3, everNum: everNum])
    }
}
