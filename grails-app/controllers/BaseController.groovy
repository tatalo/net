class BaseController {

    def netReptileService

    static void main(String[] args){
    }

    def index() {
        render view:"/index"
    }

    def build() {
        render view:"/build"
    }

    def getData={
        println 'getData'
        def actionType = params.actionType
        println 'actionType = '+actionType

        def url = "http://www.taiwanlottery.com.tw/index_new.aspx"

        if(actionType=='07'){
            netReptileService.getBingo(url)//賓果
        }
        if(actionType=='2'){
            netReptileService.getWayLiTry(url)//威力彩
        }
        if(actionType=='3'){
            netReptileService.getThreeEightTry(url)//38樂合彩
        }
        if(actionType=='4'){
            netReptileService.getBigLuckToa(url)//大樂透
        }
        if(actionType=='5'){
            netReptileService.getFourNineTry(url)//49樂合彩
        }
        if(actionType=='6'){
            netReptileService.getBigFuTry(url)//大福彩
        }
        if(actionType=='7'){
            netReptileService.getFiveThreeNine(url)//今彩539
        }
        if(actionType=='8'){
            netReptileService.getThreeNineTry(url)//39樂合彩
        }
        if(actionType=='9'){
            netReptileService.getThreeStarTry(url)//3星彩
        }
        if(actionType=='10'){
            netReptileService.getFourStarTry(url)//4星彩
        }
        if(actionType=='11'){

        }







        render "ok"
    }
}
