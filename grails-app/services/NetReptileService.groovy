import grails.transaction.Transactional
import org.jsoup.Jsoup
import groovy.sql.*


class NetReptileService {

    def dataSource

    static void main(String[] args){
        NetReptileService netReptileService = new NetReptileService()
        def url = ""
        def url2 = ""

        try{
            netReptileService.getSixTry(url2)//六合彩
        }catch (Exception e){
            println 'Exception=>'+e
        }
    }

    /**
     * 取得六合彩
     */
    def getSixTry = {
        url->
            println '===getSixTry==='
            def element = org.jsoup.Jsoup.connect(url).get()

            def s1 = ''//開出順序
            def s2 = ''//大小順序
            def delimiter = ' '
            String title = ''//完整標頭
            String day = ''//開獎日期
            String no = ''//期數說明
            String no2 = ''//期數(純數字)

            element.select('div[id=oddsTable] td[class=content]').eachWithIndex {
                node,index->
                    if(index==10){//攪珠期數
                        no2 = "${node.text()}"
                    }else if(index==11){//攪珠日期
                        day = "${node.text()}"
                    }
            }

//            println '攪珠期數(1) = '+no2
//            println '攪珠期數(2) = '+no2.substring(7)
//            println '攪珠日期(1) = '+day
//            println '攪珠日期(2) = '+day.substring(13,17) + "/" + day.substring(7,12)

            def queryNw300Object = Nw300.findByTypeAndPeriods('01',no2.substring(7))

            if(queryNw300Object==null){
                println '新的一期'
                def nw300Instance = new Nw300()
                def nw301Instance
                def src = ""

                nw300Instance.manCreated = 'system'
                nw300Instance.dateCreated = new Date()
                nw300Instance.manLastUpdated = 'system'
                nw300Instance.lastUpdated = new Date()
                nw300Instance.type = '01'
                nw300Instance.periods = no2.substring(7)

                day = day.substring(13,17) + "/" +day.substring(10,12)+ '/' +day.substring(7,9)
                nw300Instance.opendt = Date.parse('yyyy/MM/dd',day)

                nw300Instance.validate()//資料檢查

                if(!nw300Instance.hasErrors()){
                    nw300Instance.save(flush: true)

                    String a = ""
                    int i = 1

                    element.select('div[id=oddsTable] img').eachWithIndex {
                        node,index->

                            src = "${node.absUrl('src')}"

                            if(src.indexOf(a)>=0){
//                                println 'no = '+ Long.parseLong(src.substring(a.length(),a.length()+2))
                                nw301Instance = new Nw301()
                                nw301Instance.nw300id = nw300Instance
                                nw301Instance.manCreated = 'system'
                                nw301Instance.dateCreated = new Date()
                                nw301Instance.manLastUpdated = 'system'
                                nw301Instance.lastUpdated = new Date()
                                nw301Instance.no = Long.parseLong(src.substring(a.length(),a.length()+2))
                                nw301Instance.opidx = i
                                if(i==7){
                                    nw301Instance.isspno = 1
                                }

                                nw301Instance.validate()//資料檢查

                                if(!nw301Instance.hasErrors()){
                                    nw301Instance.save(flush: true)
                                }else {
                                    nw301Instance.errors.each {
                                        println  'Exception!!==>'+it
                                    }
                                }

                                i++
                            }

                    }

                }else{
                    nw300Instance.errors.each {
                        println it
                    }
                }

            }else{
                println '本次六和彩重複'
            }

            println ''
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

            def queryNw300Object = Nw300.findByTypeAndPeriods('11',no2)

            def ds = new Sql(dataSource)
            def sql = " select PK_GET.F_BINGODT($no2) dt from dual a "

            def r = ds.firstRow(sql)
            def opdt = r?.dt?.toString()

            if(queryNw300Object==null){
                println '新的一期'
                def nw300Instance = new Nw300()
                def nw301Instance

                nw300Instance.manCreated = 'system'
                nw300Instance.dateCreated = new Date()
                nw300Instance.manLastUpdated = 'system'
                nw300Instance.lastUpdated = new Date()
                nw300Instance.type = '11'
                nw300Instance.periods = no2
                nw300Instance.opendt = Date.parse('yyyy-MM-dd HH:mm:ss', opdt) //2015-09-08 23:55:00
                if(result=='大'){
                    result = '2'
                }else if(result=='小'){
                    result = '1'
                }else{
                    result = '0'
                }
                nw300Instance.result = result

                nw300Instance.validate()//資料檢查

                if (!nw300Instance.hasErrors()) {
                    nw300Instance.save(flush: true)

                    element.select('div[class=ball_box01] div').eachWithIndex {
                        node, index->
                            s += "${node.text()}" + delimiter

                            nw301Instance = new Nw301()
                            nw301Instance.nw300id = nw300Instance
                            nw301Instance.manCreated = 'system'
                            nw301Instance.dateCreated = new Date()
                            nw301Instance.manLastUpdated = 'system'
                            nw301Instance.lastUpdated = new Date()
                            nw301Instance.no = Long.parseLong("${node.text()}")
                            nw301Instance.opidx = index+1

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
                            nw301Instance.isspno = 1
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
            String title = ''//完整標頭
            String day = ''//開獎日期
            String no = ''//期數說明
            String no2 = ''//期數(純數字)

            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==0){
//                        println "說明:"+"${node.text()}"
                        title = "${node.text()}"
                        day = title.substring(0,title.indexOf(' '))
                        no = title.substring(title.indexOf(' ')+1)
                        no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }

            def queryNw300Object = Nw300.findByTypeAndPeriods('03',no2)

            if(queryNw300Object==null){
                println '新的一期'
                def nw300Instance = new Nw300()
                def nw301Instance

                nw300Instance.manCreated = 'system'
                nw300Instance.dateCreated = new Date()
                nw300Instance.manLastUpdated = 'system'
                nw300Instance.lastUpdated = new Date()
                nw300Instance.type = '03'
                nw300Instance.periods = no2

                day = ((day.substring(0,3)).toInteger()+1911).toString() + day.substring(3)
                nw300Instance.opendt = Date.parse('yyyy/MM/dd',day)

                nw300Instance.validate()//資料檢查

                if(!nw300Instance.hasErrors()){
                    nw300Instance.save(flush: true)


                    element.select('div[class=contents_box02] div[class=ball_tx ball_green]').eachWithIndex {
                        node,index->
                            if(index<6){
                                s1 += "${node.text()}" + delimiter

                                nw301Instance = new Nw301()
                                nw301Instance.nw300id = nw300Instance
                                nw301Instance.manCreated = 'system'
                                nw301Instance.dateCreated = new Date()
                                nw301Instance.manLastUpdated = 'system'
                                nw301Instance.lastUpdated = new Date()
                                nw301Instance.no = Long.parseLong("${node.text()}")
                                nw301Instance.opidx = index+1

                                nw301Instance.validate()//資料檢查

                                if(!nw301Instance.hasErrors()){
                                    nw301Instance.save(flush: true)
                                }else {
                                    nw301Instance.errors.each {
                                        println  'Exception!!==>'+it
                                    }
                                }

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

                                nw301Instance = new Nw301()
                                nw301Instance.isspno = 1
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
                    }
                }else{
                    nw300Instance.errors.each {
                        println it
                    }
                }
            }else{
                println '本次威力彩重複'
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
            String title = ''//完整標頭
            String day = ''//開獎日期
            String no = ''//期數說明
            String no2 = ''//期數(純數字)

            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==1){
//                        println "說明:"+"${node.text()}"
                        title = "${node.text()}"
                        day = title.substring(0,title.indexOf(' '))
                        no = title.substring(title.indexOf(' ')+1)
                        no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }

            def queryNw300Object = Nw300.findByTypeAndPeriods('04',no2)

            if(queryNw300Object==null){
                println '新的一期'
                def nw300Instance = new Nw300()
                def nw301Instance

                nw300Instance.manCreated = 'system'
                nw300Instance.dateCreated = new Date()
                nw300Instance.manLastUpdated = 'system'
                nw300Instance.lastUpdated = new Date()
                nw300Instance.type = '04'
                nw300Instance.periods = no2
//                nw300Instance.opendt = new Date()
                day = ((day.substring(0,3)).toInteger()+1911).toString() + day.substring(3)
                nw300Instance.opendt = Date.parse('yyyy/MM/dd',day)

                nw300Instance.validate()//資料檢查

                if(!nw300Instance.hasErrors()){
                    nw300Instance.save(flush: true)

                    element.select('div[class=contents_box02] div[class=ball_tx ball_green]').eachWithIndex {
                        node,index->
                            if(index<6){
                                s1 += "${node.text()}" + delimiter

                                nw301Instance = new Nw301()
                                nw301Instance.nw300id = nw300Instance
                                nw301Instance.manCreated = 'system'
                                nw301Instance.dateCreated = new Date()
                                nw301Instance.manLastUpdated = 'system'
                                nw301Instance.lastUpdated = new Date()
                                nw301Instance.no = Long.parseLong("${node.text()}")
                                nw301Instance.opidx = index+1

                                nw301Instance.validate()//資料檢查

                                if(!nw301Instance.hasErrors()){
                                    nw301Instance.save(flush: true)
                                }else {
                                    nw301Instance.errors.each {
                                        println  'Exception!!==>'+it
                                    }
                                }

                            }else if(index>=6 && index<12){
                                s2 += "${node.text()}" + delimiter
                            }
//                    println "item=${node.text()}"
                    }

                    println '38樂合彩(開出順序) : '+s1
                    println '38樂合彩(大小順序) : '+s2

                }else{
                    nw300Instance.errors.each {
                        println it
                    }
                }
            }else{
                println '本次38樂合彩重複'
            }

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
            String title = ''//完整標頭
            String day = ''//開獎日期
            String no = ''//期數說明
            String no2 = ''//期數(純數字)
            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==2){
//                        println "說明:"+"${node.text()}"
                        title = "${node.text()}"
                        day = title.substring(0,title.indexOf(' '))
                        no = title.substring(title.indexOf(' ')+1)
                        no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }

            def queryNw300Object = Nw300.findByTypeAndPeriods('05',no2)

            if(queryNw300Object==null){
                println '新的一期'
                def nw300Instance = new Nw300()
                def nw301Instance

                nw300Instance.manCreated = 'system'
                nw300Instance.dateCreated = new Date()
                nw300Instance.manLastUpdated = 'system'
                nw300Instance.lastUpdated = new Date()
                nw300Instance.type = '05'
                nw300Instance.periods = no2
//                nw300Instance.opendt = new Date()
                day = ((day.substring(0,3)).toInteger()+1911).toString() + day.substring(3)
                nw300Instance.opendt = Date.parse('yyyy/MM/dd',day)

                nw300Instance.validate()//資料檢查
                if(!nw300Instance.hasErrors()){
                    nw300Instance.save(flush: true)

                    element.select('div[class=contents_box02] div[class=ball_tx ball_yellow]').eachWithIndex {
                        node,index->
                            if(index<6){
                                s1 += "${node.text()}" + delimiter

                                nw301Instance = new Nw301()
                                nw301Instance.nw300id = nw300Instance
                                nw301Instance.manCreated = 'system'
                                nw301Instance.dateCreated = new Date()
                                nw301Instance.manLastUpdated = 'system'
                                nw301Instance.lastUpdated = new Date()
                                nw301Instance.no = Long.parseLong("${node.text()}")
                                nw301Instance.opidx = index+1

                                nw301Instance.validate()//資料檢查

                                if(!nw301Instance.hasErrors()){
                                    nw301Instance.save(flush: true)
                                }else {
                                    nw301Instance.errors.each {
                                        println  'Exception!!==>'+it
                                    }
                                }

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

                                nw301Instance = new Nw301()
                                nw301Instance.isspno = 1
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
                    }
                }else{
                    nw300Instance.errors.each {
                        println it
                    }
                }
            }else{
                println '本次大樂透重複'
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
            String title = ''//完整標頭
            String day = ''//開獎日期
            String no = ''//期數說明
            String no2 = ''//期數(純數字)

            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==3){
//                        println "說明:"+"${node.text()}"
                        title = "${node.text()}"
                        day = title.substring(0,title.indexOf(' '))
                        no = title.substring(title.indexOf(' ')+1)
                        no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }

            def queryNw300Object = Nw300.findByTypeAndPeriods('06',no2)

            if(queryNw300Object==null){
                println '新的一期'
                def nw300Instance = new Nw300()
                def nw301Instance

                nw300Instance.manCreated = 'system'
                nw300Instance.dateCreated = new Date()
                nw300Instance.manLastUpdated = 'system'
                nw300Instance.lastUpdated = new Date()
                nw300Instance.type = '06'
                nw300Instance.periods = no2
//                nw300Instance.opendt = new Date()
                day = ((day.substring(0,3)).toInteger()+1911).toString() + day.substring(3)
                nw300Instance.opendt = Date.parse('yyyy/MM/dd',day)

                nw300Instance.validate()//資料檢查

                if(!nw300Instance.hasErrors()){
                    nw300Instance.save(flush: true)

                    element.select('div[class=contents_box02] div[class=ball_tx ball_yellow]').eachWithIndex {
                        node,index->
                            if(index<6){
                                s1 += "${node.text()}" + delimiter

                                nw301Instance = new Nw301()
                                nw301Instance.nw300id = nw300Instance
                                nw301Instance.manCreated = 'system'
                                nw301Instance.dateCreated = new Date()
                                nw301Instance.manLastUpdated = 'system'
                                nw301Instance.lastUpdated = new Date()
                                nw301Instance.no = Long.parseLong("${node.text()}")
                                nw301Instance.opidx = index+1

                                nw301Instance.validate()//資料檢查

                                if(!nw301Instance.hasErrors()){
                                    nw301Instance.save(flush: true)
                                }else {
                                    nw301Instance.errors.each {
                                        println  'Exception!!==>'+it
                                    }
                                }
                            }else if(index>=6 && index<12){
                                s2 += "${node.text()}" + delimiter
                            }
//                    println "item=${node.text()}"
                    }

                    println '49樂合彩(開出順序) : '+s1
                    println '49樂合彩(大小順序) : '+s2

                }else{
                    nw300Instance.errors.each {
                        println it
                    }
                }
            }else{
                println '本次49樂合彩重複'
            }

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
            String title = ''//完整標頭
            String day = ''//開獎日期
            String no = ''//期數說明
            String no2 = ''//期數(純數字)

            element.select('div[class=contents_mine_tx05] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==0){
//                        println "說明:"+"${node.text()}"
                        title = "${node.text()}"
                        day = title.substring(0,title.indexOf(' '))
                        no = title.substring(title.indexOf(' ')+1)
                        no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }

            def queryNw300Object = Nw300.findByTypeAndPeriods('02',no2)

            if(queryNw300Object==null){
                println '新的一期'
                def nw300Instance = new Nw300()
                def nw301Instance

                nw300Instance.manCreated = 'system'
                nw300Instance.dateCreated = new Date()
                nw300Instance.manLastUpdated = 'system'
                nw300Instance.lastUpdated = new Date()
                nw300Instance.type = '02'
                nw300Instance.periods = no2

//                nw300Instance.opendt = new Date()
                day = ((day.substring(0,3)).toInteger()+1911).toString() + day.substring(3)
                nw300Instance.opendt = Date.parse('yyyy/MM/dd',day)

                nw300Instance.validate()//資料檢查

                if(!nw300Instance.hasErrors()){
                    nw300Instance.save(flush: true)

                    element.select('div[class=contents_box05] div[class=ball_tx ball_melon_red]').eachWithIndex {
                        node,index->
                            if(index<7){
                                s1 += "${node.text()}" + delimiter

                                nw301Instance = new Nw301()
                                nw301Instance.nw300id = nw300Instance
                                nw301Instance.manCreated = 'system'
                                nw301Instance.dateCreated = new Date()
                                nw301Instance.manLastUpdated = 'system'
                                nw301Instance.lastUpdated = new Date()
                                nw301Instance.no = Long.parseLong("${node.text()}")
                                nw301Instance.opidx = index+1

                                nw301Instance.validate()//資料檢查

                                if(!nw301Instance.hasErrors()){
                                    nw301Instance.save(flush: true)
                                }else {
                                    nw301Instance.errors.each {
                                        println  'Exception!!==>'+it
                                    }
                                }
                            }else if(index>=7 && index<14){
                                s2 += "${node.text()}" + delimiter
                            }
//                    println "item=${node.text()}"
                    }

                    println '大福彩(開出順序) : '+s1
                    println '大福彩(大小順序) : '+s2

                }else{
                    nw300Instance.errors.each {
                        println it
                    }
                }
            }else{
                println '本次大福彩重複'
            }

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
            String title = ''//完整標頭
            String day = ''//開獎日期
            String no = ''//期數說明
            String no2 = ''//期數(純數字)

            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==4){
//                        println "說明:"+"${node.text()}"
                        title = "${node.text()}"
                        day = title.substring(0,title.indexOf(' '))
                        no = title.substring(title.indexOf(' ')+1)
                        no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }

            def queryNw300Object = Nw300.findByTypeAndPeriods('08',no2)

            if(queryNw300Object==null){
                println '新的一期'

                def nw300Instance = new Nw300()
                def nw301Instance

                nw300Instance.manCreated = 'system'
                nw300Instance.dateCreated = new Date()
                nw300Instance.manLastUpdated = 'system'
                nw300Instance.lastUpdated = new Date()
                nw300Instance.type = '08'
                nw300Instance.periods = no2
//                nw300Instance.opendt = new Date()
                day = ((day.substring(0,3)).toInteger()+1911).toString() + day.substring(3)
                nw300Instance.opendt = Date.parse('yyyy/MM/dd',day)

                nw300Instance.validate()//資料檢查

                if(!nw300Instance.hasErrors()){
                    nw300Instance.save(flush: true)


                    element.select('div[class=contents_box03] div[class=ball_tx ball_lemon]').eachWithIndex {
                        node,index->
                            if(index<5){
                                s1 += "${node.text()}" + delimiter

                                nw301Instance = new Nw301()
                                nw301Instance.nw300id = nw300Instance
                                nw301Instance.manCreated = 'system'
                                nw301Instance.dateCreated = new Date()
                                nw301Instance.manLastUpdated = 'system'
                                nw301Instance.lastUpdated = new Date()
                                nw301Instance.no = Long.parseLong("${node.text()}")
                                nw301Instance.opidx = index+1

                                nw301Instance.validate()//資料檢查

                                if(!nw301Instance.hasErrors()){
                                    nw301Instance.save(flush: true)
                                }else {
                                    nw301Instance.errors.each {
                                        println  'Exception!!==>'+it
                                    }
                                }

                            }else if(index>=5 && index<10){
                                s2 += "${node.text()}" + delimiter
                            }
//                    println "item=${node.text()}"
                    }

                    println '今彩539(開出順序) : '+s1
                    println '今彩539(大小順序) : '+s2
                }else{
                    nw300Instance.errors.each {
                        println it
                    }
                }
            }else{
                println '本次今彩539重複'
            }

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
            String title = ''//完整標頭
            String day = ''//開獎日期
            String no = ''//期數說明
            String no2 = ''//期數(純數字)

            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==5){
//                        println "說明:"+"${node.text()}"
                        title = "${node.text()}"
                        day = title.substring(0,title.indexOf(' '))
                        no = title.substring(title.indexOf(' ')+1)
                        no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
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
//                nw300Instance.opendt = new Date()
                day = ((day.substring(0,3)).toInteger()+1911).toString() + day.substring(3)
                nw300Instance.opendt = Date.parse('yyyy/MM/dd',day)

                nw300Instance.validate()//資料檢查

                if(!nw300Instance.hasErrors()){
                    nw300Instance.save(flush: true)


                    element.select('div[class=contents_box03] div[class=ball_tx ball_lemon]').eachWithIndex {
                        node,index->
                            if(index<5){
                                s1 += "${node.text()}" + delimiter

                                nw301Instance = new Nw301()
                                nw301Instance.nw300id = nw300Instance
                                nw301Instance.manCreated = 'system'
                                nw301Instance.dateCreated = new Date()
                                nw301Instance.manLastUpdated = 'system'
                                nw301Instance.lastUpdated = new Date()
                                nw301Instance.no = Long.parseLong("${node.text()}")
                                nw301Instance.opidx = index+1

                                nw301Instance.validate()//資料檢查

                                if(!nw301Instance.hasErrors()){
                                    nw301Instance.save(flush: true)
                                }else {
                                    nw301Instance.errors.each {
                                        println  'Exception!!==>'+it
                                    }
                                }

                            }else if(index>=5 && index<10){
                                s2 += "${node.text()}" + delimiter
                            }
//                    println "item=${node.text()}"
                    }

                    println '39樂合彩(開出順序) : '+s1
                    println '39樂合彩(大小順序) : '+s2
                }else{
                    nw300Instance.errors.each {
                        println it
                    }
                }
            }else{
                println '本次39樂合彩重複'
            }



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
            String title = ''//完整標頭
            String day = ''//開獎日期
            String no = ''//期數說明
            String no2 = ''//期數(純數字)

            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==6){
//                        println "說明:"+"${node.text()}"
                        title = "${node.text()}"
                        day = title.substring(0,title.indexOf(' '))
                        no = title.substring(title.indexOf(' ')+1)
                        no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }

            def queryNw300Object = Nw300.findByTypeAndPeriods('09',no2)

            if(queryNw300Object==null){
                println '新的一期'

                def nw300Instance = new Nw300()
                def nw301Instance

                nw300Instance.manCreated = 'system'
                nw300Instance.dateCreated = new Date()
                nw300Instance.manLastUpdated = 'system'
                nw300Instance.lastUpdated = new Date()
                nw300Instance.type = '09'
                nw300Instance.periods = no2
//                nw300Instance.opendt = new Date()
                day = ((day.substring(0,3)).toInteger()+1911).toString() + day.substring(3)
                nw300Instance.opendt = Date.parse('yyyy/MM/dd',day)

                nw300Instance.validate()//資料檢查

                if(!nw300Instance.hasErrors()){
                    nw300Instance.save(flush: true)

                    element.select('div[class=contents_box04] div[class=ball_tx ball_purple]').eachWithIndex {
                        node,index->
                            if(index<3){
                                s1 += "${node.text()}" + delimiter

                                nw301Instance = new Nw301()
                                nw301Instance.nw300id = nw300Instance
                                nw301Instance.manCreated = 'system'
                                nw301Instance.dateCreated = new Date()
                                nw301Instance.manLastUpdated = 'system'
                                nw301Instance.lastUpdated = new Date()
                                nw301Instance.no = Long.parseLong("${node.text()}")
                                nw301Instance.opidx = index+1

                                nw301Instance.validate()//資料檢查

                                if(!nw301Instance.hasErrors()){
                                    nw301Instance.save(flush: true)
                                }else {
                                    nw301Instance.errors.each {
                                        println  'Exception!!==>'+it
                                    }
                                }

                            }
//                    println "item=${node.text()}"
                    }

                    println '3星彩(中獎號碼) : '+s1

                }else{
                    nw300Instance.errors.each {
                        println it
                    }
                }
            }else{
                println '本次3星彩重複'
            }

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
            String title = ''//完整標頭
            String day = ''//開獎日期
            String no = ''//期數說明
            String no2 = ''//期數(純數字)

            element.select('div[class=contents_mine_tx02] span[class=font_black15]').eachWithIndex {
                node, index->
                    if(index==7){
//                        println "說明:"+"${node.text()}"
                        title = "${node.text()}"
                        day = title.substring(0,title.indexOf(' '))
                        no = title.substring(title.indexOf(' ')+1)
                        no2 = no.substring(1,no.length()-1)
                        println '完整標頭 = '+title
                        println '開獎日期 = '+day
                        println '期數說明 = '+no
                        println '期數(純數字) = '+no2
                    }
            }

            def queryNw300Object = Nw300.findByTypeAndPeriods('10',no2)

            if(queryNw300Object==null){
                println '新的一期'

                def nw300Instance = new Nw300()
                def nw301Instance

                nw300Instance.manCreated = 'system'
                nw300Instance.dateCreated = new Date()
                nw300Instance.manLastUpdated = 'system'
                nw300Instance.lastUpdated = new Date()
                nw300Instance.type = '10'
                nw300Instance.periods = no2
//                nw300Instance.opendt = new Date()
                day = ((day.substring(0,3)).toInteger()+1911).toString() + day.substring(3)
                nw300Instance.opendt = Date.parse('yyyy/MM/dd',day)

                nw300Instance.validate()//資料檢查

                if(!nw300Instance.hasErrors()){
                    nw300Instance.save(flush: true)



                    element.select('div[class=contents_box04] div[class=ball_tx ball_purple]').eachWithIndex {
                        node,index->
                            if(index>2 && index<7){
                                s1 += "${node.text()}" + delimiter

                                nw301Instance = new Nw301()
                                nw301Instance.nw300id = nw300Instance
                                nw301Instance.manCreated = 'system'
                                nw301Instance.dateCreated = new Date()
                                nw301Instance.manLastUpdated = 'system'
                                nw301Instance.lastUpdated = new Date()
                                nw301Instance.no = Long.parseLong("${node.text()}")
                                nw301Instance.opidx = index-2

                                nw301Instance.validate()//資料檢查

                                if(!nw301Instance.hasErrors()){
                                    nw301Instance.save(flush: true)
                                }else {
                                    nw301Instance.errors.each {
                                        println  'Exception!!==>'+it
                                    }
                                }

                            }
//                    println "item=${node.text()}"
                    }

                    println '4星彩(中獎號碼) : '+s1

                }else{
                    nw300Instance.errors.each {
                        println it
                    }
                }




            }else{
                println '本次4星彩重複'
            }



            println ''
    }

}
