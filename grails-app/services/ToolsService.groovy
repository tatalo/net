import grails.transaction.Transactional

@Transactional
class ToolsService {

    //取得chkError結果
    def chkError(Boolean uesError,Boolean chkError) {
        if (uesError) { //如果useResult原為false, 則不蓋掉
            uesError = chkError
        }
        return uesError
    }

    //PreparedStatement SQL取得完整SQL
    def transPRSSql(String sql,Map condition) {
        def result = sql
        condition.each {name, val ->
            result = result.replace(":" + name, "'" + val + "'")
        }
        return result
    }

    def g_date_time_yyyyMMdd(params, name) {
        def pattern = /(\d{4})\/?(\d{2})\/?(\d{2})?/
        def matcher = (params[name] =~ pattern)

        if (!matcher.matches()) {
            return null
        }

        def m1 = (matcher[0][1..-2] << (matcher[0][-1] ?: "1") << (params["${name}Hh"] ?: "00") << (params["${name}Mm"] ?: "00") ).collect { it.toInteger() }

        return new GregorianCalendar(m1[0], m1[1]-1, m1[2], m1[3], m1[4])
    }

//    def g_date_time_2_gre_cal(params, name) {
//        def pattern = /(\d{3})\/?(\d{2})\/?(\d{2})?/
//        def matcher = (params[name] =~ pattern)
//
//        if (!matcher.matches()) {
//            return null
//        }
//
//        def m1 = (matcher[0][1..-2] << (matcher[0][-1] ?: "1") << (params["${name}Hh"] ?: "00") << (params["${name}Mm"] ?: "00") ).collect { it.toInteger() }
//
//        return new GregorianCalendar(m1[0]+1911, m1[1]-1, m1[2], m1[3], m1[4])
//    }
}
