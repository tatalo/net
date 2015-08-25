class HtmlTagLib {
    static namespace = "hl"

    static returnObjectForTags = [
            "sportsTabs",
            "chkLottoDataClass",
            "chkActiveClass"
    ]

    //check Active, if chkValue equals matchValue
    def chkActiveClass = {attrs, body ->
        def className = ""

        def chkValue = attrs.remove('chkValue')
        def matchValue = attrs.remove('matchValue')

        if (chkValue.equals(matchValue)) {
            className = "active"
        }

        return className
    }

    //check lottoClass
    def chkLottoDataClass = {attrs, body ->
        def className = ""

        def chkValue = attrs.remove('chkValue')

        if (chkValue.equals("NO")) { //一般號碼
            className = "lottoNO"
        } else if (chkValue.equals("SPNO")) { //特別號
            className = "lottoSPNO"
        } else if (chkValue.equals("RPNO")) { //連開
            className = "lottoRepeatNO"
        } else if (chkValue.equals("CTNO")) { //連續
            className = "lottoContinueNO"
        }

        return className
    }

    //運動分頁
    def sportsTabs = { attrs, body ->

        def result = []

        result << [tabIDX: 1, text: g.message(code: "sports.tab01.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkTianSia", params: [tabLv1: 1])]
        result << [tabIDX: 2, text: g.message(code: "sports.tab02.label"),
                   link  : g.createLink(controller: "sports", action: "webLink35688", params: [tabLv1: 2])]
        result << [tabIDX: 3, text: g.message(code: "sports.tab03.label"),
                   link  : g.createLink(controller: "sports", action: "webLink35688China", params: [tabLv1: 3])]
        result << [tabIDX: 4, text: g.message(code: "sports.tab04.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkSinSinBao", params: [tabLv1: 4])]
        result << [tabIDX: 5, text: g.message(code: "sports.tab05.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkYingSyong", params: [tabLv1: 5])]
        result << [tabIDX: 6, text: g.message(code: "sports.tab06.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkRongHuaHuei", params: [tabLv1: 6])]
        result << [tabIDX: 7, text: g.message(code: "sports.tab07.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkOther", params: [tabLv1: 7])]

        return result
    }
}
