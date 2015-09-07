class BaseController {
    def netWinService
    def netReptileService
    def dateService

    static void main(String[] args){
    }

    def index() {
        //賓果最新開獎資料, 取最新一天5筆
        params.pType = "11"
        params.max = 5
        params.pOpendt  = netWinService.getBingoNewestDays()[0]
        def nw300I11 = netWinService.getBingoAnyalysis4(params)

        //當日開獎資料
        params.pOpendt = dateService.today()
        params.pType = "01"
        def nw300I01 = netWinService.getNw300List(params)
        params.pType = "02"
        def nw300I02 = netWinService.getNw300List(params)
        params.pType = "03"
        def nw300I03 = netWinService.getNw300List(params)
        params.pType = "04"
        def nw300I04 = netWinService.getNw300List(params)
        params.pType = "05"
        def nw300I05 = netWinService.getNw300List(params)
        params.pType = "06"
        def nw300I06 = netWinService.getNw300List(params)
        params.pType = "07"
        def nw300I07 = netWinService.getNw300List(params)
        params.pType = "08"
        def nw300I08 = netWinService.getNw300List(params)
        params.pType = "09"
        def nw300I09 = netWinService.getNw300List(params)
        params.pType = "10"
        def nw300I10 = netWinService.getNw300List(params)

        render view:"/base/index", model: [nw300I11: nw300I11.list, columnsNOs11: nw300I11.columnsNOs,nw300I01: nw300I01, nw300I02: nw300I02, nw300I03: nw300I03, nw300I04: nw300I04, nw300I05: nw300I05, nw300I06: nw300I06,
                                                                                                                  nw300I07: nw300I07, nw300I08: nw300I08, nw300I09: nw300I09, nw300I10: nw300I10]
    }

    def build() {
        render template: "/base/build"
    }

    def editContent() {
        def nw400I = netWinService.getNw400(params)
        render view: "/base/editContent", model: [nw400I: nw400I], params: params
    }

    def saveContent() {
        def nw400I = netWinService.saveNw400(params)

        if (nw400I.hasErrors()) {
            flash.failed = g.message(code:"default.failure.updated.message",args: ['' , ''])
            flash.bean = nw400I
            render view: "/base/editContent", model: [nw400I: nw400I],params : params
        } else {
            flash.success = g.message(code:"default.updated.message",args: ['' , ''])
            redirect action: "editContent", id: params.id
        }
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
