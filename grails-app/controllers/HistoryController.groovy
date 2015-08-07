import groovy.sql.*

class HistoryController {

    def dataSource

    def index() {
    }

    def showBigLuckToa() {
        println 'showBigLuckToa'


        def s = new Sql(dataSource)
        def sql = """
                  SELECT * FROM (
                  SELECT
                  NW3.PERIODS,
                  TRUNC(NW3.OPENDT) OPENDT,
                  SUM(DECODE(NW31.NO,1,DECODE(NW31.ISSPNO,1,2,1),0)) NO01,
                  SUM(DECODE(NW31.NO,2,DECODE(NW31.ISSPNO,1,2,1),0)) NO02,
                  SUM(DECODE(NW31.NO,3,DECODE(NW31.ISSPNO,1,2,1),0)) NO03,
                  SUM(DECODE(NW31.NO,4,DECODE(NW31.ISSPNO,1,2,1),0)) NO04,
                  SUM(DECODE(NW31.NO,5,DECODE(NW31.ISSPNO,1,2,1),0)) NO05,
                  SUM(DECODE(NW31.NO,6,DECODE(NW31.ISSPNO,1,2,1),0)) NO06,
                  SUM(DECODE(NW31.NO,7,DECODE(NW31.ISSPNO,1,2,1),0)) NO07,
                  SUM(DECODE(NW31.NO,8,DECODE(NW31.ISSPNO,1,2,1),0)) NO08,
                  SUM(DECODE(NW31.NO,9,DECODE(NW31.ISSPNO,1,2,1),0)) NO09,
                  SUM(DECODE(NW31.NO,10,DECODE(NW31.ISSPNO,1,2,1),0)) NO10,
                  SUM(DECODE(NW31.NO,11,DECODE(NW31.ISSPNO,1,2,1),0)) NO11,
                  SUM(DECODE(NW31.NO,12,DECODE(NW31.ISSPNO,1,2,1),0)) NO12,
                  SUM(DECODE(NW31.NO,13,DECODE(NW31.ISSPNO,1,2,1),0)) NO13,
                  SUM(DECODE(NW31.NO,14,DECODE(NW31.ISSPNO,1,2,1),0)) NO14,
                  SUM(DECODE(NW31.NO,15,DECODE(NW31.ISSPNO,1,2,1),0)) NO15,
                  SUM(DECODE(NW31.NO,16,DECODE(NW31.ISSPNO,1,2,1),0)) NO16,
                  SUM(DECODE(NW31.NO,17,DECODE(NW31.ISSPNO,1,2,1),0)) NO17,
                  SUM(DECODE(NW31.NO,18,DECODE(NW31.ISSPNO,1,2,1),0)) NO18,
                  SUM(DECODE(NW31.NO,19,DECODE(NW31.ISSPNO,1,2,1),0)) NO19,
                  SUM(DECODE(NW31.NO,20,DECODE(NW31.ISSPNO,1,2,1),0)) NO20,
                  SUM(DECODE(NW31.NO,21,DECODE(NW31.ISSPNO,1,2,1),0)) NO21,
                  SUM(DECODE(NW31.NO,22,DECODE(NW31.ISSPNO,1,2,1),0)) NO22,
                  SUM(DECODE(NW31.NO,23,DECODE(NW31.ISSPNO,1,2,1),0)) NO23,
                  SUM(DECODE(NW31.NO,24,DECODE(NW31.ISSPNO,1,2,1),0)) NO24,
                  SUM(DECODE(NW31.NO,25,DECODE(NW31.ISSPNO,1,2,1),0)) NO25,
                  SUM(DECODE(NW31.NO,26,DECODE(NW31.ISSPNO,1,2,1),0)) NO26,
                  SUM(DECODE(NW31.NO,27,DECODE(NW31.ISSPNO,1,2,1),0)) NO27,
                  SUM(DECODE(NW31.NO,28,DECODE(NW31.ISSPNO,1,2,1),0)) NO28,
                  SUM(DECODE(NW31.NO,29,DECODE(NW31.ISSPNO,1,2,1),0)) NO29,
                  SUM(DECODE(NW31.NO,30,DECODE(NW31.ISSPNO,1,2,1),0)) NO30,
                  SUM(DECODE(NW31.NO,31,DECODE(NW31.ISSPNO,1,2,1),0)) NO31,
                  SUM(DECODE(NW31.NO,32,DECODE(NW31.ISSPNO,1,2,1),0)) NO32,
                  SUM(DECODE(NW31.NO,33,DECODE(NW31.ISSPNO,1,2,1),0)) NO33,
                  SUM(DECODE(NW31.NO,34,DECODE(NW31.ISSPNO,1,2,1),0)) NO34,
                  SUM(DECODE(NW31.NO,35,DECODE(NW31.ISSPNO,1,2,1),0)) NO35,
                  SUM(DECODE(NW31.NO,36,DECODE(NW31.ISSPNO,1,2,1),0)) NO36,
                  SUM(DECODE(NW31.NO,37,DECODE(NW31.ISSPNO,1,2,1),0)) NO37,
                  SUM(DECODE(NW31.NO,38,DECODE(NW31.ISSPNO,1,2,1),0)) NO38,
                  SUM(DECODE(NW31.NO,39,DECODE(NW31.ISSPNO,1,2,1),0)) NO39,
                  SUM(DECODE(NW31.NO,40,DECODE(NW31.ISSPNO,1,2,1),0)) NO40,
                  SUM(DECODE(NW31.NO,41,DECODE(NW31.ISSPNO,1,2,1),0)) NO41,
                  SUM(DECODE(NW31.NO,42,DECODE(NW31.ISSPNO,1,2,1),0)) NO42,
                  SUM(DECODE(NW31.NO,43,DECODE(NW31.ISSPNO,1,2,1),0)) NO43,
                  SUM(DECODE(NW31.NO,44,DECODE(NW31.ISSPNO,1,2,1),0)) NO44,
                  SUM(DECODE(NW31.NO,45,DECODE(NW31.ISSPNO,1,2,1),0)) NO45,
                  SUM(DECODE(NW31.NO,46,DECODE(NW31.ISSPNO,1,2,1),0)) NO46,
                  SUM(DECODE(NW31.NO,47,DECODE(NW31.ISSPNO,1,2,1),0)) NO47,
                  SUM(DECODE(NW31.NO,48,DECODE(NW31.ISSPNO,1,2,1),0)) NO48,
                  SUM(DECODE(NW31.NO,49,DECODE(NW31.ISSPNO,1,2,1),0)) NO49
                  FROM NW300 NW3
                  LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                  WHERE 1=1
                  AND NW3.TYPE = '08'
                  GROUP BY TRUNC(NW3.OPENDT), PERIODS
                  ) X
                  WHERE ROWNUM <= 100
                  ORDER BY X.PERIODS DESC
                  """
        def result1 = s.rows(sql)



        def sql2 = """
                  select
                  sum(x.NO01) NO01,
                  sum(x.NO02) NO02,
                  sum(x.NO03) NO03,
                  sum(x.NO04) NO04,
                  sum(x.NO05) NO05,
                  sum(x.NO06) NO06,
                  sum(x.NO07) NO07,
                  sum(x.NO08) NO08,
                  sum(x.NO09) NO09,
                  sum(x.NO10) NO10,
                  sum(x.NO11) NO11,
                  sum(x.NO12) NO12,
                  sum(x.NO13) NO13,
                  sum(x.NO14) NO14,
                  sum(x.NO15) NO15,
                  sum(x.NO16) NO16,
                  sum(x.NO17) NO17,
                  sum(x.NO18) NO18,
                  sum(x.NO19) NO19,
                  sum(x.NO20) NO20,
                  sum(x.NO21) NO21,
                  sum(x.NO22) NO22,
                  sum(x.NO23) NO23,
                  sum(x.NO24) NO24,
                  sum(x.NO25) NO25,
                  sum(x.NO26) NO26,
                  sum(x.NO27) NO27,
                  sum(x.NO28) NO28,
                  sum(x.NO29) NO29,
                  sum(x.NO30) NO30,
                  sum(x.NO31) NO31,
                  sum(x.NO32) NO32,
                  sum(x.NO33) NO33,
                  sum(x.NO34) NO34,
                  sum(x.NO35) NO35,
                  sum(x.NO36) NO36,
                  sum(x.NO37) NO37,
                  sum(x.NO38) NO38,
                  sum(x.NO39) NO39,
                  sum(x.NO40) NO40,
                  sum(x.NO41) NO41,
                  sum(x.NO42) NO42,
                  sum(x.NO43) NO43,
                  sum(x.NO44) NO44,
                  sum(x.NO45) NO45,
                  sum(x.NO46) NO46,
                  sum(x.NO47) NO47,
                  sum(x.NO48) NO48,
                  sum(x.NO49) NO49
                  from
                  (
                  SELECT
                  SUM(DECODE(NW31.NO,1,1,0)) NO01,
                  SUM(DECODE(NW31.NO,2,1,0)) NO02,
                  SUM(DECODE(NW31.NO,3,1,0)) NO03,
                  SUM(DECODE(NW31.NO,4,1,0)) NO04,
                  SUM(DECODE(NW31.NO,5,1,0)) NO05,
                  SUM(DECODE(NW31.NO,6,1,0)) NO06,
                  SUM(DECODE(NW31.NO,7,1,0)) NO07,
                  SUM(DECODE(NW31.NO,8,1,0)) NO08,
                  SUM(DECODE(NW31.NO,9,1,0)) NO09,
                  SUM(DECODE(NW31.NO,10,1,0)) NO10,
                  SUM(DECODE(NW31.NO,11,1,0)) NO11,
                  SUM(DECODE(NW31.NO,12,1,0)) NO12,
                  SUM(DECODE(NW31.NO,13,1,0)) NO13,
                  SUM(DECODE(NW31.NO,14,1,0)) NO14,
                  SUM(DECODE(NW31.NO,15,1,0)) NO15,
                  SUM(DECODE(NW31.NO,16,1,0)) NO16,
                  SUM(DECODE(NW31.NO,17,1,0)) NO17,
                  SUM(DECODE(NW31.NO,18,1,0)) NO18,
                  SUM(DECODE(NW31.NO,19,1,0)) NO19,
                  SUM(DECODE(NW31.NO,20,1,0)) NO20,
                  SUM(DECODE(NW31.NO,21,1,0)) NO21,
                  SUM(DECODE(NW31.NO,22,1,0)) NO22,
                  SUM(DECODE(NW31.NO,23,1,0)) NO23,
                  SUM(DECODE(NW31.NO,24,1,0)) NO24,
                  SUM(DECODE(NW31.NO,25,1,0)) NO25,
                  SUM(DECODE(NW31.NO,26,1,0)) NO26,
                  SUM(DECODE(NW31.NO,27,1,0)) NO27,
                  SUM(DECODE(NW31.NO,28,1,0)) NO28,
                  SUM(DECODE(NW31.NO,29,1,0)) NO29,
                  SUM(DECODE(NW31.NO,30,1,0)) NO30,
                  SUM(DECODE(NW31.NO,31,1,0)) NO31,
                  SUM(DECODE(NW31.NO,32,1,0)) NO32,
                  SUM(DECODE(NW31.NO,33,1,0)) NO33,
                  SUM(DECODE(NW31.NO,34,1,0)) NO34,
                  SUM(DECODE(NW31.NO,35,1,0)) NO35,
                  SUM(DECODE(NW31.NO,36,1,0)) NO36,
                  SUM(DECODE(NW31.NO,37,1,0)) NO37,
                  SUM(DECODE(NW31.NO,38,1,0)) NO38,
                  SUM(DECODE(NW31.NO,39,1,0)) NO39,
                  SUM(DECODE(NW31.NO,40,1,0)) NO40,
                  SUM(DECODE(NW31.NO,41,1,0)) NO41,
                  SUM(DECODE(NW31.NO,42,1,0)) NO42,
                  SUM(DECODE(NW31.NO,43,1,0)) NO43,
                  SUM(DECODE(NW31.NO,44,1,0)) NO44,
                  SUM(DECODE(NW31.NO,45,1,0)) NO45,
                  SUM(DECODE(NW31.NO,46,1,0)) NO46,
                  SUM(DECODE(NW31.NO,47,1,0)) NO47,
                  SUM(DECODE(NW31.NO,48,1,0)) NO48,
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
                    //println 'node'+node.value
                    list1 << node.value
            }
            maxNum = (list1.max())?.toInteger()
        }



        def sql3 = """
                   select
                   (c.maxnum - c.no01) no01,
                   (c.maxnum - c.no02) no02,
                   (c.maxnum - c.no03) no03,
                   (c.maxnum - c.no04) no04,
                   (c.maxnum - c.no05) no05,
                   (c.maxnum - c.no06) no06,
                   (c.maxnum - c.no07) no07,
                   (c.maxnum - c.no08) no08,
                   (c.maxnum - c.no09) no09,
                   (c.maxnum - c.no10) no10,
                   (c.maxnum - c.no11) no11,
                   (c.maxnum - c.no12) no12,
                   (c.maxnum - c.no13) no13,
                   (c.maxnum - c.no14) no14,
                   (c.maxnum - c.no15) no15,
                   (c.maxnum - c.no16) no16,
                   (c.maxnum - c.no17) no17,
                   (c.maxnum - c.no18) no18,
                   (c.maxnum - c.no19) no19,
                   (c.maxnum - c.no20) no20,
                   (c.maxnum - c.no21) no21,
                   (c.maxnum - c.no22) no22,
                   (c.maxnum - c.no23) no23,
                   (c.maxnum - c.no24) no24,
                   (c.maxnum - c.no25) no25,
                   (c.maxnum - c.no26) no26,
                   (c.maxnum - c.no27) no27,
                   (c.maxnum - c.no28) no28,
                   (c.maxnum - c.no29) no29,
                   (c.maxnum - c.no30) no30,
                   (c.maxnum - c.no31) no31,
                   (c.maxnum - c.no32) no32,
                   (c.maxnum - c.no33) no33,
                   (c.maxnum - c.no34) no34,
                   (c.maxnum - c.no35) no35,
                   (c.maxnum - c.no36) no36,
                   (c.maxnum - c.no37) no37,
                   (c.maxnum - c.no38) no38,
                   (c.maxnum - c.no39) no39,
                   (c.maxnum - c.no40) no40,
                   (c.maxnum - c.no41) no41,
                   (c.maxnum - c.no42) no42,
                   (c.maxnum - c.no43) no43,
                   (c.maxnum - c.no44) no44,
                   (c.maxnum - c.no45) no45,
                   (c.maxnum - c.no46) no46,
                   (c.maxnum - c.no47) no47,
                   (c.maxnum - c.no48) no48,
                   (c.maxnum - c.no49) no49
                   from (
                   select * from (
                   select max(a.periods) maxnum
                   from nw300 a where a.type = '08' and  A.OPENDT>=to_date('20140101','yyyyMMdd') and A.OPENDT<=to_date('20141202','yyyyMMdd')
                   ) tempA
                   CROSS JOIN
                   (
                   select
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO01 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO01,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO02 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO02,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO03 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO03,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO04 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO04,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO05 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO05,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO06 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO06,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO07 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO07,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO08 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO08,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO09 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO09,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO10 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO10,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO11 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO11,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO12 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO12,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO13 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO13,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO14 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO14,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO15 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO15,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO16 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO16,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO17 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO17,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO18 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO18,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO19 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO19,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO20 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO20,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO21 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO21,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO22 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO22,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO23 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO23,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO24 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO24,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO25 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO25,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO26 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO26,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO27 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO27,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO28 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO28,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO29 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO29,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO30 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO30,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO31 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO31,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO32 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO32,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO33 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO33,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO34 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO34,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO35 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO35,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO36 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO36,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO37 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO37,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO38 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO38,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO39 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO39,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO40 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO40,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO41 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO41,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO42 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO42,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO43 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO43,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO44 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO44,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO45 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO45,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO46 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO46,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO47 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO47,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO48 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO48,
                   (select max(x.periods) from V_BIG_LUCK_TOA x where x. NO49 > 0 and  x.OPENDT>=to_date('20140101','yyyyMMdd') and x.OPENDT<=to_date('20141202','yyyyMMdd') ) NO49
                   from dual
                   ) tempB
                   ) c
                   """

        def result3 = s.rows(sql3)


        def list2 = []

        def everNum = 0

        if (result3 != null) {
            result3[0].eachWithIndex {
                node, index ->
                    //println 'node'+node.value
                    list2 << node.value
            }
            everNum = (list2.max())?.toInteger()
        }

        println 'everNum = '+everNum


        render(view: 'index', model: [nw300InstanceList: result1, nw300CountInstance: result2, maxNum: maxNum, nw300EverInstance:result3, everNum:everNum])
    }
}
