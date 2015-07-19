package tabs



class SportController {

    def NetReptileService

    def index() {
        render( view: "/tabs/sports/index")
    }

    def runNetReptile = {
        def url = "http://www.taiwanlottery.com.tw/index_new.aspx"
        NetReptileService.getBingo(url)//賓果
        NetReptileService.getWayLiTry(url)//威力彩
        NetReptileService.getThreeEightTry(url)//38樂合彩
        NetReptileService.getBigLuckToa(url)//大樂透
        NetReptileService.getFourNineTry(url)//49樂合彩
        NetReptileService.getBigFuTry(url)//大福彩
        NetReptileService.getFiveThreeNine(url)//今彩539
        NetReptileService.getThreeNineTry(url)//39樂合彩
        NetReptileService.getThreeStarTry(url)//3星彩
        NetReptileService.getFourStarTry(url)//4星彩

        render """<script>alert('done!');</script>"""
    }


}
