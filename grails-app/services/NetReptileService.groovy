import grails.transaction.Transactional
import org.jsoup.Jsoup
import groovy.sql.*

@Transactional
class NetReptileService {

    def dataSource

    /**
     * 取得賓果
     */
    def getBingo = {
        url->
            println '===getBingo==='
            def element = org.jsoup.Jsoup.connect(url).get()
            def s = ''
            def delimiter = ' '


            println '====寫入DB Start===='

//            def sql = " select * from S_USER "
//            def ds = new Sql(dataSource)
//            def result = ds.firstRow(sql)
//            def name = result.USER_NAME
//
//            println 'name = ' + name

            def nw300Instance = new Nw300()

//            nw300Instance.id = 1
//            nw300Instance.version = 2
//            nw300Instance.manCreatedId = 'Allen01'
//            nw300Instance.dateCreated = new Date()
//            nw300Instance.manLastUpdatedId = 'Allen02'
//            nw300Instance.lastUpdated = new Date()
//            nw300Instance.type = 'Bingo'
//            nw300Instance.periods = '12345'
//            nw300Instance.opendt = new Date()
//
//            nw300Instance.validate()//資料檢查
//
//            if (!nw300Instance.hasErrors()) {
//                println '1111'
//                nw300Instance.save(flush: true)
//                println '2222'
//            } else {
//                println '333'
//                nw300Instance.errors.each {
//                    println it
//                }
//                println '5555'
//            }







            println '====寫入DB End===='


            element.select('div[class=contents_mine_tx01] span[class=font_black15]').each {
                node->
                    println "說明:"+"${node.text()}"
            }

            element.select('div[class=ball_box01] div').each {
                node->
                    s += "${node.text()}" + delimiter
//                    println "item=${node.text()}"
            }

            println '賓果 : '+s

            element.select('div[class=contents_box01] div[class=ball_red]').each {
                node->
                    println "超級獎號 = ${node.text()}"
            }

            element.select('div[class=contents_box01] div[class=ball_tx]').each {
                node->
                    println "猜大小 = ${node.text()}"
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
                        println "說明:"+"${node.text()}"
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
                        println "說明:"+"${node.text()}"
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
                        println "說明:"+"${node.text()}"
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
                        println "說明:"+"${node.text()}"
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
                        println "說明:"+"${node.text()}"
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
                        println "說明:"+"${node.text()}"
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
                        println "說明:"+"${node.text()}"
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
                        println "說明:"+"${node.text()}"
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
                        println "說明:"+"${node.text()}"
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
