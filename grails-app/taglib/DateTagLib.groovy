class DateTagLib {
    def dateService

    static namespace = "df"

    static returnObjectForTags = [
            "yyyList"
    ]

    //查詢結果
    def yyyList = { attrs, body ->
        def pYearList = grailsApplication.config.grails.dataStart.yyyy.toInteger()..g.formatDate(date: new Date(),format: 'yyyy').toInteger()

        return pYearList
    }

    def params_text_date_transform = { attrs ->
        def p = attrs.params
        def l = attrs.list
        def s = (attrs.sqldate == "true" || attrs.sqldate == true)

        for (name in l) {
            if (params[name] && !(params[name] instanceof Date)) {
                def v = dateService.g_date_time_yyyyMMdd(params, name)?.time

                if (!v) {
                    try { //修正切換分頁時date值變null問題
                        params[name] = new Date(params[name])
                    } catch (Exception e) {
                        params[name] = null
                    } finally {
                    }
                } else {
                    if (s) {
                        params[name] = new Date(v.time)
                    } else {
                        params[name] = v
                    }
                }
            } else if (params[name] && (params[name] instanceof Date)) {
                params[name] = params[name]
            } else {
                params[name] = null
            }
        }
    }
}
