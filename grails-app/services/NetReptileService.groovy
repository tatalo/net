import grails.transaction.Transactional
import org.jsoup.Jsoup
import groovy.sql.*


class NetReptileService {

    def dataSource

    static void main(String[] args){
        NetReptileService netReptileService = new NetReptileService()
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
    }

    /**
     * 取得六合彩
     */
    def getSixTry = {

    }


    /**
     * 取得賓果
     */
    def getBingo = {
        url->
            println '===getBingo==='
            def element = org.jsoup.Jsoup.connect(url).get()
            def s = ''
            def delimiter = ' '//分隔符號
            String title = ''//完整標頭
            String day = ''//開獎日期
            String no = ''//期數說明
            String no2 = ''//期數(純數字)
            String result = ''//開獎結果

            element.select('div[class=contents_mine_tx01] span[class=font_black15]').each {
                node->
//                    println "說明:"+"${node.text()}"
                    title = "${node.text()}"
                    day = title.substring(0,title.indexOf(' '))
                    no = title.substring(title.indexOf(' ')+1)
                    no2 = no.substring(1,no.length()-1)
            }

            element.select('div[class=contents_box01] div[class=ball_tx]').each {
                node->
//                    println "猜大小 = ${node.text()}"
                    result = "${node.text()}"
            }

            def queryNw300Object = Nw300.findByTypeAndPeriods('07',no2)

            if(queryNw300Object==null){
                println '新的一期'
                def nw300Instance = new Nw300()
                def nw301Instance

                nw300Instance.manCreated = 'system'
                nw300Instance.dateCreated = new Date()
                nw300Instance.manLastUpdated = 'system'
                nw300Instance.lastUpdated = new Date()
                nw300Instance.type = '07'
                nw300Instance.periods = no2
                nw300Instance.opendt = new Date()
                nw300Instance.result = result

                nw300Instance.validate()//資料檢查

                if (!nw300Instance.hasErrors()) {
                    nw300Instance.save(flush: true)

                    element.select('div[class=ball_box01] div').each {
                        node->
                            s += "${node.text()}" + delimiter

                            nw301Instance = new Nw301()
                            nw301Instance.nw300id = nw300Instance
                            nw301Instance.manCreated = 'system'
                            nw301Instance.dateCreated = new Date()
                            nw301Instance.manLastUpdated = 'system'
                            nw301Instance.lastUpdated = new Date()
                            nw301Instance.no = Long.parseLong("${node.text()}")

                            nw301Instance.validate()//資料檢查

                            if(!nw301Instance.hasErrors()){
                                nw301Instance.save(flush: true)
                            }else {
                                nw301Instance.errors.each {
                                    println  'Exception!!==>'+it
                                }
                            }

//                    println "item=${node.text()}"
                    }

                    println '賓果 : '+s

                    element.select('div[class=contents_box01] div[class=ball_red]').each {
                        node->
                            println "超級獎號 = ${node.text()}"

                            nw301Instance = new Nw301()
                            nw301Instance.nw300id = nw300Instance
                            nw301Instance.manCreated = 'system'
                            nw301Instance.dateCreated = new Date()
                            nw301Instance.manLastUpdated = 'system'
                            nw301Instance.lastUpdated = new Date()
                            nw301Instance.no = Long.parseLong("${node.text()}")

                            nw301Instance.validate()//資料檢查

                            if(!nw301Instance.hasErrors()){
                                nw301Instance.save(flush: true)
                            }else {
                                nw301Instance.errors.each {
                                    println it
                                }
                            }
                    }
                } else {
                    nw300Instance.errors.each {
                        println it
                    }
                }
            }else{
                println '本次賓果重複'
            }

            println ''
    }

    /**
     * 取得威力彩
     */
    def getWayLiTry = {
        url->
            println '===getWayLiTry==='
            def element = org.jsoup.Jsoup.connect(url).get()

            def s1 = ''//開出順序
            def s2 = ''//大小順序
            def delimiter = ' '

            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==0){
//                        println "說明:"+"${node.text()}"
                        String title = "${node.text()}"
                        String day = title.substring(0,title.indexOf(' '))
                        String no = title.substring(title.indexOf(' ')+1)
                        String no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }

            element.select('div[class=contents_box02] div[class=ball_tx ball_green]').eachWithIndex {
                node,index->
                    if(index<6){
                        s1 += "${node.text()}" + delimiter
                    }else if(index>=6 && index<12){
                        s2 += "${node.text()}" + delimiter
                    }
//                    println "item=${node.text()}"
            }

            println '威力彩(開出順序) : '+s1
            println '威力彩(大小順序) : '+s2

            element.select('div[class=contents_box02] div[class=ball_red]').eachWithIndex {
                node, index->
                    if(index==0){
                        println "第二區 = ${node.text()}"
                    }
            }

            println ''
    }

    /**
     * 取得38樂合彩
     */
    def getThreeEightTry = {
        url->
            println '===getThreeEightTry==='
            def element = org.jsoup.Jsoup.connect(url).get()

            def s1 = ''//開出順序
            def s2 = ''//大小順序
            def delimiter = ' '

            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==1){
//                        println "說明:"+"${node.text()}"
                        String title = "${node.text()}"
                        String day = title.substring(0,title.indexOf(' '))
                        String no = title.substring(title.indexOf(' ')+1)
                        String no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }

            element.select('div[class=contents_box02] div[class=ball_tx ball_green]').eachWithIndex {
                node,index->
                    if(index<6){
                        s1 += "${node.text()}" + delimiter
                    }else if(index>=6 && index<12){
                        s2 += "${node.text()}" + delimiter
                    }
//                    println "item=${node.text()}"
            }

            println '38樂合彩(開出順序) : '+s1
            println '38樂合彩(大小順序) : '+s2

            println ''
    }

    /**
     * 取得大樂透
     */
    def getBigLuckToa = {
        url->
            println '===getBigLuckToa==='
            def element = org.jsoup.Jsoup.connect(url).get()

            def s1 = ''//開出順序
            def s2 = ''//大小順序
            def delimiter = ' '
            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==2){
//                        println "說明:"+"${node.text()}"
                        String title = "${node.text()}"
                        String day = title.substring(0,title.indexOf(' '))
                        String no = title.substring(title.indexOf(' ')+1)
                        String no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }
            element.select('div[class=contents_box02] div[class=ball_tx ball_yellow]').eachWithIndex {
                node,index->
                    if(index<6){
                        s1 += "${node.text()}" + delimiter
                    }else if(index>=6 && index<12){
                        s2 += "${node.text()}" + delimiter
                    }
//                    println "item=${node.text()}"
            }

            println '大樂透(開出順序) : '+s1
            println '大樂透(大小順序) : '+s2

            element.select('div[class=contents_box02] div[class=ball_red]').eachWithIndex {
                node, index->
                    if(index==1){
                        println "特別號 = ${node.text()}"
                    }
            }

            println ''
    }


    /**
     * 取得49樂合彩
     */
    def getFourNineTry = {
        url->
            println '===getFourNineTry==='
            def element = org.jsoup.Jsoup.connect(url).get()

            def s1 = ''//開出順序
            def s2 = ''//大小順序
            def delimiter = ' '
            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==3){
//                        println "說明:"+"${node.text()}"
                        String title = "${node.text()}"
                        String day = title.substring(0,title.indexOf(' '))
                        String no = title.substring(title.indexOf(' ')+1)
                        String no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }
            element.select('div[class=contents_box02] div[class=ball_tx ball_yellow]').eachWithIndex {
                node,index->
                    if(index<6){
                        s1 += "${node.text()}" + delimiter
                    }else if(index>=6 && index<12){
                        s2 += "${node.text()}" + delimiter
                    }
//                    println "item=${node.text()}"
            }

            println '49樂合彩(開出順序) : '+s1
            println '49樂合彩(大小順序) : '+s2

            println ''
    }


    /**
     * 取得大福彩
     */
    def getBigFuTry = {
        url->
            println '===getBigFuTry==='
            def element = org.jsoup.Jsoup.connect(url).get()

            def s1 = ''//開出順序
            def s2 = ''//大小順序
            def delimiter = ' '
            element.select('div[class=contents_mine_tx05] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==0){
//                        println "說明:"+"${node.text()}"
                        String title = "${node.text()}"
                        String day = title.substring(0,title.indexOf(' '))
                        String no = title.substring(title.indexOf(' ')+1)
                        String no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }
            element.select('div[class=contents_box05] div[class=ball_tx ball_melon_red]').eachWithIndex {
                node,index->
                    if(index<7){
                        s1 += "${node.text()}" + delimiter
                    }else if(index>=7 && index<14){
                        s2 += "${node.text()}" + delimiter
                    }
//                    println "item=${node.text()}"
            }

            println '大福彩(開出順序) : '+s1
            println '大福彩(大小順序) : '+s2

            println ''
    }


    /**
     * 取得今彩539
     */
    def getFiveThreeNine = {
        url->
            println '===getFiveThreeNine==='
            def element = org.jsoup.Jsoup.connect(url).get()

            def s1 = ''//開出順序
            def s2 = ''//大小順序
            def delimiter = ' '
            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==4){
//                        println "說明:"+"${node.text()}"
                        String title = "${node.text()}"
                        String day = title.substring(0,title.indexOf(' '))
                        String no = title.substring(title.indexOf(' ')+1)
                        String no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }
            element.select('div[class=contents_box03] div[class=ball_tx ball_lemon]').eachWithIndex {
                node,index->
                    if(index<5){
                        s1 += "${node.text()}" + delimiter
                    }else if(index>=5 && index<10){
                        s2 += "${node.text()}" + delimiter
                    }
//                    println "item=${node.text()}"
            }

            println '今彩539(開出順序) : '+s1
            println '今彩539(大小順序) : '+s2

            println ''
    }


    /**
     * 取得39樂合彩
     */
    def getThreeNineTry = {
        url->
            println '===getThreeNineTry==='
            def element = org.jsoup.Jsoup.connect(url).get()

            def s1 = ''//開出順序
            def s2 = ''//大小順序
            def delimiter = ' '
            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==5){
//                        println "說明:"+"${node.text()}"
                        String title = "${node.text()}"
                        String day = title.substring(0,title.indexOf(' '))
                        String no = title.substring(title.indexOf(' ')+1)
                        String no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }
            element.select('div[class=contents_box03] div[class=ball_tx ball_lemon]').eachWithIndex {
                node,index->
                    if(index<5){
                        s1 += "${node.text()}" + delimiter
                    }else if(index>=5 && index<10){
                        s2 += "${node.text()}" + delimiter
                    }
//                    println "item=${node.text()}"
            }

            println '39樂合彩(開出順序) : '+s1
            println '39樂合彩(大小順序) : '+s2

            println ''
    }


    /**
     * 取得3星彩
     */
    def getThreeStarTry = {
        url->
            println '===getThreeStarTry==='
            def element = org.jsoup.Jsoup.connect(url).get()

            def s1 = ''//開出順序
            def delimiter = ' '
            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==6){
//                        println "說明:"+"${node.text()}"
                        String title = "${node.text()}"
                        String day = title.substring(0,title.indexOf(' '))
                        String no = title.substring(title.indexOf(' ')+1)
                        String no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }
            element.select('div[class=contents_box04] div[class=ball_tx ball_purple]').eachWithIndex {
                node,index->
                    if(index<3){
                        s1 += "${node.text()}" + delimiter
                    }
//                    println "item=${node.text()}"
            }

            println '3星彩(中獎號碼) : '+s1

            println ''
    }


    /**
     * 取得4星彩
     */
    def getFourStarTry = {
        url->
            println '===getFourStarTry==='
            def element = org.jsoup.Jsoup.connect(url).get()

            def s1 = ''//開出順序
            def delimiter = ' '
            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==7){
//                        println "說明:"+"${node.text()}"
                        String title = "${node.text()}"
                        String day = title.substring(0,title.indexOf(' '))
                        String no = title.substring(title.indexOf(' ')+1)
                        String no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }
            element.select('div[class=contents_box04] div[class=ball_tx ball_purple]').eachWithIndex {
                node,index->
                    if(index>2 && index<7){
                        s1 += "${node.text()}" + delimiter
                    }
//                    println "item=${node.text()}"
            }

            println '4星彩(中獎號碼) : '+s1

            println ''
    }

}
