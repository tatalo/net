class BaseController {

    def netReptileService

    static void main(String[] args){
    }

    def index() {
        def sportTabs = SportsController.alltabs
        def lottoTabs = LottoController.alltabs
        def nationGambleTabs = NationGambleController.alltabs
        def gambletechTabs = GambleTechController.alltabs

        render view:"/base/index", model: [ sportTabs: sportTabs, lottoTabs: lottoTabs, nationGambleTabs : nationGambleTabs , gambletechTabs :gambletechTabs]
    }

    def build() {
        render template: "/base/build"
    }

    def getData={
        println 'getData'
        def actionType = params.actionType
        println 'actionType = '+actionType

        def url = "http://www.taiwanlottery.com.tw/index_new.aspx"

        def result = ''

        try {

            if(actionType=='01'){//六合彩

            }
            if(actionType=='02'){
                netReptileService.getBigFuTry(url)//大福彩
            }
            if(actionType=='03'){
                netReptileService.getWayLiTry(url)//威力彩
            }
            if(actionType=='04'){
                netReptileService.getThreeEightTry(url)//38樂合彩
            }
            if(actionType=='05'){
                netReptileService.getThreeStarTry(url)//3星彩
            }
            if(actionType=='06'){
                netReptileService.getFourStarTry(url)//4星彩
            }
            if(actionType=='07'){
                netReptileService.getBingo(url)//賓果
            }
            if(actionType=='08'){
                netReptileService.getBigLuckToa(url)//大樂透
            }
            if(actionType=='09'){
                netReptileService.getFourNineTry(url)//49樂合彩
            }
            if(actionType=='10'){
                netReptileService.getThreeNineTry(url)//39樂合彩
            }
            if(actionType=='11'){
                netReptileService.getFiveThreeNine(url)//今彩539
            }
            result = 'ok'
        }catch (Exception e){
            result = 'no'
            println 'Exception => '+Exception
        }



        render result
    }
}
