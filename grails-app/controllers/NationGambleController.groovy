class NationGambleController {
    def netWinService

    static void main(String[] args) {
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
    static def alltabs = [
            [tab: '01', viewType: 'webLink1', dataType: '201', dataType2: '202'],
            [tab: '02', viewType: 'webLink2', dataType: '203'],
            [tab: '03', viewType: 'webLink2', dataType: '204'],
            [tab: '04', viewType: 'context1', dataType: '201'],
            [tab: '05', viewType: 'context1', dataType: '202'],
            [tab: '06', viewType: 'context1', dataType: '203'],
            [tab: '07', viewType: 'list1', dataType: '201'],
            [tab: '08', viewType: 'context1', dataType: '204'],
            [tab: '09', viewType: 'context1', dataType: '205']
    ]

    def index() { //國際博彩
        render view: "/nationGamble/index", model: [alltabs: alltabs]
    }

    def list() {
        if (params.pTab in ["01"]) {
            def Types = [] //有兩個Type
            Types << params.pType
            Types << params.pType2

            params.pType = params.pType
            def nw200Ia = netWinService.getNw200List(params)
            params.pType = params.pType2
            def nw200Ib = netWinService.getNw200List(params)

            def nw200I = nw200Ia + nw200Ib

            render template: "/nationGamble/webLink1", model: [nw200I: nw200I, Types: Types, pTab: params.pTab, pSubTab: params.pSubTab]
        } else if (params.pTab in ["02", "03"]) {
            def nw200I = netWinService.getNw200List(params)

            render template: "/nationGamble/webLink2", model: [nw200I: nw200I, Type: params.pType, pTab: params.pTab, pSubTab: params.pSubTab]
        } else if (params.pTab in ["04", "05", "06", "08", "09"]) {
            def nw400I = netWinService.getNw400List(params)

            render template: "/nationGamble/content1", model: [nw400I: nw400I]
        } else if (params.pTab in ["07"]) {
            def nw500I = netWinService.getNw500List(params)
            render template: "/nationGamble/list1", model: [nw500I: nw500I, pTab: params.pTab, pSubTab: params.pSubTab]
        }
    }
}
