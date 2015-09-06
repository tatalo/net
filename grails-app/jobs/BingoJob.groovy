class BingoJob {

    def netReptileService

    static triggers = {
      simple repeatInterval: 60000 // 1分鐘跑一次
    }

    def execute() {
        def no = System.currentTimeMillis()
        println "排程["+no+"]開始"+new Date()
        def url = "http://www.taiwanlottery.com.tw/index_new.aspx"

        netReptileService.getBingo(url)//賓果 11

    }
}
