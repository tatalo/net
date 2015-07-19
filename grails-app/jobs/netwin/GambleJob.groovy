package netwin


class GambleJob {

    def NetReptileService

    static triggers = {
      simple repeatInterval: 10000l // execute job once in 10 seconds
    }

    def execute() {
        println "排程開始"
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
        // execute job
    }
}
