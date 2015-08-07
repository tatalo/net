class GambleTechController {
    def grailsApplication

    static void main(String[] args){
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
    static def alltabs = [
            [id: UUID.randomUUID(),tab: '01', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: '', dataType: '' ]]],
            [id: UUID.randomUUID(),tab: '02', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '302' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '352' ]]],
            [id: UUID.randomUUID(),tab: '03', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '303' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '353' ]]],
            [id: UUID.randomUUID(),tab: '04', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '304' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '354' ]]],
            [id: UUID.randomUUID(),tab: '05', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '305' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '355' ]]],
            [id: UUID.randomUUID(),tab: '06', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '306' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '356' ]]],
            [id: UUID.randomUUID(),tab: '07', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '307' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '357' ]]],
            [id: UUID.randomUUID(),tab: '08', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '308' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '358' ]]],
            [id: UUID.randomUUID(),tab: '09', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '309' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '359' ]]]
    ]
    def index() { //博彩技巧

        //取得類型context all types
        def nw400Types = alltabs?.lv2Tab.collect { //資料取得規則就好
            def k = []
            it.each { it2 ->
                if (it2.tab in ['01']) {
                    k.add(it2)
                }
            }
            return k
        }.dataType.flatten().findAll()

        //取得類型context資料
        def nw400I = Nw400.findAllByTypeInList(nw400Types)

        render view: "/gambleTech/index", model: [nw400I: nw400I, fragment : params.fragment, alltabs : alltabs]
    }

    def list() {
        params.max = grailsApplication.config.grails.plugins.remotepagination.max
        def nw400I = Nw400.findAll(params) {
            eq("type", params.type)
        }

        render view: "/gambleTech/_list1", model: [nw400I: nw400I, totalCount: nw400I.totalCount, fragment : params.fragment, divId : params.divId]
    }

    def list2Content ={
        //瀏覽次數
        def nw400I = Nw400.get(params.id)
        nw400I.browsercnts = ((nw400I.browsercnts?:0)+1)
        nw400I.manLastUpdated = "BROWSER"
        nw400I.save(flush: true)

        render view: "/gambleTech/_list1ToContent1", model: [nw400I: nw400I ,divId : params.divId]
    }
}
