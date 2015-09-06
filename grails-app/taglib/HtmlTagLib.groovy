class HtmlTagLib {
    def netWinService

    static namespace = "hl"

    static returnObjectForTags = [
            "getSportsTabs",
            "getLottoTabs",
            "getNationGamebleTabs",
            "getGamebleTechTabs",
            "getDivChartHeight",
            "chkLottoClass",
            "getBingoNewestDays",
            "chkActiveClass"
    ]

    //取得賓果資料最新天數List
    def getBingoNewestDays = {attrs, body ->
        return netWinService.getBingoNewestDays()
    }

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
    def chkLottoClass = {attrs, body ->
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

    //取得直調圖長度
    def getDivChartHeight = { attrs, body ->
        def result
        def maxValue = attrs.remove('maxValue')
        def value = attrs.remove('value')

        result = (55 * ((value?:0) as Integer) / ((maxValue?:1) as Integer))?:0

        return result?:0
    }

    //博彩技巧分頁
    def getGamebleTechTabs = { attrs, body ->
        def result = []

//        result << [lv1IDX: 1, tabLv: 1, text: g.message(code: "gambleTech.tab01.label"),
//                   link  : g.createLink(controller: "lotto", action: "customNewOpen", params: [lv1IDX: 1])]
        result << [lv1IDX: 2, tabLv: 1, text: g.message(code: "gambleTech.tab02.label"),
                   link  : g.createLink(controller: "gambleTech", action: "content21")]
        result << [lv1IDX: 3, tabLv: 1, text: g.message(code: "gambleTech.tab03.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentRoulette")]
        result << [lv1IDX: 4, tabLv: 1, text: g.message(code: "gambleTech.tab04.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentShowHand")]
        result << [lv1IDX: 5, tabLv: 1, text: g.message(code: "gambleTech.tab05.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentHoldem")]
        result << [lv1IDX: 6, tabLv: 1, text: g.message(code: "gambleTech.tab06.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentBaccarat")]
        result << [lv1IDX: 7, tabLv: 1, text: g.message(code: "gambleTech.tab07.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentSlotMachine")]
        result << [lv1IDX: 8, tabLv: 1, text: g.message(code: "gambleTech.tab08.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentTaiSai")]
        result << [lv1IDX: 9, tabLv: 1, text: g.message(code: "gambleTech.tab09.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentPaiGow")]

        result << [lv1IDX: 2, lv2IDX: 1, tabLv: 2, text: g.message(code: "gambleTech.tab02.subTab01.label"),
                   link  : g.createLink(controller: "gambleTech", action: "content21")]
        result << [lv1IDX: 2, lv2IDX: 2, tabLv: 2, text: g.message(code: "gambleTech.tab02.subTab02.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentList21")]

        result << [lv1IDX: 3, lv2IDX: 1, tabLv: 2, text: g.message(code: "gambleTech.tab03.subTab01.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentRoulette")]
        result << [lv1IDX: 3, lv2IDX: 2, tabLv: 2, text: g.message(code: "gambleTech.tab03.subTab02.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentListRoulette")]

        result << [lv1IDX: 4, lv2IDX: 1, tabLv: 2, text: g.message(code: "gambleTech.tab04.subTab01.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentShowHand")]
        result << [lv1IDX: 4, lv2IDX: 2, tabLv: 2, text: g.message(code: "gambleTech.tab04.subTab02.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentListShowHand")]

        result << [lv1IDX: 5, lv2IDX: 1, tabLv: 2, text: g.message(code: "gambleTech.tab05.subTab01.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentHoldem")]
        result << [lv1IDX: 5, lv2IDX: 2, tabLv: 2, text: g.message(code: "gambleTech.tab05.subTab02.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentListHoldem")]

        result << [lv1IDX: 6, lv2IDX: 1, tabLv: 2, text: g.message(code: "gambleTech.tab06.subTab01.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentBaccarat")]
        result << [lv1IDX: 6, lv2IDX: 2, tabLv: 2, text: g.message(code: "gambleTech.tab06.subTab02.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentListBaccarat")]

        result << [lv1IDX: 7, lv2IDX: 1, tabLv: 2, text: g.message(code: "gambleTech.tab07.subTab01.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentSlotMachine")]
        result << [lv1IDX: 7, lv2IDX: 2, tabLv: 2, text: g.message(code: "gambleTech.tab07.subTab02.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentListSlotMachine")]

        result << [lv1IDX: 8, lv2IDX: 1, tabLv: 2, text: g.message(code: "gambleTech.tab08.subTab01.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentTaiSai")]
        result << [lv1IDX: 8, lv2IDX: 2, tabLv: 2, text: g.message(code: "gambleTech.tab08.subTab02.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentListTaiSai")]

        result << [lv1IDX: 9, lv2IDX: 1, tabLv: 2, text: g.message(code: "gambleTech.tab09.subTab01.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentPaiGow")]
        result << [lv1IDX: 9, lv2IDX: 2, tabLv: 2, text: g.message(code: "gambleTech.tab09.subTab02.label"),
                   link  : g.createLink(controller: "gambleTech", action: "contentListPaiGow")]


        return result
    }

    //國際博彩分頁
    def getNationGamebleTabs = { attrs, body ->
        def result = []

        result << [lv1IDX: 1, tabLv: 1, text: g.message(code: "nationGamble.tab01.label"),
                   link  : g.createLink(controller: "nationGamble", action: "webLinkHot")]
        result << [lv1IDX: 2, tabLv: 1, text: g.message(code: "nationGamble.tab02.label"),
                   link  : g.createLink(controller: "nationGamble", action: "webLinkEurope")]
        result << [lv1IDX: 3, tabLv: 1, text: g.message(code: "nationGamble.tab03.label"),
                   link  : g.createLink(controller: "nationGamble", action: "webLinkAsia")]
        result << [lv1IDX: 4, tabLv: 1, text: g.message(code: "nationGamble.tab04.label"),
                   link  : g.createLink(controller: "nationGamble", action: "contentGamebleGeneral")]
        result << [lv1IDX: 5, tabLv: 1, text: g.message(code: "nationGamble.tab05.label"),
                   link  : g.createLink(controller: "nationGamble", action: "contentGamebleCultural")]
        result << [lv1IDX: 6, tabLv: 1, text: g.message(code: "nationGamble.tab06.label"),
                   link  : g.createLink(controller: "nationGamble", action: "contentNationPosition")]
        result << [lv1IDX: 7, tabLv: 1, text: g.message(code: "nationGamble.tab07.label"),
                   link  : g.createLink(controller: "nationGamble", action: "listTermsHelp")]
        result << [lv1IDX: 8, tabLv: 1, text: g.message(code: "nationGamble.tab08.label"),
                   link  : g.createLink(controller: "nationGamble", action: "contentEuropePercent")]
        result << [lv1IDX: 9, tabLv: 1, text: g.message(code: "nationGamble.tab09.label"),
                   link  : g.createLink(controller: "nationGamble", action: "contentAsiaPercent")]

        return result
    }

    //運動分頁
    def getSportsTabs = { attrs, body ->
        def result = []

        result << [lv1IDX: 1, tabLv: 1, text: g.message(code: "sports.tab01.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkTianSia")]
        result << [lv1IDX: 2, tabLv: 1, text: g.message(code: "sports.tab02.label"),
                   link  : g.createLink(controller: "sports", action: "webLink35688")]
        result << [lv1IDX: 3, tabLv: 1, text: g.message(code: "sports.tab03.label"),
                   link  : g.createLink(controller: "sports", action: "webLink35688China")]
        result << [lv1IDX: 4, tabLv: 1, text: g.message(code: "sports.tab04.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkSinSinBao")]
        result << [lv1IDX: 5, tabLv: 1, text: g.message(code: "sports.tab05.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkYingSyong")]
        result << [lv1IDX: 6, tabLv: 1, text: g.message(code: "sports.tab06.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkRongHuaHuei")]
        result << [lv1IDX: 7, tabLv: 1, text: g.message(code: "sports.tab07.label"),
                   link  : g.createLink(controller: "sports", action: "webLinkOther")]

        return result
    }

    //彩球分頁
    def getLottoTabs = { attrs, body ->
        def result = []

        //tablv1
        result << [lv1IDX: 1, tabLv: 1, text: g.message(code: "lotto.tab01.label"),
                   link  : g.createLink(controller: "lotto", action: "customNewOpen")]
        result << [lv1IDX: 2, tabLv: 1, text: g.message(code: "lotto.tab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistoryMarkSix")]
        result << [lv1IDX: 3, tabLv: 1, text: g.message(code: "lotto.tab03.label"),
                   link  : g.createLink(controller: "lotto", action: "contentMarkSix")]
        result << [lv1IDX: 4, tabLv: 1, text: g.message(code: "lotto.tab04.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto740")]
        result << [lv1IDX: 5, tabLv: 1, text: g.message(code: "lotto.tab05.label"),
                   link  : g.createLink(controller: "lotto", action: "contentSuperLotto638")]
        result << [lv1IDX: 6, tabLv: 1, text: g.message(code: "lotto.tab06.label"),
                   link  : g.createLink(controller: "lotto", action: "content38M6")]
        result << [lv1IDX: 7, tabLv: 1, text: g.message(code: "lotto.tab07.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto649")]
        result << [lv1IDX: 8, tabLv: 1, text: g.message(code: "lotto.tab08.label"),
                   link  : g.createLink(controller: "lotto", action: "content49M6")]
        result << [lv1IDX: 9, tabLv: 1, text: g.message(code: "lotto.tab09.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto539")]
        result << [lv1IDX: 10, tabLv: 1, text: g.message(code: "lotto.tab10.label"),
                   link  : g.createLink(controller: "lotto", action: "content39M5")]
        result << [lv1IDX: 11, tabLv: 1, text: g.message(code: "lotto.tab11.label"),
                   link  : g.createLink(controller: "lotto", action: "content3D")]
        result << [lv1IDX: 12, tabLv: 1, text: g.message(code: "lotto.tab12.label"),
                   link  : g.createLink(controller: "lotto", action: "content4D")]
        result << [lv1IDX: 13, tabLv: 1, text: g.message(code: "lotto.tab13.label"),
                   link  : g.createLink(controller: "lotto", action: "contentBingoBingo")]

        result << [lv1IDX: 2, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab02.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistoryMarkSix")]
        result << [lv1IDX: 2, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab02.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistoryLotto740")]
        result << [lv1IDX: 2, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab02.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistorySuperLotto638")]
        result << [lv1IDX: 2, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab02.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistory38M6")]
        result << [lv1IDX: 2, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab02.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistoryLotto649")]
        result << [lv1IDX: 2, lv2IDX: 6, tabLv: 2, text: g.message(code: "lotto.tab02.subTab06.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistory49M6")]
        result << [lv1IDX: 2, lv2IDX: 7, tabLv: 2, text: g.message(code: "lotto.tab02.subTab07.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistoryLotto539")]
        result << [lv1IDX: 2, lv2IDX: 8, tabLv: 2, text: g.message(code: "lotto.tab02.subTab08.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistory39M5")]
        result << [lv1IDX: 2, lv2IDX: 9, tabLv: 2, text: g.message(code: "lotto.tab02.subTab09.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistory3D")]
        result << [lv1IDX: 2, lv2IDX: 10, tabLv: 2, text: g.message(code: "lotto.tab02.subTab10.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistory4D")]
        result << [lv1IDX: 2, lv2IDX: 11, tabLv: 2, text: g.message(code: "lotto.tab02.subTab11.label"),
                   link  : g.createLink(controller: "lotto", action: "customQueryHistoryBingoBingo")]

        result << [lv1IDX: 3, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab03.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentMarkSix")]
        result << [lv1IDX: 3, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab03.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistoryMarkSix")]
        result << [lv1IDX: 3, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab03.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeatMarkSix")]
        result << [lv1IDX: 3, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab03.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinueMarkSix")]
        result << [lv1IDX: 3, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab03.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumberMarkSix")]

        result << [lv1IDX: 4, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab04.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto740")]
        result << [lv1IDX: 4, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab04.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistoryLotto740")]
        result << [lv1IDX: 4, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab04.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeatLotto740")]
        result << [lv1IDX: 4, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab04.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinueLotto740")]
        result << [lv1IDX: 4, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab04.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumberLotto740")]

        result << [lv1IDX: 5, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab05.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentSuperLotto638")]
        result << [lv1IDX: 5, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab05.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistorySuperLotto638")]
        result << [lv1IDX: 5, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab05.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeatSuperLotto638")]
        result << [lv1IDX: 5, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab05.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinueSuperLotto638")]
        result << [lv1IDX: 5, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab05.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumberSuperLotto638")]

        result << [lv1IDX: 6, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab06.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "content38M6")]
        result << [lv1IDX: 6, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab06.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistory38M6")]
        result << [lv1IDX: 6, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab06.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeat38M6")]
        result << [lv1IDX: 6, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab06.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinue38M6")]
        result << [lv1IDX: 6, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab06.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumber38M6")]

        result << [lv1IDX: 7, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab07.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto649")]
        result << [lv1IDX: 7, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab07.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistoryLotto649")]
        result << [lv1IDX: 7, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab07.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeatLotto649")]
        result << [lv1IDX: 7, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab07.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinueLotto649")]
        result << [lv1IDX: 7, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab07.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumberLotto649")]

        result << [lv1IDX: 8, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab08.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "content49M6")]
        result << [lv1IDX: 8, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab08.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistory49M6")]
        result << [lv1IDX: 8, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab08.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeat49M6")]
        result << [lv1IDX: 8, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab08.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinue49M6")]
        result << [lv1IDX: 8, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab08.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumber49M6")]

        result << [lv1IDX: 9, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab09.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentLotto539")]
        result << [lv1IDX: 9, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab09.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistoryLotto539")]
        result << [lv1IDX: 9, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab09.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeatLotto539")]
        result << [lv1IDX: 9, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab09.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinueLotto539")]
        result << [lv1IDX: 9, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab09.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumberLotto539")]

        result << [lv1IDX: 10, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab10.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "content39M5")]
        result << [lv1IDX: 10, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab10.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistory39M5")]
        result << [lv1IDX: 10, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab10.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customRepeat39M5")]
        result << [lv1IDX: 10, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab10.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customContinue39M5")]
        result << [lv1IDX: 10, lv2IDX: 5, tabLv: 2, text: g.message(code: "lotto.tab10.subTab05.label"),
                   link  : g.createLink(controller: "lotto", action: "customLastNumber39M5")]

        result << [lv1IDX: 11, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab11.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "content3D")]
        result << [lv1IDX: 11, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab11.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistory3D")]

        result << [lv1IDX: 12, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab12.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "content4D")]
        result << [lv1IDX: 12, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab12.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customHistory4D")]

        result << [lv1IDX: 13, lv2IDX: 1, tabLv: 2, text: g.message(code: "lotto.tab13.subTab01.label"),
                   link  : g.createLink(controller: "lotto", action: "contentBingoBingo")]
        result << [lv1IDX: 13, lv2IDX: 2, tabLv: 2, text: g.message(code: "lotto.tab13.subTab02.label"),
                   link  : g.createLink(controller: "lotto", action: "customOpenNoListBingo")]
        result << [lv1IDX: 13, lv2IDX: 3, tabLv: 2, text: g.message(code: "lotto.tab13.subTab03.label"),
                   link  : g.createLink(controller: "lotto", action: "customStatistBingo")]
        result << [lv1IDX: 13, lv2IDX: 4, tabLv: 2, text: g.message(code: "lotto.tab13.subTab04.label"),
                   link  : g.createLink(controller: "lotto", action: "customAnalysisBingo")]

        return result
    }
}
