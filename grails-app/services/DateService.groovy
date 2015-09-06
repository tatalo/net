import jodd.datetime.*
import grails.transaction.Transactional

@Transactional
class DateService {
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

    //    dateToString用來轉換Date為字串格式，可單傳Date，或自己加上分隔記號
    //    例1：dateToString(date1,'/')，則結果為：YYYY/MM/DD
    //    例2：dateToString(date1,'.')，則結果為：YYYY.MM.DD
    //    例3：dateToString(date1)，則結果為：YYYYMMDD

    def dateToString(value, style){
        if(!style){
            style = ''
        }
        String dateString = ''
        def dateMap
        JDateTime jdts  = new JDateTime()
        jdts = new JDateTime(value.year+1900, value.month+1, value.date)
        dateMap =  jdts.toString("YYYY/MM/DD").split('/')
        String dateYearFormat = (dateMap[0].toInteger()).toString()
        if(dateYearFormat.length()<4){
            dateYearFormat = '0'+dateYearFormat
        }
        dateString =dateYearFormat + style + dateMap[1]+style + dateMap[2]
    }
}
