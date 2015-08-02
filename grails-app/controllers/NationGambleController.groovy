class NationGambleController {

    static void main(String[] args){
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
    static def alltabs = [
            [id: UUID.randomUUID(), tab: '01', Type: 'webLink', dataType: '01'],
            [id: UUID.randomUUID(), tab: '02', Type: 'webLink', dataType: '02'],
            [id: UUID.randomUUID(), tab: '03', Type: 'webLink', dataType: '03'],
            [id: UUID.randomUUID(), tab: '04', Type: 'context', dataType: '04'],
            [id: UUID.randomUUID(), tab: '05', Type: 'context', dataType: '05'],
            [id: UUID.randomUUID(), tab: '06', Type: 'context', dataType: '06'],
            [id: UUID.randomUUID(), tab: '07', Type: 'list', dataType: '07'],
            [id: UUID.randomUUID(), tab: '08', Type: 'context', dataType: '08'],
            [id: UUID.randomUUID(), tab: '09', Type: 'context', dataType: '09']
    ]

    def index() {
        //國際博彩List
        def nw200Types = alltabs?.findAll(){it?.Type == 'webLink'}.dataType
        def nw400Types = alltabs?.findAll(){it?.Type == 'context'}.dataType
        def nw500Types = alltabs?.findAll(){it?.Type == 'list'}.dataType

        println "nw200Types = " + nw200Types
        println "nw400Types = " + nw400Types
        println "nw500Types = " + nw500Types

        //國際博彩資料
        def nw200I = Nw200.findAllByTypeInList(nw200Types)
        def nw400I = Nw400.findAllByTypeInList(nw400Types)
        def nw500I = Nw500.findAllByTypeInList(nw500Types)

        println "nw200I = " + nw200I
        println "nw400I = " + nw400I
        println "nw500I = " + nw500I

        render view: "/nationGamble/index", model: [fragment : params.fragment, alltabs : alltabs]
    }
}
