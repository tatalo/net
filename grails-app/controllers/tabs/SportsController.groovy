package tabs



class SportsController {

    def netReptileService

    def index() {
        render( view: "/sports/main")
    }

    def runNetReptile = {
        def url = "http://www.taiwanlottery.com.tw/index_new.aspx"
        netReptileService.getBingo(url)//賓果
        netReptileService.getWayLiTry(url)//威力彩
        netReptileService.getThreeEightTry(url)//38樂合彩
        netReptileService.getBigLuckToa(url)//大樂透
        netReptileService.getFourNineTry(url)//49樂合彩
        netReptileService.getBigFuTry(url)//大福彩
        netReptileService.getFiveThreeNine(url)//今彩539
        netReptileService.getThreeNineTry(url)//39樂合彩
        netReptileService.getThreeStarTry(url)//3星彩
        netReptileService.getFourStarTry(url)//4星彩

        render """<script>alert('done!');</script>"""
    }


}
