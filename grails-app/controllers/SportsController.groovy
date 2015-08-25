class SportsController {
    def netWinService

    static void main(String[] args) {
    }

//    // 分頁參數管理
//    // Type: webLink => NW200
//    //       context => NW400
//    //       list => NW500
    static def alltabs = [
            [tab: '01', viewType: 'webLink1', dataType: '01'],
            [tab: '02', viewType: 'webLink2', dataType: '02'],
            [tab: '03', viewType: 'webLink2', dataType: '03'],
            [tab: '04', viewType: 'webLink2', dataType: '04'],
            [tab: '05', viewType: 'webLink1', dataType: '05'],
            [tab: '06', viewType: 'webLink2', dataType: '06'],
            [tab: '07', viewType: 'webLink2', dataType: '99']
    ]

    def index() { //運動
        redirect action: "webLinkTianSia"
//        render view: "/sports/index", model: [alltabs: alltabs]
    }

    def list() {
        def nw200I = netWinService.getNw200List(params)

        if (params.pTab in ["01", "05"]) {
            render template: "/sports/BK/webLink1", model: [nw200I: nw200I, Type: params.pType, pTab: params.pTab, pSubTab: params.pSubTab]
        } else if (params.pTab in ["02", "03", "04", "06", "07"]) {
            render template: "/sports/BK/webLink2", model: [nw200I: nw200I, Type: params.pType, pTab: params.pTab, pSubTab: params.pSubTab]
        }
    }

    def webLinkTianSia() {
        params.pType = "01"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/form1", model: [nw200I: nw200I, title: hl.sportsTabs().find{it.tabIDX == 1}.text]
    }

    def webLink35688() {
        params.pType = "02"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/form2", model: [nw200I: nw200I, title: hl.sportsTabs().find{it.tabIDX == 2}.text]
    }

    def webLink35688China() {
        params.pType = "03"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/form2", model: [nw200I: nw200I, title: hl.sportsTabs().find{it.tabIDX == 3}.text]
    }

    def webLinkSinSinBao() {
        params.pType = "04"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/form2", model: [nw200I: nw200I, title: hl.sportsTabs().find{it.tabIDX == 4}.text]
    }

    def webLinkYingSyong() {
        params.pType = "05"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/form1", model: [nw200I: nw200I, title: hl.sportsTabs().find{it.tabIDX == 5}.text]
    }

    def webLinkRongHuaHuei() {
        params.pType = "06"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/form2", model: [nw200I: nw200I, title: hl.sportsTabs().find{it.tabIDX == 6}.text]
    }

    def webLinkOther() {
        params.pType = "99"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/form2", model: [nw200I: nw200I, title: hl.sportsTabs().find{it.tabIDX == 7}.text]
    }
}
