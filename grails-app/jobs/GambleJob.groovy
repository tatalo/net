class GambleJob {

    def netReptileService

    static triggers = {
      simple repeatInterval: 100000l // execute job once in 5 seconds
    }

    def execute() {
        def no = System.currentTimeMillis()
        println "排程["+no+"]開始"+new Date()
        def url = "http://www.taiwanlottery.com.tw/index_new.aspx"
        netReptileService.getBingo(url)//賓果
//        netReptileService.getWayLiTry(url)//威力彩
//        netReptileService.getThreeEightTry(url)//38樂合彩
//        netReptileService.getBigLuckToa(url)//大樂透
//        netReptileService.getFourNineTry(url)//49樂合彩
//        netReptileService.getBigFuTry(url)//大福彩
//        netReptileService.getFiveThreeNine(url)//今彩539
//        netReptileService.getThreeNineTry(url)//39樂合彩
//        netReptileService.getThreeStarTry(url)//3星彩
//        netReptileService.getFourStarTry(url)//4星彩
        // execute job
        println "排程["+no+"]結束"+new Date()
    }
}
