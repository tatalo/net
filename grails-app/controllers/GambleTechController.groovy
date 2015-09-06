class GambleTechController {
    def netWinService
    def grailsApplication

    static void main(String[] args){
    }

    def index() { //博彩技巧
        redirect action: "content21"
    }

    def content21() { //21點介紹
        params.pType = "302"
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formContent1", model: [nw400I: nw400I, lv1IDX: 2, lv2IDX: 1]
    }

    def contentRoulette() { //輪盤介紹
        params.pType = "303"
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formContent1", model: [nw400I: nw400I, lv1IDX: 3, lv2IDX: 1]
    }

    def contentShowHand() { //梭哈介紹
        params.pType = "304"
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formContent1", model: [nw400I: nw400I, lv1IDX: 4, lv2IDX: 1]
    }

    def contentHoldem() { //德州撲克介紹
        params.pType = "305"
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formContent1", model: [nw400I: nw400I, lv1IDX: 5, lv2IDX: 1]
    }

    def contentBaccarat() { //百家樂介紹
        params.pType = "306"
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formContent1", model: [nw400I: nw400I, lv1IDX: 6, lv2IDX: 1]
    }

    def contentSlotMachine() { //老虎機介紹
        params.pType = "307"
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formContent1", model: [nw400I: nw400I, lv1IDX: 7, lv2IDX: 1]
    }

    def contentTaiSai() { //骰寶介紹
        params.pType = "308"
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formContent1", model: [nw400I: nw400I, lv1IDX: 8, lv2IDX: 1]
    }

    def contentPaiGow() { //牌九介紹
        params.pType = "309"
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formContent1", model: [nw400I: nw400I, lv1IDX: 9, lv2IDX: 1]
    }

    def contentList21() { //21點技巧策略
        params.pType = "352"
        params.max = params?.max ? params.max : grailsApplication.config.grails.plugins.remotepagination.max
        params.offset = params?.offset ? params.offset : 0
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formList1", model: [nw400I: nw400I, totalCount: nw400I?.totalCount, max: params.max, offset : params.offset, lv1IDX: 2, lv2IDX: 2]
    }

    def contentListRoulette() { //輪盤技巧策略
        params.pType = "353"
        params.max = params?.max ? params.max : grailsApplication.config.grails.plugins.remotepagination.max
        params.offset = params?.offset ? params.offset : 0
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formList1", model: [nw400I: nw400I, totalCount: nw400I?.totalCount, max: params.max, offset : params.offset, lv1IDX: 3, lv2IDX: 2]
    }

    def contentListShowHand() { //梭哈技巧策略
        params.pType = "354"
        params.max = params?.max ? params.max : grailsApplication.config.grails.plugins.remotepagination.max
        params.offset = params?.offset ? params.offset : 0
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formList1", model: [nw400I: nw400I, totalCount: nw400I?.totalCount, max: params.max, offset : params.offset, lv1IDX: 4, lv2IDX: 2]
    }

    def contentListHoldem() { //德州撲克技巧策略
        params.pType = "355"
        params.max = params?.max ? params.max : grailsApplication.config.grails.plugins.remotepagination.max
        params.offset = params?.offset ? params.offset : 0
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formList1", model: [nw400I: nw400I, totalCount: nw400I?.totalCount, max: params.max, offset : params.offset, lv1IDX: 5, lv2IDX: 2, pLink: vLink]
    }

    def contentListBaccarat() { //百家樂技巧策略
        params.pType = "356"
        params.max = params?.max ? params.max : grailsApplication.config.grails.plugins.remotepagination.max
        params.offset = params?.offset ? params.offset : 0
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formList1", model: [nw400I: nw400I, totalCount: nw400I?.totalCount, max: params.max, offset : params.offset, lv1IDX: 6, lv2IDX: 2]
    }

    def contentListSlotMachine() { //老虎機技巧策略
        params.pType = "357"
        params.max = params?.max ? params.max : grailsApplication.config.grails.plugins.remotepagination.max
        params.offset = params?.offset ? params.offset : 0
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formList1", model: [nw400I: nw400I, totalCount: nw400I?.totalCount, max: params.max, offset : params.offset, lv1IDX: 7, lv2IDX: 2]
    }

    def contentListTaiSai() { //骰寶技巧策略
        params.pType = "358"
        params.max = params?.max ? params.max : grailsApplication.config.grails.plugins.remotepagination.max
        params.offset = params?.offset ? params.offset : 0
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formList1", model: [nw400I: nw400I, totalCount: nw400I?.totalCount, max: params.max, offset : params.offset, lv1IDX: 8, lv2IDX: 2]
    }

    def contentListPaiGow() { //牌九技巧策略
        params.pType = "359"
        params.max = params?.max ? params.max : grailsApplication.config.grails.plugins.remotepagination.max
        params.offset = params?.offset ? params.offset : 0
        def nw400I = netWinService.getNw400List(params)
        render view: "/gambleTech/formList1", model: [nw400I: nw400I, totalCount: nw400I?.totalCount, max: params.max, offset : params.offset, lv1IDX: 9, lv2IDX: 2]
    }


    def content() { //技巧策略文章
        def nw400I = netWinService.updateNw400BrowsCnts(params)
        render view: "/gambleTech/formContent2", model: [nw400I: nw400I, lv1IDX: params.int('lv1IDX'), lv2IDX: params.int('lv2IDX'), backLink: params.backLink]
    }
}
