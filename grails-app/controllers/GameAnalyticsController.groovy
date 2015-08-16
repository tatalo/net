class GameAnalyticsController {

    static void main(String[] args){
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
    static def alltabs = []

    def index() {
        render view: "/gameAnalytics/index"

    }
}
