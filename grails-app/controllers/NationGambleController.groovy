class NationGambleController {
    def netWinService

    static void main(String[] args) {
    }

    //國際博彩
    def index() {
        redirect action: "webLinkHot"
    }

    def webLinkHot() { //熱門
        params.pTypeList = ["201","202"]
        def nw200I = netWinService.getNw200List(params)
        render view: "/nationGamble/formList1", model: [nw200I: nw200I,lv1IDX : 1]
    }

    def webLinkEurope() { //歐洲
        params.pType = "203"
        def nw200I = netWinService.getNw200List(params)
        render view: "/nationGamble/formList1", model: [nw200I: nw200I,lv1IDX : 2]
    }

    def webLinkAsia() { //亞洲
        params.pType = "204"
        def nw200I = netWinService.getNw200List(params)
        render view: "/nationGamble/formList1", model: [nw200I: nw200I,lv1IDX : 3]
    }

    def contentGamebleGeneral() { //世界博彩概況
        params.pType = "201"
        def nw400I = netWinService.getNw400List(params)
        render view: "/nationGamble/formContent1", model: [nw400I: nw400I,lv1IDX : 4]
    }

    def contentGamebleCultural() { //世界博彩文化
        params.pType = "202"
        def nw400I = netWinService.getNw400List(params)
        render view: "/nationGamble/formContent1", model: [nw400I: nw400I,lv1IDX : 5]
    }

    def contentNationPosition() { //國際盤口
        params.pType = "203"
        def nw400I = netWinService.getNw400List(params)
        render view: "/nationGamble/formContent1", model: [nw400I: nw400I,lv1IDX : 6]
    }

    def listTermsHelp() { //術語教學
        params.pType = "201"
        def nw500I = netWinService.getNw500List(params)
        render view: "/nationGamble/formList2", model: [nw500I: nw500I,lv1IDX : 7]
    }

    def contentEuropePercent() { //歐洲賠率
        params.pType = "204"
        def nw400I = netWinService.getNw400List(params)
        render view: "/nationGamble/formContent1", model: [nw400I: nw400I,lv1IDX : 8]
    }

    def contentAsiaPercent() { //亞洲賠率
        params.pType = "205"
        def nw400I = netWinService.getNw400List(params)
        render view: "/nationGamble/formContent1", model: [nw400I: nw400I,lv1IDX : 9]
    }
}
