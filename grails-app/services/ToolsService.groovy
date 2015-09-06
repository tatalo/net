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
}
