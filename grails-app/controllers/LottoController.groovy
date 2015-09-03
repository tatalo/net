import groovy.sql.Sql

class LottoController {

    def dataSource
    def netWinService

    static void main(String[] args){
    }

    def index() {
        redirect action: "customNewOpen"
    }

    def customNewOpen() { //彩球最新開獎
        render view: "/lotto/formCustomNewOpen"
    }

    def customQueryHistoryMarkSix() { //六合彩查詢
        if (params.pYyyymm_year && params.pYyyymm_month) {
            params.pYyyymmS = params.pYyyymm_year + params.pYyyymm_month.padLeft(2, '0')
            params.pYyyymmE = params.pYyyymm_year + ((params.int('pYyyymm_month') ?: 0) + 1).toString().padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pYyyymmS", "pYyyymmE"])
        }

        params.pType = "01"
        def nw300I = netWinService.getNw300List(params)

        def vLink = g.createLink(controller: "lotto", action: "customQueryHistoryMarkSix", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
        render view: "/lotto/formCustomQueryHistory1", model: [nw300I: nw300I, totalCount: nw300I?.size(),
                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
    }

    def customQueryHistoryLotto740() { //大福彩查詢
        if (params.pYyyymm_year && params.pYyyymm_month) {
            params.pYyyymmS = params.pYyyymm_year + params.pYyyymm_month.padLeft(2, '0')
            params.pYyyymmE = params.pYyyymm_year + ((params.int('pYyyymm_month') ?: 0) + 1).toString().padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pYyyymmS", "pYyyymmE"])
        }

        params.pType = "02"
        def nw300I = netWinService.getNw300List(params)

        def vLink = g.createLink(controller: "lotto", action: "customQueryHistoryLotto740", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
        render view: "/lotto/formCustomQueryHistory1", model: [nw300I: nw300I, totalCount: nw300I?.size(),
                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
    }

    def customQueryHistorySuperLotto638() { //威力彩查詢
        if (params.pYyyymm_year && params.pYyyymm_month) {
            params.pYyyymmS = params.pYyyymm_year + params.pYyyymm_month.padLeft(2, '0')
            params.pYyyymmE = params.pYyyymm_year + ((params.int('pYyyymm_month') ?: 0) + 1).toString().padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pYyyymmS", "pYyyymmE"])
        }
        params.pType = "03"
        def nw300I = netWinService.getNw300List(params)

        def vLink = g.createLink(controller: "lotto", action: "customQueryHistorySuperLotto638", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
        render view: "/lotto/formCustomQueryHistory2", model: [nw300I: nw300I, totalCount: nw300I?.size(),
                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
    }

    def customQueryHistory38M6() { //38樂合彩查詢
        if (params.pYyyymm_year && params.pYyyymm_month) {
            params.pYyyymmS = params.pYyyymm_year + params.pYyyymm_month.padLeft(2, '0')
            params.pYyyymmE = params.pYyyymm_year + ((params.int('pYyyymm_month') ?: 0) + 1).toString().padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pYyyymmS", "pYyyymmE"])
        }

        params.pType = "04"
        def nw300I = netWinService.getNw300List(params)

        def vLink = g.createLink(controller: "lotto", action: "customQueryHistory38M6", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
        render view: "/lotto/formCustomQueryHistory1", model: [nw300I: nw300I, totalCount: nw300I?.size(),
                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
    }

    def customQueryHistoryLotto649() { //大樂透查詢
        if (params.pYyyymm_year && params.pYyyymm_month) {
            params.pYyyymmS = params.pYyyymm_year + params.pYyyymm_month.padLeft(2, '0')
            params.pYyyymmE = params.pYyyymm_year + ((params.int('pYyyymm_month') ?: 0) + 1).toString().padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pYyyymmS", "pYyyymmE"])
        }

        params.pType = "05"
        def nw300I = netWinService.getNw300List(params)

        def vLink = g.createLink(controller: "lotto", action: "customQueryHistoryLotto649", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
        render view: "/lotto/formCustomQueryHistory1", model: [nw300I: nw300I, totalCount: nw300I?.size(),
                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
    }

    def customQueryHistory49M6() { //49樂合彩查詢
        if (params.pYyyymm_year && params.pYyyymm_month) {
            params.pYyyymmS = params.pYyyymm_year + params.pYyyymm_month.padLeft(2, '0')
            params.pYyyymmE = params.pYyyymm_year + ((params.int('pYyyymm_month') ?: 0) + 1).toString().padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pYyyymmS", "pYyyymmE"])
        }
        params.pType = "06"
        def nw300I = netWinService.getNw300List(params)

        def vLink = g.createLink(controller: "lotto", action: "customQueryHistory49M6", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
        render view: "/lotto/formCustomQueryHistory1", model: [nw300I: nw300I, totalCount: nw300I?.size(),
                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
    }

    def customQueryHistoryLotto539() { //今彩539查詢
        if (params.pYyyymm_year && params.pYyyymm_month) {
            params.pYyyymmS = params.pYyyymm_year + params.pYyyymm_month.padLeft(2, '0')
            params.pYyyymmE = params.pYyyymm_year + ((params.int('pYyyymm_month') ?: 0) + 1).toString().padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pYyyymmS", "pYyyymmE"])
        }

        params.pType = "07"
        def nw300I = netWinService.getNw300List(params)

        def vLink = g.createLink(controller: "lotto", action: "customQueryHistoryLotto539", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
        render view: "/lotto/formCustomQueryHistory1", model: [nw300I: nw300I, totalCount: nw300I?.size(),
                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
    }

    def customQueryHistory39M5() { //39樂合彩查詢
        if (params.pYyyymm_year && params.pYyyymm_month) {
            params.pYyyymmS = params.pYyyymm_year + params.pYyyymm_month.padLeft(2, '0')
            params.pYyyymmE = params.pYyyymm_year + ((params.int('pYyyymm_month') ?: 0) + 1).toString().padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pYyyymmS", "pYyyymmE"])
        }

        params.pType = "08"
        def nw300I = netWinService.getNw300List(params)

        def vLink = g.createLink(controller: "lotto", action: "customQueryHistory39M5", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
        render view: "/lotto/formCustomQueryHistory1", model: [nw300I: nw300I, totalCount: nw300I?.size(),
                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
    }

    def customQueryHistory3D() { //3星彩查詢
        if (params.pYyyymm_year && params.pYyyymm_month) {
            params.pYyyymmS = params.pYyyymm_year + params.pYyyymm_month.padLeft(2, '0')
            params.pYyyymmE = params.pYyyymm_year + ((params.int('pYyyymm_month') ?: 0) + 1).toString().padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pYyyymmS", "pYyyymmE"])
        }

        params.pType = "09"
        def nw300I = netWinService.getNw300List(params)

        def vLink = g.createLink(controller: "lotto", action: "customQueryHistory3D", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
        render view: "/lotto/formCustomQueryHistory3", model: [nw300I: nw300I, totalCount: nw300I?.size(),
                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
    }

    def customQueryHistory4D() { //4星彩查詢
        if (params.pYyyymm_year && params.pYyyymm_month) {
            params.pYyyymmS = params.pYyyymm_year + params.pYyyymm_month.padLeft(2, '0')
            params.pYyyymmE = params.pYyyymm_year + ((params.int('pYyyymm_month') ?: 0) + 1).toString().padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pYyyymmS", "pYyyymmE"])
        }

        params.pType = "10"
        def nw300I = netWinService.getNw300List(params)

        def vLink = g.createLink(controller: "lotto", action: "customQueryHistory4D", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
        render view: "/lotto/formCustomQueryHistory3", model: [nw300I: nw300I, totalCount: nw300I?.size(),
                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
    }

    def customQueryHistoryBingoBingo() { //賓果
        if (params.pOpendt_year && params.pOpendt_month && params.pOpendt_day) {
            params.pOpendt = params.pOpendt_year + params.pOpendt_month.padLeft(2, '0') + params.pOpendt_day.padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pOpendt"])
        }

        params.pType = "11"
        def nw300I = netWinService.getNw300List(params)

        def vLink = g.createLink(controller: "lotto", action: "customQueryHistoryBingoBingo", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
        render view: "/lotto/formCustomQueryHistory4", model: [nw300I: nw300I, totalCount: nw300I?.size(),
                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
    }
    def contentMarkSix() { //六合彩介紹
        params.pType = "101"
        def nw400I = netWinService.getNw400List(params)
        render view: "/lotto/formContent1", model: [nw400I: nw400I, title: g.message(code: "lotto.tab03.subTab01.label"), lv1IDX: 3]
    }

    def customHistoryMarkSix() { //六合彩歷史數據分析
        params.pType = "01"

        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)
        def vLastOpenData = netWinService.getLastOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customHistoryMarkSix", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomHistory1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, showSpBtn: "1",
                                                              nw300I: vHistoryData.list,
                                                              nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                              nw300IL: vLastOpenData.list, nw300ILMax: vLastOpenData.maxNum,
                                                              pType: params.pType, title: g.message(code: "lotto.tab03.subTab02.label"), lv1IDX: 3, pLink : vLink]
    }

    def customContinueMarkSix() { //六合連續分析
        params.pType = "01"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getContinueAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customContinueMarkSix", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomContinue1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                          nw300I: vHistoryData.list,
                                                          nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                          pType: params.pType, title: g.message(code: "lotto.tab03.subTab04.label"), lv1IDX: 3, pLink : vLink]
    }

    def customRepeatMarkSix() { //六合彩連開分析
        params.pType = "01"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getRepeatAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customRepeatMarkSix", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomRepeat1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                          nw300I: vHistoryData.list,
                                                          nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                          pType: params.pType, title: g.message(code: "lotto.tab03.subTab03.label"), lv1IDX: 3, pLink : vLink]
    }

    def customLastNumberMarkSix() { //六合彩尾數分析
        params.pType = "01"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vLastNumberData = netWinService.getLastNumberAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customLastNumberMarkSix", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomLastNumber1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                          nw300I: vHistoryData.list,
                                                          nw300ILN: vLastNumberData.list, nw300ILNMax: vLastNumberData.maxNum, createColumn: vLastNumberData.createColumn,columnsCNTS: vLastNumberData.columnsCNTS,
                                                             pType: params.pType, title: g.message(code: "lotto.tab03.subTab05.label"), lv1IDX: 3, pLink : vLink]
    }


    def contentLotto740() { //大福彩介紹
        params.pType = "102"
        def nw400I = netWinService.getNw400List(params)
        render view: "/lotto/formContent1", model: [nw400I: nw400I, title: g.message(code: "lotto.tab04.subTab01.label"), lv1IDX: 4]
    }

    def customHistoryLotto740() { //大福彩歷史數據分析
        params.pType = "02"

        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)
        def vLastOpenData = netWinService.getLastOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customHistoryLotto740", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomHistory1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, showSpBtn: "0",
                                                          nw300I: vHistoryData.list,
                                                          nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                          nw300IL: vLastOpenData.list, nw300ILMax: vLastOpenData.maxNum,
                                                          pType: params.pType, title: g.message(code: "lotto.tab04.subTab02.label"), lv1IDX: 4, pLink : vLink]
    }

    def customContinueLotto740() { //大福彩連續分析
        params.pType = "02"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getContinueAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customContinueLotto740", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomContinue1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                           nw300I: vHistoryData.list,
                                                           nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                           pType: params.pType, title: g.message(code: "lotto.tab04.subTab04.label"), lv1IDX: 4, pLink : vLink]
    }

    def customRepeatLotto740() { //大福彩連開分析
        params.pType = "02"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getRepeatAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customRepeatLotto740", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomRepeat1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                         nw300I: vHistoryData.list,
                                                         nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                         pType: params.pType, title: g.message(code: "lotto.tab04.subTab03.label"), lv1IDX: 4, pLink : vLink]
    }

    def customLastNumberLotto740() { //大福彩尾數分析
        params.pType = "02"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vLastNumberData = netWinService.getLastNumberAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customLastNumberLotto740", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomLastNumber1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                             nw300I: vHistoryData.list,
                                                             nw300ILN: vLastNumberData.list, nw300ILNMax: vLastNumberData.maxNum, createColumn: vLastNumberData.createColumn,columnsCNTS: vLastNumberData.columnsCNTS,
                                                             pType: params.pType, title: g.message(code: "lotto.tab04.subTab05.label"), lv1IDX: 4, pLink : vLink]
    }


    def contentSuperLotto638() { //威力彩介紹
        params.pType = "103"
        def nw400I = netWinService.getNw400List(params)
        render view: "/lotto/formContent1", model: [nw400I: nw400I, title: g.message(code: "lotto.tab05.subTab01.label"), lv1IDX: 5]
    }

    def customHistorySuperLotto638() { //威力彩歷史數據分析
        params.pType = "03"

        def vHistoryData = netWinService.getHistoryAnyalysis2(params)
        def vCntsData = netWinService.getCntsOpenAnalysis2(params)
        def vLastOpenData = netWinService.getLastOpenAnalysis2(params)

        def vLink = g.createLink(controller: "lotto", action: "customHistorySuperLotto638", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomHistory2", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, columnsSPNOs: vHistoryData.columnsSPNOs, showSpBtn: "0",
                                                          nw300I: vHistoryData.list,
                                                          nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                          nw300IL: vLastOpenData.list, nw300ILMax: vLastOpenData.maxNum,
                                                          pType: params.pType, title: g.message(code: "lotto.tab05.subTab02.label"), lv1IDX: 5, pLink : vLink]
    }

    def customContinueSuperLotto638() { //威力彩連續分析
        params.pType = "03"
        def vHistoryData = netWinService.getContinueAnyalysis2(params)
        def vCntsData = netWinService.getCntsOpenAnalysis2(params)

        def vLink = g.createLink(controller: "lotto", action: "customContinueSuperLotto638", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomContinue2", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, columnsSPNOs: vHistoryData.columnsSPNOs,
                                                           nw300I: vHistoryData.list,
                                                           nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                           pType: params.pType, title: g.message(code: "lotto.tab05.subTab04.label"), lv1IDX: 5, pLink : vLink]
    }

    def customRepeatSuperLotto638() { //威力彩連開分析
        params.pType = "03"
        def vHistoryData = netWinService.getRepeatAnyalysis2(params)
        def vCntsData = netWinService.getCntsOpenAnalysis2(params)

        def vLink = g.createLink(controller: "lotto", action: "customRepeatSuperLotto638", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomRepeat2", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, columnsSPNOs: vHistoryData.columnsSPNOs,
                                                         nw300I: vHistoryData.list,
                                                         nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                         pType: params.pType, title: g.message(code: "lotto.tab05.subTab03.label"), lv1IDX: 5, pLink : vLink]
    }

    def customLastNumberSuperLotto638() { //威力彩尾數分析
        params.pType = "03"
        def vHistoryData = netWinService.getHistoryAnyalysis2(params)
        def vLastNumberData = netWinService.getLastNumberAnalysis2(params)

        def vLink = g.createLink(controller: "lotto", action: "customLastNumberSuperLotto638", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomLastNumber2", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, columnsSPNOs: vHistoryData.columnsSPNOs,
                                                             nw300I: vHistoryData.list,
                                                             nw300ILN: vLastNumberData.list, nw300ILNMax: vLastNumberData.maxNum, createColumn: vLastNumberData.createColumn,columnsCNTS: vLastNumberData.columnsCNTS,
                                                             pType: params.pType, title: g.message(code: "lotto.tab05.subTab05.label"), lv1IDX: 5, pLink : vLink]
    }

    def content38M6() { //38樂合彩介紹
        params.pType = "104"
        def nw400I = netWinService.getNw400List(params)
        render view: "/lotto/formContent1", model: [nw400I: nw400I, title: g.message(code: "lotto.tab06.subTab01.label"), lv1IDX: 6]
    }

    def customHistory38M6() { //38樂合彩歷史數據分析
        params.pType = "04"

        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)
        def vLastOpenData = netWinService.getLastOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customHistory38M6", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomHistory1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, showSpBtn: "0",
                                                          nw300I: vHistoryData.list,
                                                          nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                          nw300IL: vLastOpenData.list, nw300ILMax: vLastOpenData.maxNum,
                                                          pType: params.pType, title: g.message(code: "lotto.tab06.subTab02.label"), lv1IDX: 6, pLink : vLink]
    }

    def customContinue38M6() { //38樂合彩連續分析
        params.pType = "04"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getContinueAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customContinue38M6", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomContinue1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                           nw300I: vHistoryData.list,
                                                           nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                           pType: params.pType, title: g.message(code: "lotto.tab06.subTab04.label"), lv1IDX: 6, pLink : vLink]
    }

    def customRepeat38M6() { //38樂合彩連開分析
        params.pType = "04"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getRepeatAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customRepeat38M6", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomRepeat1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                         nw300I: vHistoryData.list,
                                                         nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                         pType: params.pType, title: g.message(code: "lotto.tab06.subTab03.label"), lv1IDX: 6, pLink : vLink]
    }

    def customLastNumber38M6() { //38樂合彩尾數分析
        params.pType = "04"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vLastNumberData = netWinService.getLastNumberAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customLastNumber38M6", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomLastNumber1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                             nw300I: vHistoryData.list,
                                                             nw300ILN: vLastNumberData.list, nw300ILNMax: vLastNumberData.maxNum, createColumn: vLastNumberData.createColumn,columnsCNTS: vLastNumberData.columnsCNTS,
                                                             pType: params.pType, title: g.message(code: "lotto.tab06.subTab05.label"), lv1IDX: 6, pLink : vLink]
    }

    def contentLotto649() { //大樂透介紹
        params.pType = "105"
        def nw400I = netWinService.getNw400List(params)
        render view: "/lotto/formContent1", model: [nw400I: nw400I, title: g.message(code: "lotto.tab07.subTab01.label"), lv1IDX: 7]
    }

    def customHistoryLotto649() { //大樂透歷史數據分析
        params.pType = "05"

        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)
        def vLastOpenData = netWinService.getLastOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customHistoryLotto649", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomHistory1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, showSpBtn: "1",
                                                          nw300I: vHistoryData.list,
                                                          nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                          nw300IL: vLastOpenData.list, nw300ILMax: vLastOpenData.maxNum,
                                                          pType: params.pType, title: g.message(code: "lotto.tab07.subTab02.label"), lv1IDX: 7, pLink : vLink]
    }

    def customContinueLotto649() { //大樂透連續分析
        params.pType = "05"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getContinueAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customContinueLotto649", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomContinue1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                           nw300I: vHistoryData.list,
                                                           nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                           pType: params.pType, title: g.message(code: "lotto.tab07.subTab04.label"), lv1IDX: 7, pLink : vLink]
    }

    def customRepeatLotto649() { //大樂透連開分析
        params.pType = "05"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getRepeatAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customRepeatLotto649", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomRepeat1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                         nw300I: vHistoryData.list,
                                                         nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                         pType: params.pType, title: g.message(code: "lotto.tab07.subTab03.label"), lv1IDX: 7, pLink : vLink]
    }

    def customLastNumberLotto649() { //大樂透尾數分析
        params.pType = "05"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vLastNumberData = netWinService.getLastNumberAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customLastNumberLotto649", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomLastNumber1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                             nw300I: vHistoryData.list,
                                                             nw300ILN: vLastNumberData.list, nw300ILNMax: vLastNumberData.maxNum, createColumn: vLastNumberData.createColumn,columnsCNTS: vLastNumberData.columnsCNTS,
                                                             pType: params.pType, title: g.message(code: "lotto.tab07.subTab05.label"), lv1IDX: 7, pLink : vLink]
    }

    def content49M6() { //49樂合彩介紹
        params.pType = "106"
        def nw400I = netWinService.getNw400List(params)
        render view: "/lotto/formContent1", model: [nw400I: nw400I, title: g.message(code: "lotto.tab08.subTab01.label"), lv1IDX: 8]
    }

    def customHistory49M6() { //49樂合彩歷史數據分析
        params.pType = "06"

        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)
        def vLastOpenData = netWinService.getLastOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customHistory49M6", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomHistory1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, showSpBtn: "0",
                                                          nw300I: vHistoryData.list,
                                                          nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                          nw300IL: vLastOpenData.list, nw300ILMax: vLastOpenData.maxNum,
                                                          pType: params.pType, title: g.message(code: "lotto.tab08.subTab02.label"), lv1IDX: 8, pLink : vLink]
    }

    def customContinue49M6() { //49樂合彩連續分析
        params.pType = "06"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getContinueAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customContinue49M6", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomContinue1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                           nw300I: vHistoryData.list,
                                                           nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                           pType: params.pType, title: g.message(code: "lotto.tab08.subTab04.label"), lv1IDX: 8, pLink : vLink]
    }

    def customRepeat49M6() { //49樂合彩連開分析
        params.pType = "06"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getRepeatAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customRepeat49M6", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomRepeat1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                         nw300I: vHistoryData.list,
                                                         nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                         pType: params.pType, title: g.message(code: "lotto.tab08.subTab03.label"), lv1IDX: 8, pLink : vLink]
    }

    def customLastNumber49M6() { //49樂合彩尾數分析
        params.pType = "06"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vLastNumberData = netWinService.getLastNumberAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customLastNumber49M6", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomLastNumber1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                             nw300I: vHistoryData.list,
                                                             nw300ILN: vLastNumberData.list, nw300ILNMax: vLastNumberData.maxNum, createColumn: vLastNumberData.createColumn,columnsCNTS: vLastNumberData.columnsCNTS,
                                                             pType: params.pType, title: g.message(code: "lotto.tab08.subTab05.label"), lv1IDX: 8, pLink : vLink]
    }

    def contentLotto539() { //今彩539介紹
        params.pType = "107"
        def nw400I = netWinService.getNw400List(params)
        render view: "/lotto/formContent1", model: [nw400I: nw400I, title: g.message(code: "lotto.tab09.subTab01.label"), lv1IDX: 9]
    }

    def customHistoryLotto539() { //今彩539歷史數據分析
        params.pType = "07"

        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)
        def vLastOpenData = netWinService.getLastOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customHistoryLotto539", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomHistory1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, showSpBtn: "0",
                                                          nw300I: vHistoryData.list,
                                                          nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                          nw300IL: vLastOpenData.list, nw300ILMax: vLastOpenData.maxNum,
                                                          pType: params.pType, title: g.message(code: "lotto.tab09.subTab02.label"), lv1IDX: 9, pLink : vLink]
    }

    def customContinueLotto539() { //今彩539連續分析
        params.pType = "07"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getContinueAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customContinueLotto539", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomContinue1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                           nw300I: vHistoryData.list,
                                                           nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                           pType: params.pType, title: g.message(code: "lotto.tab09.subTab04.label"), lv1IDX: 9, pLink : vLink]
    }

    def customRepeatLotto539() { //今彩539連開分析
        params.pType = "07"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getRepeatAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customRepeatLotto539", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomRepeat1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                         nw300I: vHistoryData.list,
                                                         nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                         pType: params.pType, title: g.message(code: "lotto.tab09.subTab03.label"), lv1IDX: 9, pLink : vLink]
    }

    def customLastNumberLotto539() { //今彩539尾數分析
        params.pType = "07"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vLastNumberData = netWinService.getLastNumberAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customLastNumberLotto539", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomLastNumber1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                             nw300I: vHistoryData.list,
                                                             nw300ILN: vLastNumberData.list, nw300ILNMax: vLastNumberData.maxNum, createColumn: vLastNumberData.createColumn,columnsCNTS: vLastNumberData.columnsCNTS,
                                                             pType: params.pType, title: g.message(code: "lotto.tab09.subTab05.label"), lv1IDX: 9, pLink : vLink]
    }

    def content39M5() { //39樂合彩介紹
        params.pType = "108"
        def nw400I = netWinService.getNw400List(params)
        render view: "/lotto/formContent1", model: [nw400I: nw400I, title: g.message(code: "lotto.tab10.subTab01.label"), lv1IDX: 10]
    }

    def customHistory39M5() { //39樂合彩歷史數據分析
        params.pType = "08"

        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)
        def vLastOpenData = netWinService.getLastOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customHistory39M5", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomHistory1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, showSpBtn: "0",
                                                          nw300I: vHistoryData.list,
                                                          nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                          nw300IL: vLastOpenData.list, nw300ILMax: vLastOpenData.maxNum,
                                                          pType: params.pType, title: g.message(code: "lotto.tab10.subTab02.label"), lv1IDX: 10, pLink : vLink]
    }

    def customContinue39M5() { //39樂合彩連續分析
        params.pType = "08"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getContinueAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customContinue39M5", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomContinue1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                           nw300I: vHistoryData.list,
                                                           nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                           pType: params.pType, title: g.message(code: "lotto.tab10.subTab04.label"), lv1IDX: 10, pLink : vLink]
    }

    def customRepeat39M5() { //39樂合彩連開分析
        params.pType = "08"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getRepeatAnyalysis1(params)
        def vCntsData = netWinService.getCntsOpenAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customRepeat39M5", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomRepeat1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                         nw300I: vHistoryData.list,
                                                         nw300IC: vCntsData.list, nw300ICMax: vCntsData.maxNum,
                                                         pType: params.pType, title: g.message(code: "lotto.tab10.subTab03.label"), lv1IDX: 10, pLink : vLink]
    }

    def customLastNumber39M5() { //39樂合彩尾數分析
        params.pType = "08"
        params.pUnSPNO = "1"
        def vHistoryData = netWinService.getHistoryAnyalysis1(params)
        def vLastNumberData = netWinService.getLastNumberAnalysis1(params)

        def vLink = g.createLink(controller: "lotto", action: "customLastNumber39M5", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomLastNumber1", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs,
                                                             nw300I: vHistoryData.list,
                                                             nw300ILN: vLastNumberData.list, nw300ILNMax: vLastNumberData.maxNum, createColumn: vLastNumberData.createColumn,columnsCNTS: vLastNumberData.columnsCNTS,
                                                             pType: params.pType, title: g.message(code: "lotto.tab10.subTab05.label"), lv1IDX: 10, pLink : vLink]
    }

    def content3D() { //3星彩介紹
        params.pType = "109"
        def nw400I = netWinService.getNw400List(params)
        render view: "/lotto/formContent1", model: [nw400I: nw400I, title: g.message(code: "lotto.tab11.subTab01.label"), lv1IDX: 11]
    }

    def customHistory3D() { //3星彩歷史數據分析
        params.pType = "09"
        def vHistoryData = netWinService.getHistoryAnyalysis3(params)

        def vLink = g.createLink(controller: "lotto", action: "customHistory3D", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomHistory3", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, columnIDXS : vHistoryData.columnIDXS, showSpBtn: "0",
                                                          nw300I: vHistoryData.list,
                                                          pType: params.pType, title: g.message(code: "lotto.tab11.subTab02.label"), lv1IDX: 11, pLink : vLink]
    }

    def content4D() { //4星彩介紹
        params.pType = "110"
        def nw400I = netWinService.getNw400List(params)
        render view: "/lotto/formContent1", model: [nw400I: nw400I, title: g.message(code: "lotto.tab12.subTab01.label"), lv1IDX: 12]
    }

    def customHistory4D() { //4星彩歷史數據分析
        params.pType = "10"
        def vHistoryData = netWinService.getHistoryAnyalysis3(params)

        def vLink = g.createLink(controller: "lotto", action: "customHistory4D", params: [lv1IDX: params.lv1IDX, lv2IDX: params.lv2IDX])
        render view: "/lotto/formCustomHistory3", model: [totalCount: vHistoryData.counts, columnsNOs: vHistoryData.columnsNOs, columnIDXS : vHistoryData.columnIDXS, showSpBtn: "0",
                                                          nw300I: vHistoryData.list,
                                                          pType: params.pType, title: g.message(code: "lotto.tab12.subTab02.label"), lv1IDX: 12, pLink : vLink]
    }

    def contentBingoBingo() { //賓果介紹
        params.pType = "111"
        def nw400I = netWinService.getNw400List(params)
        render view: "/lotto/formContent1", model: [nw400I: nw400I, title: g.message(code: "lotto.tab13.subTab01.label"), lv1IDX: 13]
    }

    def customOpenNoListBingo() { //賓果開獎號碼
        if (params.pOpendt_year && params.pOpendt_month && params.pOpendt_day) {
            params.pOpendt = params.pOpendt_year + params.pOpendt_month.padLeft(2, '0') + params.pOpendt_day.padLeft(2, '0')
            df.params_text_date_transform(params: params, list: ["pOpendt"])
        }

        params.pType = "11"
        params.max = 1
        def nw300I = netWinService.getNw300List(params)

        println "nw300I = " + nw300I
        println "nw301s = " + nw300I.nw301s
//        println "nw300I.nw301s = " + nw300I.nw301s.no
//        println "nw300I.nw301s.sort{it.id} = " + nw300I.nw301s.no.sort()
//        nw300I.nw301s{order("no","desc")}.each { it ->
//            println "it = " + it.no
//        }

        def orders = nw300I.nw301s.sort { it[0].no }
        println "orders = " + orders.no

//        params.max = 7
        def nw300OpendtList = Nw300.createCriteria().list() {
            projections {
                distinct('opendt')
            }
            eq("type", "11")
            order("opendt", "desc")
            maxResults(1)
        }

        println "nw300OpendtList = " + nw300OpendtList

//        def vLink = g.createLink(controller: "lotto", action: "customQueryHistoryBingoBingo", params: [lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX')])
//        render view: "/lotto/formCustomQueryHistory4", model: [nw300I: nw300I, totalCount: nw300I?.size(),
//                                                               pType : params.pType, lv1IDX: params.int('lv1IDX'), pLink: vLink]
        params.pType = "111"
        render view: "/lotto/formCustomOpenNoList", model: [nw300I: nw300I, title: g.message(code: "lotto.tab13.subTab02.label"), lv1IDX: 13]
    }

    def customStatistBingo() { //賓果開獎/未開獎統計
        params.pType = "111"
        render view: "/lotto/formCustomStatist1", model: [title: g.message(code: "lotto.tab13.subTab03.label"), lv1IDX: 13]
    }

    def customAnalysisBingo() { //賓果綜合分析
        params.pType = "111"
        render view: "/lotto/formCustomAnalysis1", model: [title: g.message(code: "lotto.tab13.subTab04.label"), lv1IDX: 13]
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

    def showBingoAnalysis3 () {

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

    /**
     * 賓果開獎/未開獎統計(左右橫條圖)
     * @return
     */
    def showBingoAnalysis2 () {

        println '===showBingoAnalysis2==='

        def showpage = params?.showpage?:20 //近幾期
        def sdt = params?.sdt //開始日期
        def edt = params?.edt //結束日期
        def speriods = params?.speriods //開始期數
        def eperiods = params?.eperiods //結束期數
        def s = new Sql(dataSource)

        def sql = """
                  SELECT
　　　　　　　　　NW3.OPENDT,
　　　　　　　　　NW31.NO,
　　　　　　　　　COUNT(1) CNT1, --連續
　　　　　　　　　(MAX(MAX(NW3.CNT)) OVER()) - MAX(NW3.CNT) CNT2, --最久
　　　　　　　　　0 END
　　　　　　　　　FROM (
　　　　　　　　　    SELECT
　　　　　　　　　    ROW_NUMBER() OVER(ORDER BY NW3.PERIODS ASC) CNT,
　　　　　　　　　    NW3.OBJID,
　　　　　　　　　    NW3.TYPE,
　　　　　　　　　    NW3.PERIODS,
　　　　　　　　　    NW3.OPENDT
　　　　　　　　　    FROM NW300 NW3
　　　　　　　　　    WHERE 1 = 1
　　　　　　　　　    AND NW3.TYPE = 11
　　　　　　　　　    and NW3.OPENDT = to_date('2015/8/25','yyyy/MM/dd')
　　　　　　　　　) NW3
　　　　　　　　　LEFT JOIN NW301 NW31 ON NW3.OBJID = NW31.NW300ID AND NW31.ISSPNO = 0
　　　　　　　　　WHERE 1=1
　　　　　　　　　GROUP BY NW3.OPENDT,NW31.NO
　　　　　　　　　ORDER BY COUNT(1) DESC
                  """
        def result1 = s.rows(sql)

        def LMAXNO = 0
        def RMAXNO = 0
        def list1 = []
        def list2 = []

        if (result1 != null) {
            def i = 0
            while (result1[i]!=null){
                list1 << result1[i].CNT1
                list2 << result1[i].CNT2
                i++
            }

            LMAXNO = ((list1.max())?.toInteger())==0?1:((list1.max())?.toInteger())
            RMAXNO = ((list2.max())?.toInteger())==0?1:((list2.max())?.toInteger())
        }

        render(template: '/lotto/bingoDataAnalysis2', model: [nw300InstanceList: result1, LMAXNO:LMAXNO, RMAXNO:RMAXNO])
    }


    /**
     * 賓果綜合分析
     * @return
     */
    def showBingoAnalysis () {
        def resultA = netWinService.getbingoAnalysisA()//本期球號
        def resultB = netWinService.getbingoAnalysisB()//熱門球號
        def resultC = netWinService.getbingoAnalysisC()//冷門球號
        def resultD = netWinService.getbingoAnalysisD()//熱門連莊
        def resultE = netWinService.getbingoAnalysisE()//熱門跳期
        def resultF = netWinService.getbingoAnalysisF()//二連號
        def resultG = netWinService.getbingoAnalysisG()//三連號
        def resultH = netWinService.getbingoAnalysisH()//四連號
        def resultI = netWinService.getbingoAnalysisI()//熱門頭號&熱門尾號
        def resultJ = netWinService.getbingoAnalysisJ()//二同出
        def resultK = netWinService.getbingoAnalysisK()//三同出

        def modelD = [:] //宣告map
        def listD1 = []
        def listD2 = []

        if (resultD != null) {
            for(int i in 1..80){
                if(i<10){
                    modelD.putAt("ISC0${i}", resultD."ISC0${i}")
                }else{
                    modelD.putAt("ISC${i}", resultD."ISC${i}")
                }
            }

            modelD = modelD.sort { -it.value }
            modelD.eachWithIndex { item , i ->
                if(i<10){
                    def a = "${item.key}"
                    a = a.substring(3)
                    listD1 << a
                    listD2 << "${item.value}"
                }
            }
        }

        def modelE = [:] //宣告map
        def listE1 = []
        def listE2 = []

        if (resultE != null) {
            for(int i in 1..80){
                if(i<10){
                    modelE.putAt("ISC0${i}", resultE."ISC0${i}")
                }else{
                    modelE.putAt("ISC${i}", resultE."ISC${i}")
                }
            }

            modelE = modelE.sort { -it.value }
            modelE.eachWithIndex { item , i ->
                if(i<10){
                    def a = "${item.key}"
                    a = a.substring(3)
                    listE1 << a
                    listE2 << "${item.value}"
                }
            }
        }

        render(template: '/lotto/bingoDataAnalysis3', model: [resultAList:resultA, resultBList:resultB, resultCList:resultC,
                                                              listD1:listD1, listD2:listD2,
                                                              listE1:listE1, listE2:listE2,
                                                              resultFList:resultF, resultGList:resultG, resultHList:resultH,
                                                              resultIList:resultI, resultJList:resultJ, resultKList:resultK])
    }
}
