class SportsController {
    def netWinService

    static void main(String[] args){
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
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
        render view: "/sports/index", model: [alltabs : alltabs]
    }

    def list() {
        println "params = " + params

        def nw200I = netWinService.getNw200List(params)

        if (params.pTab in ["01","05"]) {
            render template: "/sports/webLink1", model: [nw200I : nw200I, Type: params.pType, pTab: params.pTab, pSubTab: params.pSubTab]
        } else if (params.pTab in ["02","03","04","06","07"]) {
            render template: "/sports/webLink2", model: [nw200I : nw200I, Type: params.pType, pTab: params.pTab, pSubTab: params.pSubTab]
        }
    }
}
