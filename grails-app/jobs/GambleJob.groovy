class GambleJob {

    def netReptileService

    static triggers = {
      simple repeatInterval: 300000 // 5分鐘跑一次
    }

    def execute() {
        def no = System.currentTimeMillis()
        println "排程["+no+"]開始"+new Date()
        def url = "http://www.taiwanlottery.com.tw/index_new.aspx"
        def url2 = "http://bet.hkjc.com/marksix/index.aspx?lang=ch"

        try{
            netReptileService.getSixTry(url2)//六合彩 01
            netReptileService.getBigFuTry(url)//大福彩 02
            netReptileService.getWayLiTry(url)//威力彩 03
            netReptileService.getThreeEightTry(url)//38樂合彩 04
            netReptileService.getBigLuckToa(url)//大樂透 05
            netReptileService.getFourNineTry(url)//49樂合彩 06
            netReptileService.getThreeNineTry(url)//39樂合彩 07
            netReptileService.getFiveThreeNine(url)//今彩539 08
            netReptileService.getThreeStarTry(url)//3星彩 09
            netReptileService.getFourStarTry(url)//4星彩 10
        }catch(Exception e){
            println 'Exception=>'+e
        }


    }
}
