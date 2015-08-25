import groovy.sql.Sql

class LottoController {

    def dataSource
    def netWinService

    static void main(String[] args){
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
    static def alltabs = [
            [tab: '01', subTab: [[tab: '01' ,viewType: 'content5Video', dataType: '' ],
                                 [tab: '02' ,viewType: 'content2LatestLotto', dataType: '' ]]],
            [tab: '02', subTab: [[tab: '01' ,viewType: 'content3History1', dataType: '01' ],
                                 [tab: '02' ,viewType: 'content3History1', dataType: '02' ],
                                 [tab: '03' ,viewType: 'content3History1', dataType: '03' ],
                                 [tab: '04' ,viewType: 'content3History1', dataType: '04' ],
                                 [tab: '05' ,viewType: 'content3History1', dataType: '05' ],
                                 [tab: '06' ,viewType: 'content3History1', dataType: '06' ],
                                 [tab: '07' ,viewType: 'content3History1', dataType: '07' ],
                                 [tab: '08' ,viewType: 'content3History1', dataType: '08' ],
                                 [tab: '09' ,viewType: 'content3History1', dataType: '09' ],
                                 [tab: '10' ,viewType: 'content3History1', dataType: '10' ],
                                 [tab: '11' ,viewType: 'content3History2', dataType: '11' ]]],
            [tab: '03', subTab: [[tab: '01' ,viewType: 'content1', dataType: '101' ],
                                 [tab: '02' ,viewType: 'historyDataAnalysis1', dataType: '01' ],
                                 [tab: '03' ,viewType: 'cntsOpenAnalysis1', dataType: '01' ],
                                 [tab: '04' ,viewType: 'lastOpenAnalysis1', dataType: '01' ],
                                 [tab: '07' ,viewType: '', dataType: '01' ],
                                 [tab: '08' ,viewType: '', dataType: '01' ],
                                 [tab: '05' ,viewType: 'lastNumberAnalysis1', dataType: '01' ]]],
            [tab: '04', subTab: [[tab: '01' ,viewType: 'content1', dataType: '102' ],
                                 [tab: '02' ,viewType: 'historyDataAnalysis1', dataType: '02' ],
                                 [tab: '03' ,viewType: 'cntsOpenAnalysis1', dataType: '02' ],
                                 [tab: '04' ,viewType: 'lastOpenAnalysis1', dataType: '02' ],
                                 [tab: '07' ,viewType: '', dataType: '02' ],
                                 [tab: '08' ,viewType: '', dataType: '02' ],
                                 [tab: '05' ,viewType: 'lastNumberAnalysis1', dataType: '02' ]]],
            [tab: '05', subTab: [[tab: '01' ,viewType: 'content1', dataType: '103' ],
                                 [tab: '02' ,viewType: 'historyDataAnalysis2', dataType: '03' ],
                                 [tab: '03' ,viewType: 'cntsOpenAnalysis2', dataType: '03' ],
                                 [tab: '04' ,viewType: 'lastOpenAnalysis2', dataType: '03' ],
                                 [tab: '07' ,viewType: '', dataType: '03' ],
                                 [tab: '08' ,viewType: '', dataType: '03' ],
                                 [tab: '05' ,viewType: 'lastNumberAnalysis2', dataType: '03' ]]],
            [tab: '06', subTab: [[tab: '01' ,viewType: 'content1', dataType: '104' ],
                                 [tab: '02' ,viewType: 'historyDataAnalysis1', dataType: '04' ],
                                 [tab: '03' ,viewType: 'cntsOpenAnalysis1', dataType: '04' ],
                                 [tab: '04' ,viewType: 'serialOpenAnalysis1', dataType: '04' ],
                                 [tab: '07' ,viewType: '', dataType: '04' ],
                                 [tab: '08' ,viewType: '', dataType: '04' ],
                                 [tab: '05' ,viewType: 'lastNumberAnalysis1', dataType: '04' ]]],
            [tab: '07', subTab: [[tab: '01' ,viewType: 'content1', dataType: '105' ],
                                 [tab: '02' ,viewType: 'historyDataAnalysis1', dataType: '05' ],
                                 [tab: '03' ,viewType: 'cntsOpenAnalysis', dataType: '05' ],
                                 [tab: '04' ,viewType: 'lastOpenAnalysis1', dataType: '05' ],
                                 [tab: '07' ,viewType: '', dataType: '05' ],
                                 [tab: '08' ,viewType: '', dataType: '05' ],
                                 [tab: '05' ,viewType: 'lastNumberAnalysis1', dataType: '05' ]]],
            [tab: '08', subTab: [[tab: '01' ,viewType: 'content1', dataType: '106' ],
                                 [tab: '02' ,viewType: 'historyDataAnalysis1', dataType: '06' ],
                                 [tab: '03' ,viewType: 'cntsOpenAnalysis1', dataType: '06' ],
                                 [tab: '04' ,viewType: 'lastOpenAnalysis1', dataType: '06' ],
                                 [tab: '07' ,viewType: '', dataType: '06' ],
                                 [tab: '08' ,viewType: '', dataType: '06' ],
                                 [tab: '05' ,viewType: 'lastNumberAnalysis1', dataType: '06' ]]],
            [tab: '09', subTab: [[tab: '01' ,viewType: 'content1', dataType: '107' ],
                                 [tab: '02' ,viewType: 'historyDataAnalysis1', dataType: '07' ],
                                 [tab: '03' ,viewType: 'cntsOpenAnalysis1', dataType: '07' ],
                                 [tab: '04' ,viewType: 'lastOpenAnalysis1', dataType: '07' ],
                                 [tab: '07' ,viewType: '', dataType: '07' ],
                                 [tab: '08' ,viewType: '', dataType: '07' ],
                                 [tab: '05' ,viewType: 'lastNumberAnalysis1', dataType: '07' ]]],
            [tab: '10', subTab: [[tab: '01' ,viewType: 'content1', dataType: '108' ],
                                 [tab: '02' ,viewType: 'historyDataAnalysis1', dataType: '08' ],
                                 [tab: '03' ,viewType: 'cntsOpenAnalysis1', dataType: '08' ],
                                 [tab: '04' ,viewType: 'lastOpenAnalysis1', dataType: '08' ],
                                 [tab: '07' ,viewType: '', dataType: '08' ],
                                 [tab: '08' ,viewType: '', dataType: '08' ],
                                 [tab: '05' ,viewType: 'lastNumberAnalysis1', dataType: '08' ]]],
            [tab: '11', subTab: [[tab: '01' ,viewType: 'content1', dataType: '109' ],
                                 [tab: '02' ,viewType: 'historyDataAnalysis3', dataType: '09' ],
                                 [tab: '03' ,viewType: 'cntsOpenAnalysis3', dataType: '09' ],
                                 [tab: '04' ,viewType: 'lastOpenAnalysis3', dataType: '09' ]]],
            [tab: '12', subTab: [[tab: '01' ,viewType: 'content1', dataType: '110' ],
                                 [tab: '02' ,viewType: 'historyDataAnalysis3', dataType: '10' ],
                                 [tab: '03' ,viewType: 'cntsOpenAnalysis3', dataType: '10' ],
                                 [tab: '04' ,viewType: 'lastOpenAnalysis3', dataType: '10' ]]],
            [tab: '13', subTab: [[tab: '01' ,viewType: 'content1', dataType: '111' ],
                                 [tab: '02' ,viewType: 'historyDataAnalysis1', dataType: '11' ],
                                 [tab: '03' ,viewType: 'cntsOpenAnalysis1', dataType: '11' ],
                                 [tab: '04' ,viewType: 'lastOpenAnalysis1', dataType: '11' ],
                                 [tab: '06' ,viewType: 'historyDataAnalysis1', dataType: '11' ]]]
    ]

    def index() {
        render view: "/lotto/index", model: [alltabs : alltabs]
    }

    def list() {
        if (params.pTab in ["01"]) {
            if (params.pSubTab in ["01"]) {
                render template: "/lotto/content5Video"
            } else {
                render template: "/lotto/content2LatestLotto"
            }
        } else if (params.pTab in ["02"]) {
            params.max = 1
            if (params.pSubTab in ["01","02","03", "04", "05", "06", "07", "08", "09", "10"]) {
                render template: "/lotto/content3History1", model: [pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab, max: params.max]
            } else if (params.pSubTab in ["11"]) {
                render template: "/lotto/content3History2", model: [pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab, max: params.max]
            }
        } else if (params.pTab in ["03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13"]) {
            if (params.pSubTab in ["01"]) { //遊戲介紹
                def nw400I = netWinService.getNw400List(params)

                render template: "/lotto/content1", model: [nw400I: nw400I]
            } else if (params.pSubTab in ["02"]) { //歷史數據
                if (params.pType in ["01","02","04","05","06","07","08","11"]) { //六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
                    def result = netWinService.getHistoryDataAnyalysis1(params)
                    render template: "/lotto/historyDataAnalysis1", model: [nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs,
                                                                            pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                } else if (params.pType in ["03"]) { //威力彩
                    def result = netWinService.getHistoryDataAnyalysis2(params)
                    render template: "/lotto/historyDataAnalysis2", model: [nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnsSPNOs: result.columnsSPNOs,
                                                                            pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                } else if (params.pType in ["09","10"]) { //3星彩, 4星彩
                    def result = netWinService.getHistoryDataAnyalysis3(params)
                    render template: "/lotto/historyDataAnalysis3", model: [nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnIDXS : result.columnIDXS,
                                                                            pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                }
            } else if (params.pSubTab in ["03"]) { //出現次數分析
                if (params.pType in ["01","02","04","05","06","07","08","11"]) { //六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
                    def result = netWinService.getHistoryDataAnyalysis1(params)
                    def result2 = netWinService.getCntsOpenAnalysis1(params)
                    render template: "/lotto/cntsOpenAnalysis1", model: [nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs,
                                                                            pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                } else if (params.pType in ["03"]) { //威力彩
                    def result = netWinService.getHistoryDataAnyalysis2(params)
                    def result2 = netWinService.getCntsOpenAnalysis2(params)
                    render template: "/lotto/cntsOpenAnalysis2", model: [nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnsSPNOs: result.columnsSPNOs,
                                                                         pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                } else if (params.pType in ["09","10"]) { //3星彩, 4星彩
                    def result = netWinService.getHistoryDataAnyalysis3(params)
                    println "result = " + result
                    def result2 = netWinService.getCntsOpenAnalysis3(params)
                    render template: "/lotto/cntsOpenAnalysis3", model: [nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnIDXS : result.columnIDXS,
                                                                         pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                }
            } else if (params.pSubTab in ["04"]) { //最久未開分析
                if (params.pType in ["01","02","04","05","06","07","08","11"]) { //六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
                    def result = netWinService.getHistoryDataAnyalysis1(params)
                    def result2 = netWinService.getLastOpenAnalysis1(params)
                    render template: "/lotto/lastOpenAnalysis1", model: [nw300SERIALI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs,
                                                                         pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                } else if (params.pType in ["03"]) { //威力彩
                    def result = netWinService.getHistoryDataAnyalysis2(params)
                    def result2 = netWinService.getLastOpenAnalysis2(params)
                    render template: "/lotto/lastOpenAnalysis2", model: [nw300SERIALI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnsSPNOs: result.columnsSPNOs,
                                                                         pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                } else if (params.pType in ["09","10"]) { //3星彩, 4星彩
                    def result = netWinService.getHistoryDataAnyalysis3(params)
                    def result2 = netWinService.getLastOpenAnalysis3(params)
                    render template: "/lotto/lastOpenAnalysis3", model: [nw300SERIALI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnIDXS : result.columnIDXS,
                                                                         pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                }
            } else if (params.pSubTab in ["05"]) { //尾數分析
                if (params.pType in ["01","02","04","05","06","07","08"]) { //六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
                    def result = netWinService.getHistoryDataAnyalysis1(params)
                    def result2 = netWinService.getLastNumberAnalysis1(params)
                    render template: "/lotto/lastNumberAnalysis1", model: [createColumn: result2.createColumn,columnsCNTS: result2.columnsCNTS, nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs,
                                                                         pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                } else if (params.pType in ["03"]) { //威力彩
                    def result = netWinService.getHistoryDataAnyalysis2(params)
                    def result2 = netWinService.getLastNumberAnalysis2(params)
                    render template: "/lotto/lastNumberAnalysis2", model: [createColumn: result2.createColumn,columnsCNTS: result2.columnsCNTS, nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnsSPNOs: result.columnsSPNOs,
                                                                           pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                }
            } else if (params.pSubTab in ["06"]) { //綜合分析
                if (params.pType in ["11"]) { //賓果
                    println '123123456'
//                    render template: "/lotto/bingoDataAnalysis"
                    showBingoAnalysis()
                }
            } else if (params.pSubTab in ["07"]) { //連開
                if (params.pType in ["11"]) { //賓果
                    println '123123456'
//                    render template: "/lotto/bingoDataAnalysis"
                    showBingoAnalysis()
                }
            } else if (params.pSubTab in ["08"]) { //連續
                if (params.pType in ["01","02","04","05","06","07","08"])  { //六合彩, 大福彩, 38樂合彩, 49樂合彩, 大樂透, 今彩539, 39樂合彩
                    def result = netWinService.getContinueDataAnyalysis1(params)
                    def result2 = netWinService.getCntsOpenAnalysis1(params)
                    render template: "/lotto/continueOpenAnalysis1", model: [nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs,
                                                                         pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                } else if (params.pType in ["03"])  { //威力彩
                    def result = netWinService.getContinueDataAnyalysis2(params)
                    def result2 = netWinService.getCntsOpenAnalysis2(params)
                    render template: "/lotto/continueOpenAnalysis2", model: [nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnsSPNOs: result.columnsSPNOs,
                                                                         pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
                }
            }
        } else {
            render template: "/base/build"
        }
    }

    def lottoHistoryFilter() {
        if (params.pYyyymm) {
            params.pYyyymmS = params.pYyyymm
            params.pYyyymmE = params.pYyyymm.toInteger() + 1
            df.params_text_date_transform(params: params, list: ["pYyyymmS", "pYyyymmE"])
        }

        if (params.pOpendt) {
            df.params_text_date_transform(params: params, list: ["pOpendt"])
        }

        def nw300I = netWinService.getNw300List(params)

        if (params?.pType in ["01","02","04","05","06","07","08"]) {
            render template: "/lotto/lottoContent1", model: [nw300I: nw300I, pType: params?.pType, totalCount: nw300I?.totalCount]
        } else if (params?.pType in ["03"]) {
            render template: "/lotto/lottoContent2", model: [nw300I: nw300I, pType: params?.pType, totalCount: nw300I?.totalCount]
        } else if (params?.pType in ["09","10"]) {
            render template: "/lotto/lottoContent3", model: [nw300I: nw300I, pType: params?.pType, totalCount: nw300I?.totalCount]
        } else if (params?.pType in ["11"]) {
            render template: "/lotto/lottoContent4", model: [nw300I: nw300I, pType: params?.pType, totalCount: nw300I?.totalCount]
        }
    }

    def historyDataAnyalysis1Filter() {
        def result = netWinService.getHistoryDataAnyalysis1(params)
        render template: "/lotto/historyDataAnalysis1", model: [nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs,
                                                                pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def cntsOpenAnalysis1Filter() {
        def result = netWinService.getHistoryDataAnyalysis1(params)
        def result2 = netWinService.getCntsOpenAnalysis1(params)
        render template: "/lotto/cntsOpenAnalysis1", model: [nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs,
                                                             pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def continueOpenAnalysis1Filter() {
        def result = netWinService.getContinueDataAnyalysis1(params)
        def result2 = netWinService.getCntsOpenAnalysis1(params)
        render template: "/lotto/continueOpenAnalysis1", model: [nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs,
                                                             pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def lastOpenAnalysis1Filter() {
        def result = netWinService.getHistoryDataAnyalysis1(params)
        def result2 = netWinService.getLastOpenAnalysis1(params)
        render template: "/lotto/lastOpenAnalysis1", model: [nw300SERIALI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs,
                                                               pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def lastNumberAnalysis1Filter() {
        def result = netWinService.getHistoryDataAnyalysis1(params)
        def result2 = netWinService.getLastNumberAnalysis1(params)
        render template: "/lotto/lastNumberAnalysis1", model: [createColumn: result2.createColumn,columnsCNTS: result2.columnsCNTS, nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs,
                                                               pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def historyDataAnyalysis2Filter() {
        def result = netWinService.getHistoryDataAnyalysis2(params)
        render template: "/lotto/historyDataAnalysis2", model: [nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnsSPNOs: result.columnsSPNOs,
                                                                pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def cntsOpenAnalysis2Filter() {
        def result = netWinService.getHistoryDataAnyalysis2(params)
        def result2 = netWinService.getCntsOpenAnalysis2(params)
        render template: "/lotto/cntsOpenAnalysis2", model: [nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnsSPNOs: result.columnsSPNOs,
                                                             pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def continueOpenAnalysis2Filter() {
        def result = netWinService.getContinueDataAnyalysis2(params)
        def result2 = netWinService.getCntsOpenAnalysis2(params)
        render template: "/lotto/continueOpenAnalysis2", model: [nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnsSPNOs: result.columnsSPNOs,
                                                             pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def lastOpenAnalysis2Filter() {
        def result = netWinService.getHistoryDataAnyalysis2(params)
        def result2 = netWinService.getLastOpenAnalysis2(params)
        render template: "/lotto/lastOpenAnalysis2", model: [nw300SERIALI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnsSPNOs: result.columnsSPNOs,
                                                               pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def lastNumberAnalysis2Filter() {
        def result = netWinService.getHistoryDataAnyalysis2(params)
        def result2 = netWinService.getLastNumberAnalysis2(params)
        render template: "/lotto/lastNumberAnalysis2", model: [createColumn: result2.createColumn,columnsCNTS: result2.columnsCNTS, nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnsSPNOs: result.columnsSPNOs,
                                                               pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }
    def historyDataAnyalysis3Filter() {
        def result = netWinService.getHistoryDataAnyalysis3(params)
        render template: "/lotto/historyDataAnalysis3", model: [nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnIDXS : result.columnIDXS,
                                                                pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def cntsOpenAnalysis3Filter() {
        def result = netWinService.getHistoryDataAnyalysis3(params)
        def result2 = netWinService.getCntsOpenAnalysis3(params)
        render template: "/lotto/cntsOpenAnalysis3", model: [nw300CNTSI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnIDXS : result.columnIDXS,
                                                             pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def lastOpenAnalysis3Filter() {
        def result = netWinService.getHistoryDataAnyalysis3(params)
        def result2 = netWinService.getLastOpenAnalysis3(params)
        render template: "/lotto/lastOpenAnalysis3", model: [nw300SERIALI: result2.list, maxNum: result2.maxNum, nw300I: result.list, totalCount: result.counts, columnsNOs: result.columnsNOs, columnIDXS : result.columnIDXS,
                                                             pType: params.pType, divId: params.divId, pTab: params.pTab, pSubTab: params.pSubTab]
    }

    def showBigLuckToa () {
        def showpage = params?.showpage?:20 //近幾期
        def sdt = params?.sdt //開始日期
        def edt = params?.edt //結束日期
        def speriods = params?.speriods //開始期數
        def eperiods = params?.eperiods //結束期數
        def s = new Sql(dataSource)

        def sql = """
                  SELECT * FROM (
                  SELECT
                  NW3.PERIODS,
                  TRUNC(NW3.OPENDT) OPENDT,
                  SUM(DECODE(NW31.NO,1,DECODE(NW31.ISSPNO,1,2,1),0)) NO01, SUM(DECODE(NW31.NO,2,DECODE(NW31.ISSPNO,1,2,1),0)) NO02,
                  SUM(DECODE(NW31.NO,3,DECODE(NW31.ISSPNO,1,2,1),0)) NO03, SUM(DECODE(NW31.NO,4,DECODE(NW31.ISSPNO,1,2,1),0)) NO04,
                  SUM(DECODE(NW31.NO,5,DECODE(NW31.ISSPNO,1,2,1),0)) NO05, SUM(DECODE(NW31.NO,6,DECODE(NW31.ISSPNO,1,2,1),0)) NO06,
                  SUM(DECODE(NW31.NO,7,DECODE(NW31.ISSPNO,1,2,1),0)) NO07, SUM(DECODE(NW31.NO,8,DECODE(NW31.ISSPNO,1,2,1),0)) NO08,
                  SUM(DECODE(NW31.NO,9,DECODE(NW31.ISSPNO,1,2,1),0)) NO09, SUM(DECODE(NW31.NO,10,DECODE(NW31.ISSPNO,1,2,1),0)) NO10,
                  SUM(DECODE(NW31.NO,11,DECODE(NW31.ISSPNO,1,2,1),0)) NO11, SUM(DECODE(NW31.NO,12,DECODE(NW31.ISSPNO,1,2,1),0)) NO12,
                  SUM(DECODE(NW31.NO,13,DECODE(NW31.ISSPNO,1,2,1),0)) NO13, SUM(DECODE(NW31.NO,14,DECODE(NW31.ISSPNO,1,2,1),0)) NO14,
                  SUM(DECODE(NW31.NO,15,DECODE(NW31.ISSPNO,1,2,1),0)) NO15, SUM(DECODE(NW31.NO,16,DECODE(NW31.ISSPNO,1,2,1),0)) NO16,
                  SUM(DECODE(NW31.NO,17,DECODE(NW31.ISSPNO,1,2,1),0)) NO17, SUM(DECODE(NW31.NO,18,DECODE(NW31.ISSPNO,1,2,1),0)) NO18,
                  SUM(DECODE(NW31.NO,19,DECODE(NW31.ISSPNO,1,2,1),0)) NO19, SUM(DECODE(NW31.NO,20,DECODE(NW31.ISSPNO,1,2,1),0)) NO20,
                  SUM(DECODE(NW31.NO,21,DECODE(NW31.ISSPNO,1,2,1),0)) NO21, SUM(DECODE(NW31.NO,22,DECODE(NW31.ISSPNO,1,2,1),0)) NO22,
                  SUM(DECODE(NW31.NO,23,DECODE(NW31.ISSPNO,1,2,1),0)) NO23, SUM(DECODE(NW31.NO,24,DECODE(NW31.ISSPNO,1,2,1),0)) NO24,
                  SUM(DECODE(NW31.NO,25,DECODE(NW31.ISSPNO,1,2,1),0)) NO25, SUM(DECODE(NW31.NO,26,DECODE(NW31.ISSPNO,1,2,1),0)) NO26,
                  SUM(DECODE(NW31.NO,27,DECODE(NW31.ISSPNO,1,2,1),0)) NO27, SUM(DECODE(NW31.NO,28,DECODE(NW31.ISSPNO,1,2,1),0)) NO28,
                  SUM(DECODE(NW31.NO,29,DECODE(NW31.ISSPNO,1,2,1),0)) NO29, SUM(DECODE(NW31.NO,30,DECODE(NW31.ISSPNO,1,2,1),0)) NO30,
                  SUM(DECODE(NW31.NO,31,DECODE(NW31.ISSPNO,1,2,1),0)) NO31, SUM(DECODE(NW31.NO,32,DECODE(NW31.ISSPNO,1,2,1),0)) NO32,
                  SUM(DECODE(NW31.NO,33,DECODE(NW31.ISSPNO,1,2,1),0)) NO33, SUM(DECODE(NW31.NO,34,DECODE(NW31.ISSPNO,1,2,1),0)) NO34,
                  SUM(DECODE(NW31.NO,35,DECODE(NW31.ISSPNO,1,2,1),0)) NO35, SUM(DECODE(NW31.NO,36,DECODE(NW31.ISSPNO,1,2,1),0)) NO36,
                  SUM(DECODE(NW31.NO,37,DECODE(NW31.ISSPNO,1,2,1),0)) NO37, SUM(DECODE(NW31.NO,38,DECODE(NW31.ISSPNO,1,2,1),0)) NO38,
                  SUM(DECODE(NW31.NO,39,DECODE(NW31.ISSPNO,1,2,1),0)) NO39, SUM(DECODE(NW31.NO,40,DECODE(NW31.ISSPNO,1,2,1),0)) NO40,
                  SUM(DECODE(NW31.NO,41,DECODE(NW31.ISSPNO,1,2,1),0)) NO41, SUM(DECODE(NW31.NO,42,DECODE(NW31.ISSPNO,1,2,1),0)) NO42,
                  SUM(DECODE(NW31.NO,43,DECODE(NW31.ISSPNO,1,2,1),0)) NO43, SUM(DECODE(NW31.NO,44,DECODE(NW31.ISSPNO,1,2,1),0)) NO44,
                  SUM(DECODE(NW31.NO,45,DECODE(NW31.ISSPNO,1,2,1),0)) NO45, SUM(DECODE(NW31.NO,46,DECODE(NW31.ISSPNO,1,2,1),0)) NO46,
                  SUM(DECODE(NW31.NO,47,DECODE(NW31.ISSPNO,1,2,1),0)) NO47, SUM(DECODE(NW31.NO,48,DECODE(NW31.ISSPNO,1,2,1),0)) NO48,
                  SUM(DECODE(NW31.NO,49,DECODE(NW31.ISSPNO,1,2,1),0)) NO49
                  FROM NW300 NW3
                  LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                  WHERE 1=1
                  AND NW3.TYPE = '05'
                  GROUP BY TRUNC(NW3.OPENDT), PERIODS
                  ) X
                  WHERE ROWNUM <= 20
                  ORDER BY X.PERIODS DESC
                  """
        def result1 = s.rows(sql)

        def sql2 = """
                  select
                  sum(x.NO01) NO01, sum(x.NO02) NO02, sum(x.NO03) NO03, sum(x.NO04) NO04,
                  sum(x.NO05) NO05, sum(x.NO06) NO06, sum(x.NO07) NO07, sum(x.NO08) NO08,
                  sum(x.NO09) NO09, sum(x.NO10) NO10, sum(x.NO11) NO11, sum(x.NO12) NO12,
                  sum(x.NO13) NO13, sum(x.NO14) NO14, sum(x.NO15) NO15, sum(x.NO16) NO16,
                  sum(x.NO17) NO17, sum(x.NO18) NO18, sum(x.NO19) NO19, sum(x.NO20) NO20,
                  sum(x.NO21) NO21, sum(x.NO22) NO22, sum(x.NO23) NO23, sum(x.NO24) NO24,
                  sum(x.NO25) NO25, sum(x.NO26) NO26, sum(x.NO27) NO27, sum(x.NO28) NO28,
                  sum(x.NO29) NO29, sum(x.NO30) NO30, sum(x.NO31) NO31, sum(x.NO32) NO32,
                  sum(x.NO33) NO33, sum(x.NO34) NO34, sum(x.NO35) NO35, sum(x.NO36) NO36,
                  sum(x.NO37) NO37, sum(x.NO38) NO38, sum(x.NO39) NO39, sum(x.NO40) NO40,
                  sum(x.NO41) NO41, sum(x.NO42) NO42, sum(x.NO43) NO43, sum(x.NO44) NO44,
                  sum(x.NO45) NO45, sum(x.NO46) NO46, sum(x.NO47) NO47, sum(x.NO48) NO48,
                  sum(x.NO49) NO49
                  from
                  (
                  SELECT
                  SUM(DECODE(NW31.NO,1,1,0)) NO01, SUM(DECODE(NW31.NO,2,1,0)) NO02, SUM(DECODE(NW31.NO,3,1,0)) NO03,
                  SUM(DECODE(NW31.NO,4,1,0)) NO04, SUM(DECODE(NW31.NO,5,1,0)) NO05, SUM(DECODE(NW31.NO,6,1,0)) NO06,
                  SUM(DECODE(NW31.NO,7,1,0)) NO07, SUM(DECODE(NW31.NO,8,1,0)) NO08, SUM(DECODE(NW31.NO,9,1,0)) NO09,
                  SUM(DECODE(NW31.NO,10,1,0)) NO10, SUM(DECODE(NW31.NO,11,1,0)) NO11, SUM(DECODE(NW31.NO,12,1,0)) NO12,
                  SUM(DECODE(NW31.NO,13,1,0)) NO13, SUM(DECODE(NW31.NO,14,1,0)) NO14, SUM(DECODE(NW31.NO,15,1,0)) NO15,
                  SUM(DECODE(NW31.NO,16,1,0)) NO16, SUM(DECODE(NW31.NO,17,1,0)) NO17, SUM(DECODE(NW31.NO,18,1,0)) NO18,
                  SUM(DECODE(NW31.NO,19,1,0)) NO19, SUM(DECODE(NW31.NO,20,1,0)) NO20, SUM(DECODE(NW31.NO,21,1,0)) NO21,
                  SUM(DECODE(NW31.NO,22,1,0)) NO22, SUM(DECODE(NW31.NO,23,1,0)) NO23, SUM(DECODE(NW31.NO,24,1,0)) NO24,
                  SUM(DECODE(NW31.NO,25,1,0)) NO25, SUM(DECODE(NW31.NO,26,1,0)) NO26, SUM(DECODE(NW31.NO,27,1,0)) NO27,
                  SUM(DECODE(NW31.NO,28,1,0)) NO28, SUM(DECODE(NW31.NO,29,1,0)) NO29, SUM(DECODE(NW31.NO,30,1,0)) NO30,
                  SUM(DECODE(NW31.NO,31,1,0)) NO31, SUM(DECODE(NW31.NO,32,1,0)) NO32, SUM(DECODE(NW31.NO,33,1,0)) NO33,
                  SUM(DECODE(NW31.NO,34,1,0)) NO34, SUM(DECODE(NW31.NO,35,1,0)) NO35, SUM(DECODE(NW31.NO,36,1,0)) NO36,
                  SUM(DECODE(NW31.NO,37,1,0)) NO37, SUM(DECODE(NW31.NO,38,1,0)) NO38, SUM(DECODE(NW31.NO,39,1,0)) NO39,
                  SUM(DECODE(NW31.NO,40,1,0)) NO40, SUM(DECODE(NW31.NO,41,1,0)) NO41, SUM(DECODE(NW31.NO,42,1,0)) NO42,
                  SUM(DECODE(NW31.NO,43,1,0)) NO43, SUM(DECODE(NW31.NO,44,1,0)) NO44, SUM(DECODE(NW31.NO,45,1,0)) NO45,
                  SUM(DECODE(NW31.NO,46,1,0)) NO46, SUM(DECODE(NW31.NO,47,1,0)) NO47, SUM(DECODE(NW31.NO,48,1,0)) NO48,
                  SUM(DECODE(NW31.NO,49,1,0)) NO49
                  FROM NW300 NW3
                  LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                  WHERE 1=1
                  AND NW3.TYPE = '05'
                  GROUP BY TRUNC(NW3.OPENDT), PERIODS
                  ) x
                  where rownum <= 20
                  """
        def result2 = s.rows(sql2)
        def list1 = []
        def maxNum = 0

        if (result2 != null) {
            result2[0].eachWithIndex {
                node, index ->
                    list1 << node.value
            }
            maxNum = (list1.max())?.toInteger()
        }

        def sql3 = """
                   SELECT
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 1 THEN NW3.PERIODS END)) NO01, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 2 THEN NW3.PERIODS END)) NO02,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 3 THEN NW3.PERIODS END)) NO03, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 4 THEN NW3.PERIODS END)) NO04,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 5 THEN NW3.PERIODS END)) NO05, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 6 THEN NW3.PERIODS END)) NO06,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 7 THEN NW3.PERIODS END)) NO07, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 8 THEN NW3.PERIODS END)) NO08,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 9 THEN NW3.PERIODS END)) NO09, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 10 THEN NW3.PERIODS END)) NO10,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 11 THEN NW3.PERIODS END)) NO11, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 12 THEN NW3.PERIODS END)) NO12,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 13 THEN NW3.PERIODS END)) NO13, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 14 THEN NW3.PERIODS END)) NO14,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 15 THEN NW3.PERIODS END)) NO15, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 16 THEN NW3.PERIODS END)) NO16,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 17 THEN NW3.PERIODS END)) NO17, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 18 THEN NW3.PERIODS END)) NO18,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 19 THEN NW3.PERIODS END)) NO19, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 20 THEN NW3.PERIODS END)) NO20,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 21 THEN NW3.PERIODS END)) NO21, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 22 THEN NW3.PERIODS END)) NO22,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 23 THEN NW3.PERIODS END)) NO23, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 24 THEN NW3.PERIODS END)) NO24,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 25 THEN NW3.PERIODS END)) NO25, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 26 THEN NW3.PERIODS END)) NO26,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 27 THEN NW3.PERIODS END)) NO27, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 28 THEN NW3.PERIODS END)) NO28,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 29 THEN NW3.PERIODS END)) NO29, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 30 THEN NW3.PERIODS END)) NO30,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 31 THEN NW3.PERIODS END)) NO31, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 32 THEN NW3.PERIODS END)) NO32,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 33 THEN NW3.PERIODS END)) NO33, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 34 THEN NW3.PERIODS END)) NO34,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 35 THEN NW3.PERIODS END)) NO35, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 36 THEN NW3.PERIODS END)) NO36,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 37 THEN NW3.PERIODS END)) NO37, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 38 THEN NW3.PERIODS END)) NO38,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 39 THEN NW3.PERIODS END)) NO39, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 40 THEN NW3.PERIODS END)) NO40,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 41 THEN NW3.PERIODS END)) NO41, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 42 THEN NW3.PERIODS END)) NO42,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 43 THEN NW3.PERIODS END)) NO43, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 44 THEN NW3.PERIODS END)) NO44,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 45 THEN NW3.PERIODS END)) NO45, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 46 THEN NW3.PERIODS END)) NO46,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 47 THEN NW3.PERIODS END)) NO47, MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 48 THEN NW3.PERIODS END)) NO48,
                   MAX(NWMAX.PER) - MAX((CASE WHEN NW31.NO = 49 THEN NW3.PERIODS END)) NO49
                   FROM NW300 NW3
                   LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                   LEFT JOIN (
                      SELECT
                      MAX(NW32.PERIODS) PER
                      FROM NW300 NW32
                      WHERE 1=1
                      and nw32.TYPE = '05'
                      and nw32.opendt between to_date('20140101','yyyymmdd') and to_date('20141202','yyyymmdd')
                   ) NWMAX ON 1=1
                   WHERE 1=1
                   AND NW3.TYPE = '05'
                   and nw3.opendt between to_date('20140101','yyyymmdd') and to_date('20141202','yyyymmdd')
                   """

        def result3 = s.rows(sql3)
        def list2 = []
        def everNum = 0

        if (result3 != null) {
            result3[0].eachWithIndex {
                node, index ->
                    list2 << node.value
            }
            everNum = (list2.max())?.toInteger()
        }

        render(template: '/lotto/BK/＿ShowBigLuckToa', model: [nw300InstanceList: result1, nw300CountInstance: result2, maxNum: maxNum, nw300EverInstance: result3, everNum: everNum])
    }



    def showLastNumberAnalysis () {

        println '===showLastNumberAnalysis==='

        def showpage = params?.showpage?:20 //近幾期
        def sdt = params?.sdt //開始日期
        def edt = params?.edt //結束日期
        def speriods = params?.speriods //開始期數
        def eperiods = params?.eperiods //結束期數
        def s = new Sql(dataSource)

        def sql = """
                  SELECT * FROM (
                  SELECT
                  NW3.PERIODS,
                  TRUNC(NW3.OPENDT) OPENDT,
                  SUM(DECODE(NW31.NO,1,1,0)) NO01, SUM(DECODE(NW31.NO,2,1,0)) NO02,
                  SUM(DECODE(NW31.NO,3,1,0)) NO03, SUM(DECODE(NW31.NO,4,1,0)) NO04,
                  SUM(DECODE(NW31.NO,5,1,0)) NO05, SUM(DECODE(NW31.NO,6,1,0)) NO06,
                  SUM(DECODE(NW31.NO,7,1,0)) NO07, SUM(DECODE(NW31.NO,8,1,0)) NO08,
                  SUM(DECODE(NW31.NO,9,1,0)) NO09, SUM(DECODE(NW31.NO,10,1,0)) NO10,
                  SUM(DECODE(NW31.NO,11,1,0)) NO11, SUM(DECODE(NW31.NO,12,1,0)) NO12,
                  SUM(DECODE(NW31.NO,13,1,0)) NO13, SUM(DECODE(NW31.NO,14,1,0)) NO14,
                  SUM(DECODE(NW31.NO,15,1,0)) NO15, SUM(DECODE(NW31.NO,16,1,0)) NO16,
                  SUM(DECODE(NW31.NO,17,1,0)) NO17, SUM(DECODE(NW31.NO,18,1,0)) NO18,
                  SUM(DECODE(NW31.NO,19,1,0)) NO19, SUM(DECODE(NW31.NO,20,1,0)) NO20,
                  SUM(DECODE(NW31.NO,21,1,0)) NO21, SUM(DECODE(NW31.NO,22,1,0)) NO22,
                  SUM(DECODE(NW31.NO,23,1,0)) NO23, SUM(DECODE(NW31.NO,24,1,0)) NO24,
                  SUM(DECODE(NW31.NO,25,1,0)) NO25, SUM(DECODE(NW31.NO,26,1,0)) NO26,
                  SUM(DECODE(NW31.NO,27,1,0)) NO27, SUM(DECODE(NW31.NO,28,1,0)) NO28,
                  SUM(DECODE(NW31.NO,29,1,0)) NO29, SUM(DECODE(NW31.NO,30,1,0)) NO30,
                  SUM(DECODE(NW31.NO,31,1,0)) NO31, SUM(DECODE(NW31.NO,32,1,0)) NO32,
                  SUM(DECODE(NW31.NO,33,1,0)) NO33, SUM(DECODE(NW31.NO,34,1,0)) NO34,
                  SUM(DECODE(NW31.NO,35,1,0)) NO35, SUM(DECODE(NW31.NO,36,1,0)) NO36,
                  SUM(DECODE(NW31.NO,37,1,0)) NO37, SUM(DECODE(NW31.NO,38,1,0)) NO38,
                  SUM(DECODE(NW31.NO,39,1,0)) NO39, SUM(DECODE(NW31.NO,40,1,0)) NO40,
                  SUM(DECODE(NW31.NO,41,1,0)) NO41, SUM(DECODE(NW31.NO,42,1,0)) NO42,
                  SUM(DECODE(NW31.NO,43,1,0)) NO43, SUM(DECODE(NW31.NO,44,1,0)) NO44,
                  SUM(DECODE(NW31.NO,45,1,0)) NO45, SUM(DECODE(NW31.NO,46,1,0)) NO46,
                  SUM(DECODE(NW31.NO,47,1,0)) NO47, SUM(DECODE(NW31.NO,48,1,0)) NO48,
                  SUM(DECODE(NW31.NO,49,1,0)) NO49
                  FROM NW300 NW3
                  LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                  WHERE 1=1
                  AND NW3.TYPE = '05'
                  AND NW31.ISSPNO = 0
                  GROUP BY TRUNC(NW3.OPENDT), PERIODS
                  ) X
                  WHERE ROWNUM <= 20
                  """
        def result1 = s.rows(sql)

        def sql2 = """
                  select
                  sum(x.NO01) NO01, sum(x.NO02) NO02, sum(x.NO03) NO03, sum(x.NO04) NO04,
                  sum(x.NO05) NO05, sum(x.NO06) NO06, sum(x.NO07) NO07, sum(x.NO08) NO08,
                  sum(x.NO09) NO09, sum(x.NO10) NO10, sum(x.NO11) NO11, sum(x.NO12) NO12,
                  sum(x.NO13) NO13, sum(x.NO14) NO14, sum(x.NO15) NO15, sum(x.NO16) NO16,
                  sum(x.NO17) NO17, sum(x.NO18) NO18, sum(x.NO19) NO19, sum(x.NO20) NO20,
                  sum(x.NO21) NO21, sum(x.NO22) NO22, sum(x.NO23) NO23, sum(x.NO24) NO24,
                  sum(x.NO25) NO25, sum(x.NO26) NO26, sum(x.NO27) NO27, sum(x.NO28) NO28,
                  sum(x.NO29) NO29, sum(x.NO30) NO30, sum(x.NO31) NO31, sum(x.NO32) NO32,
                  sum(x.NO33) NO33, sum(x.NO34) NO34, sum(x.NO35) NO35, sum(x.NO36) NO36,
                  sum(x.NO37) NO37, sum(x.NO38) NO38, sum(x.NO39) NO39, sum(x.NO40) NO40,
                  sum(x.NO41) NO41, sum(x.NO42) NO42, sum(x.NO43) NO43, sum(x.NO44) NO44,
                  sum(x.NO45) NO45, sum(x.NO46) NO46, sum(x.NO47) NO47, sum(x.NO48) NO48,
                  sum(x.NO49) NO49
                  from
                  (
                  SELECT
                  SUM(DECODE(NW31.NO,1,1,0)) NO01, SUM(DECODE(NW31.NO,2,1,0)) NO02, SUM(DECODE(NW31.NO,3,1,0)) NO03,
                  SUM(DECODE(NW31.NO,4,1,0)) NO04, SUM(DECODE(NW31.NO,5,1,0)) NO05, SUM(DECODE(NW31.NO,6,1,0)) NO06,
                  SUM(DECODE(NW31.NO,7,1,0)) NO07, SUM(DECODE(NW31.NO,8,1,0)) NO08, SUM(DECODE(NW31.NO,9,1,0)) NO09,
                  SUM(DECODE(NW31.NO,10,1,0)) NO10, SUM(DECODE(NW31.NO,11,1,0)) NO11, SUM(DECODE(NW31.NO,12,1,0)) NO12,
                  SUM(DECODE(NW31.NO,13,1,0)) NO13, SUM(DECODE(NW31.NO,14,1,0)) NO14, SUM(DECODE(NW31.NO,15,1,0)) NO15,
                  SUM(DECODE(NW31.NO,16,1,0)) NO16, SUM(DECODE(NW31.NO,17,1,0)) NO17, SUM(DECODE(NW31.NO,18,1,0)) NO18,
                  SUM(DECODE(NW31.NO,19,1,0)) NO19, SUM(DECODE(NW31.NO,20,1,0)) NO20, SUM(DECODE(NW31.NO,21,1,0)) NO21,
                  SUM(DECODE(NW31.NO,22,1,0)) NO22, SUM(DECODE(NW31.NO,23,1,0)) NO23, SUM(DECODE(NW31.NO,24,1,0)) NO24,
                  SUM(DECODE(NW31.NO,25,1,0)) NO25, SUM(DECODE(NW31.NO,26,1,0)) NO26, SUM(DECODE(NW31.NO,27,1,0)) NO27,
                  SUM(DECODE(NW31.NO,28,1,0)) NO28, SUM(DECODE(NW31.NO,29,1,0)) NO29, SUM(DECODE(NW31.NO,30,1,0)) NO30,
                  SUM(DECODE(NW31.NO,31,1,0)) NO31, SUM(DECODE(NW31.NO,32,1,0)) NO32, SUM(DECODE(NW31.NO,33,1,0)) NO33,
                  SUM(DECODE(NW31.NO,34,1,0)) NO34, SUM(DECODE(NW31.NO,35,1,0)) NO35, SUM(DECODE(NW31.NO,36,1,0)) NO36,
                  SUM(DECODE(NW31.NO,37,1,0)) NO37, SUM(DECODE(NW31.NO,38,1,0)) NO38, SUM(DECODE(NW31.NO,39,1,0)) NO39,
                  SUM(DECODE(NW31.NO,40,1,0)) NO40, SUM(DECODE(NW31.NO,41,1,0)) NO41, SUM(DECODE(NW31.NO,42,1,0)) NO42,
                  SUM(DECODE(NW31.NO,43,1,0)) NO43, SUM(DECODE(NW31.NO,44,1,0)) NO44, SUM(DECODE(NW31.NO,45,1,0)) NO45,
                  SUM(DECODE(NW31.NO,46,1,0)) NO46, SUM(DECODE(NW31.NO,47,1,0)) NO47, SUM(DECODE(NW31.NO,48,1,0)) NO48,
                  SUM(DECODE(NW31.NO,49,1,0)) NO49
                  FROM NW300 NW3
                  LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                  WHERE 1=1
                  AND NW3.TYPE = '05'
                  AND NW31.ISSPNO = 0
                  GROUP BY TRUNC(NW3.OPENDT), PERIODS
                  ) x
                  where rownum <= 20
                  """
        def result2 = s.rows(sql2)
        def list1 = []
        def maxNum = 0

        if (result2 != null) {
            result2[0].eachWithIndex {
                node, index ->
                    list1 << node.value
            }
            maxNum = (list1.max())?.toInteger()
        }



        def sql3 = """
                   select
                  (sum(x.NO01)  + sum(x.NO11)  + sum(x.NO21)  + sum(x.NO31) + sum(x.NO41)) L1 ,
                  (sum(x.NO02)  + sum(x.NO12)  + sum(x.NO22)  + sum(x.NO32) + sum(x.NO42)) L2 ,
                  (sum(x.NO03)  + sum(x.NO13)  + sum(x.NO23)  + sum(x.NO33) + sum(x.NO43)) L3 ,
                  (sum(x.NO04)  + sum(x.NO14)  + sum(x.NO24)  + sum(x.NO34) + sum(x.NO44)) L4 ,
                  (sum(x.NO05)  + sum(x.NO15)  + sum(x.NO25)  + sum(x.NO35) + sum(x.NO45)) L5 ,
                  (sum(x.NO06)  + sum(x.NO16)  + sum(x.NO26)  + sum(x.NO36) + sum(x.NO46)) L6 ,
                  (sum(x.NO07)  + sum(x.NO17)  + sum(x.NO27)  + sum(x.NO37) + sum(x.NO47)) L7 ,
                  (sum(x.NO08)  + sum(x.NO18)  + sum(x.NO28)  + sum(x.NO38) + sum(x.NO48)) L8 ,
                  (sum(x.NO09)  + sum(x.NO19)  + sum(x.NO29)  + sum(x.NO39) + sum(x.NO49)) L9 ,
                  (sum(x.NO10)  + sum(x.NO20)  + sum(x.NO30)  + sum(x.NO40)) L0
                  from
                  (
                  SELECT
                  SUM(DECODE(NW31.NO,1,1,0)) NO01, SUM(DECODE(NW31.NO,2,1,0)) NO02, SUM(DECODE(NW31.NO,3,1,0)) NO03,
                  SUM(DECODE(NW31.NO,4,1,0)) NO04, SUM(DECODE(NW31.NO,5,1,0)) NO05, SUM(DECODE(NW31.NO,6,1,0)) NO06,
                  SUM(DECODE(NW31.NO,7,1,0)) NO07, SUM(DECODE(NW31.NO,8,1,0)) NO08, SUM(DECODE(NW31.NO,9,1,0)) NO09,
                  SUM(DECODE(NW31.NO,10,1,0)) NO10, SUM(DECODE(NW31.NO,11,1,0)) NO11, SUM(DECODE(NW31.NO,12,1,0)) NO12,
                  SUM(DECODE(NW31.NO,13,1,0)) NO13, SUM(DECODE(NW31.NO,14,1,0)) NO14, SUM(DECODE(NW31.NO,15,1,0)) NO15,
                  SUM(DECODE(NW31.NO,16,1,0)) NO16, SUM(DECODE(NW31.NO,17,1,0)) NO17, SUM(DECODE(NW31.NO,18,1,0)) NO18,
                  SUM(DECODE(NW31.NO,19,1,0)) NO19, SUM(DECODE(NW31.NO,20,1,0)) NO20, SUM(DECODE(NW31.NO,21,1,0)) NO21,
                  SUM(DECODE(NW31.NO,22,1,0)) NO22, SUM(DECODE(NW31.NO,23,1,0)) NO23, SUM(DECODE(NW31.NO,24,1,0)) NO24,
                  SUM(DECODE(NW31.NO,25,1,0)) NO25, SUM(DECODE(NW31.NO,26,1,0)) NO26, SUM(DECODE(NW31.NO,27,1,0)) NO27,
                  SUM(DECODE(NW31.NO,28,1,0)) NO28, SUM(DECODE(NW31.NO,29,1,0)) NO29, SUM(DECODE(NW31.NO,30,1,0)) NO30,
                  SUM(DECODE(NW31.NO,31,1,0)) NO31, SUM(DECODE(NW31.NO,32,1,0)) NO32, SUM(DECODE(NW31.NO,33,1,0)) NO33,
                  SUM(DECODE(NW31.NO,34,1,0)) NO34, SUM(DECODE(NW31.NO,35,1,0)) NO35, SUM(DECODE(NW31.NO,36,1,0)) NO36,
                  SUM(DECODE(NW31.NO,37,1,0)) NO37, SUM(DECODE(NW31.NO,38,1,0)) NO38, SUM(DECODE(NW31.NO,39,1,0)) NO39,
                  SUM(DECODE(NW31.NO,40,1,0)) NO40, SUM(DECODE(NW31.NO,41,1,0)) NO41, SUM(DECODE(NW31.NO,42,1,0)) NO42,
                  SUM(DECODE(NW31.NO,43,1,0)) NO43, SUM(DECODE(NW31.NO,44,1,0)) NO44, SUM(DECODE(NW31.NO,45,1,0)) NO45,
                  SUM(DECODE(NW31.NO,46,1,0)) NO46, SUM(DECODE(NW31.NO,47,1,0)) NO47, SUM(DECODE(NW31.NO,48,1,0)) NO48,
                  SUM(DECODE(NW31.NO,49,1,0)) NO49
                  FROM NW300 NW3
                  LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                  WHERE 1=1
                  AND NW3.TYPE = '05'
                  AND NW31.ISSPNO = 0
                  GROUP BY TRUNC(NW3.OPENDT), PERIODS
                  ) x
                  where rownum <= 20
                   """

        def result3 = s.rows(sql3)
        def list2 = []
        def lastNum = 0

        if (result3 != null) {
            result3[0].eachWithIndex {
                node, index ->
                    list2 << node.value
            }
            lastNum = (list2.max())?.toInteger()
        }

        render(template: '/lotto/BK/lastNumberAnalysis', model: [nw300InstanceList: result1, nw300CountInstance: result2, maxNum: maxNum, nw300LastInstance: result3, lastNum: lastNum])
    }



    def showBingoAnalysis () {

        println '===showBingoAnalysis==='

        def showpage = params?.showpage?:20 //近幾期
        def sdt = params?.sdt //開始日期
        def edt = params?.edt //結束日期
        def speriods = params?.speriods //開始期數
        def eperiods = params?.eperiods //結束期數
        def s = new Sql(dataSource)

        def sql = """
                  SELECT x.*,
                  (X.NO01+X.NO02+X.NO03+X.NO04+X.NO05+X.NO06+X.NO07+X.NO08+X.NO09+X.NO10) tr10,
                  (X.NO11+X.NO12+X.NO13+X.NO14+X.NO15+X.NO16+X.NO17+X.NO18+X.NO19+X.NO20) tr20,
                  (X.NO21+X.NO22+X.NO23+X.NO24+X.NO25+X.NO26+X.NO27+X.NO28+X.NO29+X.NO30) tr30,
                  (X.NO31+X.NO32+X.NO33+X.NO34+X.NO35+X.NO36+X.NO37+X.NO38+X.NO39+X.NO40) tr40,
                  (X.NO41+X.NO42+X.NO43+X.NO44+X.NO45+X.NO46+X.NO47+X.NO48+X.NO49+X.NO50) tr50,
                  (X.NO51+X.NO52+X.NO53+X.NO54+X.NO55+X.NO56+X.NO57+X.NO58+X.NO59+X.NO60) tr60,
                  (X.NO61+X.NO62+X.NO63+X.NO64+X.NO65+X.NO66+X.NO67+X.NO68+X.NO69+X.NO70) tr70,
                  (X.NO71+X.NO72+X.NO73+X.NO74+X.NO75+X.NO76+X.NO77+X.NO78+X.NO79+X.NO80) tr80,
                  (X.NO01+X.NO11+X.NO21+X.NO31+X.NO41+X.NO51+X.NO61+X.NO71) tdy1,
                  (X.NO02+X.NO12+X.NO22+X.NO32+X.NO42+X.NO52+X.NO62+X.NO72) tdy2,
                  (X.NO03+X.NO13+X.NO23+X.NO33+X.NO43+X.NO53+X.NO63+X.NO73) tdy3,
                  (X.NO04+X.NO14+X.NO24+X.NO34+X.NO44+X.NO54+X.NO64+X.NO74) tdy4,
                  (X.NO05+X.NO15+X.NO25+X.NO35+X.NO45+X.NO55+X.NO65+X.NO75) tdy5,
                  (X.NO06+X.NO16+X.NO26+X.NO36+X.NO46+X.NO56+X.NO66+X.NO76) tdy6,
                  (X.NO07+X.NO17+X.NO27+X.NO37+X.NO47+X.NO57+X.NO67+X.NO77) tdy7,
                  (X.NO08+X.NO18+X.NO28+X.NO38+X.NO48+X.NO58+X.NO68+X.NO78) tdy8,
                  (X.NO09+X.NO19+X.NO29+X.NO39+X.NO49+X.NO59+X.NO69+X.NO79) tdy9,
                  (X.NO10+X.NO20+X.NO30+X.NO40+X.NO50+X.NO60+X.NO70+X.NO80) tdy0
                  FROM (
                  SELECT
                  NW3.PERIODS,
                  TRUNC(NW3.OPENDT) OPENDT,
                  SUM(DECODE(NW31.NO,1,1,0)) NO01, SUM(DECODE(NW31.NO,2,1,0)) NO02,
                  SUM(DECODE(NW31.NO,3,1,0)) NO03, SUM(DECODE(NW31.NO,4,1,0)) NO04,
                  SUM(DECODE(NW31.NO,5,1,0)) NO05, SUM(DECODE(NW31.NO,6,1,0)) NO06,
                  SUM(DECODE(NW31.NO,7,1,0)) NO07, SUM(DECODE(NW31.NO,8,1,0)) NO08,
                  SUM(DECODE(NW31.NO,9,1,0)) NO09, SUM(DECODE(NW31.NO,10,1,0)) NO10,
                  SUM(DECODE(NW31.NO,11,1,0)) NO11, SUM(DECODE(NW31.NO,12,1,0)) NO12,
                  SUM(DECODE(NW31.NO,13,1,0)) NO13, SUM(DECODE(NW31.NO,14,1,0)) NO14,
                  SUM(DECODE(NW31.NO,15,1,0)) NO15, SUM(DECODE(NW31.NO,16,1,0)) NO16,
                  SUM(DECODE(NW31.NO,17,1,0)) NO17, SUM(DECODE(NW31.NO,18,1,0)) NO18,
                  SUM(DECODE(NW31.NO,19,1,0)) NO19, SUM(DECODE(NW31.NO,20,1,0)) NO20,
                  SUM(DECODE(NW31.NO,21,1,0)) NO21, SUM(DECODE(NW31.NO,22,1,0)) NO22,
                  SUM(DECODE(NW31.NO,23,1,0)) NO23, SUM(DECODE(NW31.NO,24,1,0)) NO24,
                  SUM(DECODE(NW31.NO,25,1,0)) NO25, SUM(DECODE(NW31.NO,26,1,0)) NO26,
                  SUM(DECODE(NW31.NO,27,1,0)) NO27, SUM(DECODE(NW31.NO,28,1,0)) NO28,
                  SUM(DECODE(NW31.NO,29,1,0)) NO29, SUM(DECODE(NW31.NO,30,1,0)) NO30,
                  SUM(DECODE(NW31.NO,31,1,0)) NO31, SUM(DECODE(NW31.NO,32,1,0)) NO32,
                  SUM(DECODE(NW31.NO,33,1,0)) NO33, SUM(DECODE(NW31.NO,34,1,0)) NO34,
                  SUM(DECODE(NW31.NO,35,1,0)) NO35, SUM(DECODE(NW31.NO,36,1,0)) NO36,
                  SUM(DECODE(NW31.NO,37,1,0)) NO37, SUM(DECODE(NW31.NO,38,1,0)) NO38,
                  SUM(DECODE(NW31.NO,39,1,0)) NO39, SUM(DECODE(NW31.NO,40,1,0)) NO40,
                  SUM(DECODE(NW31.NO,41,1,0)) NO41, SUM(DECODE(NW31.NO,42,1,0)) NO42,
                  SUM(DECODE(NW31.NO,43,1,0)) NO43, SUM(DECODE(NW31.NO,44,1,0)) NO44,
                  SUM(DECODE(NW31.NO,45,1,0)) NO45, SUM(DECODE(NW31.NO,46,1,0)) NO46,
                  SUM(DECODE(NW31.NO,47,1,0)) NO47, SUM(DECODE(NW31.NO,48,1,0)) NO48,
                  SUM(DECODE(NW31.NO,49,1,0)) NO49, SUM(DECODE(NW31.NO,50,1,0)) NO50,
                  SUM(DECODE(NW31.NO,51,1,0)) NO51, SUM(DECODE(NW31.NO,52,1,0)) NO52,
                  SUM(DECODE(NW31.NO,53,1,0)) NO53, SUM(DECODE(NW31.NO,54,1,0)) NO54,
                  SUM(DECODE(NW31.NO,55,1,0)) NO55, SUM(DECODE(NW31.NO,56,1,0)) NO56,
                  SUM(DECODE(NW31.NO,57,1,0)) NO57, SUM(DECODE(NW31.NO,58,1,0)) NO58,
                  SUM(DECODE(NW31.NO,59,1,0)) NO59, SUM(DECODE(NW31.NO,60,1,0)) NO60,
                  SUM(DECODE(NW31.NO,61,1,0)) NO61, SUM(DECODE(NW31.NO,62,1,0)) NO62,
                  SUM(DECODE(NW31.NO,63,1,0)) NO63, SUM(DECODE(NW31.NO,64,1,0)) NO64,
                  SUM(DECODE(NW31.NO,65,1,0)) NO65, SUM(DECODE(NW31.NO,66,1,0)) NO66,
                  SUM(DECODE(NW31.NO,67,1,0)) NO67, SUM(DECODE(NW31.NO,68,1,0)) NO68,
                  SUM(DECODE(NW31.NO,69,1,0)) NO69, SUM(DECODE(NW31.NO,70,1,0)) NO70,
                  SUM(DECODE(NW31.NO,71,1,0)) NO71, SUM(DECODE(NW31.NO,72,1,0)) NO72,
                  SUM(DECODE(NW31.NO,73,1,0)) NO73, SUM(DECODE(NW31.NO,74,1,0)) NO74,
                  SUM(DECODE(NW31.NO,75,1,0)) NO75, SUM(DECODE(NW31.NO,76,1,0)) NO76,
                  SUM(DECODE(NW31.NO,77,1,0)) NO77, SUM(DECODE(NW31.NO,78,1,0)) NO78,
                  SUM(DECODE(NW31.NO,79,1,0)) NO79, SUM(DECODE(NW31.NO,80,1,0)) NO80
                  FROM NW300 NW3
                  LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID
                  WHERE 1=1
                  AND NW3.TYPE = '11'
                  AND NW31.ISSPNO = 0
                  GROUP BY TRUNC(NW3.OPENDT), PERIODS
                  ORDER BY NW3.PERIODS DESC
                  ) X
                  WHERE ROWNUM <= 6
                  """
        def result1 = s.rows(sql)

        render(template: '/lotto/bingoDataAnalysis', model: [nw300InstanceList: result1])
    }


}
