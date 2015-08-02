class GambleTechController {

    static void main(String[] args){
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    static def alltabs = [
            [id: UUID.randomUUID(),tab: '01', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: '', dataType: '' ]]],
            [id: UUID.randomUUID(),tab: '02', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '02' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '102' ]]],
            [id: UUID.randomUUID(),tab: '03', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '02' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '103' ]]],
            [id: UUID.randomUUID(),tab: '04', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '02' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '104' ]]],
            [id: UUID.randomUUID(),tab: '05', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '02' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '105' ]]],
            [id: UUID.randomUUID(),tab: '06', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '02' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '106' ]]],
            [id: UUID.randomUUID(),tab: '07', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '02' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '107' ]]],
            [id: UUID.randomUUID(),tab: '08', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '02' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '108' ]]],
            [id: UUID.randomUUID(),tab: '09', lv2Tab: [[id: UUID.randomUUID(), tab: '01' ,Type: 'context', dataType: '02' ],
                                                       [id: UUID.randomUUID(), tab: '02' ,Type: 'context', dataType: '109' ]]]
    ]
    def index() {
        //List
        def nw400Types = []

        alltabs?.lv2Tab.each {it ->
            it.dataType.each { it2 ->
                if (it2 != "") {
                    nw400Types += it2
                }
            }
        }

        println "nw400Types = " + nw400Types


        //博彩技巧資料
        def nw400I = Nw400.findAllByTypeInList(nw400Types.unique())

        println "nw400I = " + nw400I
        println "nw400I.context1 = " + nw400I.findAll(){it.type == '02'}
        println "nw400I.context2 = " + nw400I.findAll(){it.type == '102'}

        render view: "/gambleTech/index", model: [nw400I: nw400I, fragment : params.fragment, alltabs : alltabs]
    }
}
