class NationGambleController {
    def netWinService

    static void main(String[] args) {
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
    static def alltabs = [
            [tab: '01', viewType: 'webLink', dataType: ['201', '202']],
            [tab: '02', viewType: 'webLink', dataType: ['203']],
            [tab: '03', viewType: 'webLink', dataType: ['204']],
            [tab: '04', viewType: 'context', dataType: ['201']],
            [tab: '05', viewType: 'context', dataType: ['202']],
            [tab: '06', viewType: 'context', dataType: ['203']],
            [tab: '07', viewType: 'list', dataType: ['201']],
            [tab: '08', viewType: 'context', dataType: ['204']],
            [tab: '09', viewType: 'context', dataType: ['205']]
    ]

    def index() { //國際博彩
        render view: "/nationGamble/index", model: [alltabs: alltabs]
    }

    def list() {
        if (params.pTab in ["01"]) {
            params.pType = Eval.me(params.pTypes)[0]
            def nw200Ia = netWinService.getNw200List(params)
            params.pType = Eval.me(params.pTypes)[1]
            def nw200Ib = netWinService.getNw200List(params)

            def nw200I = nw200Ia + nw200Ib

            render template: "/nationGamble/webLink1", model: [nw200I: nw200I, dataTypes: Eval.me(params.pTypes)]
        } else if (params.pTab in ["02", "03"]) {
            params.pType = Eval.me(params.pTypes)[0]
            def nw200I = netWinService.getNw200List(params)

            render template: "/nationGamble/webLink2", model: [nw200I: nw200I]
        } else if (params.pTab in ["04", "05", "06", "08", "09"]) {
            params.pType = Eval.me(params.pTypes)[0]
            def nw400I = netWinService.getNw400List(params)

            render template: "/nationGamble/content1", model: [nw400I: nw400I]
        } else if (params.pTab in ["07"]) {
            params.pType = Eval.me(params.pTypes)[0]
            def nw500I = netWinService.getNw500List(params)
            render template: "/nationGamble/list1", model: [nw500I: nw500I]
        }
    }
}
