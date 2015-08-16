class SportsController {
    def netWinService

    static void main(String[] args){
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
    static def alltabs = [
        [tab: '01', Type: 'webLink', dataType: ['01']],
        [tab: '02', Type: 'webLink', dataType: ['02']],
        [tab: '03', Type: 'webLink', dataType: ['03']],
        [tab: '04', Type: 'webLink', dataType: ['04']],
        [tab: '05', Type: 'webLink', dataType: ['05']],
        [tab: '06', Type: 'webLink', dataType: ['06']],
        [tab: '07', Type: 'webLink', dataType: ['99']]
    ]

    def index() { //運動
        render view: "/sports/index", model: [alltabs : alltabs]
    }

    def list() {
        println "params = " + params

        params.pType = Eval.me(params.pTypes)[0]
        def nw200I = netWinService.getNw200List(params)

        if (params.pTab in ["01","05"]) {
            render template: "/sports/webLink1", model: [nw200I : nw200I]
        } else if (params.pTab in ["02","03","04","06","07"]) {
            render template: "/sports/webLink2", model: [nw200I : nw200I]
        }
    }
}
