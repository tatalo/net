class NationGambleController {

    static void main(String[] args){
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
    static def alltabs = [
            [id: UUID.randomUUID(), tab: '01', Type: 'webLink', dataType: ['201','202']],
            [id: UUID.randomUUID(), tab: '02', Type: 'webLink', dataType: ['203']],
            [id: UUID.randomUUID(), tab: '03', Type: 'webLink', dataType: ['204']],
            [id: UUID.randomUUID(), tab: '04', Type: 'context', dataType: ['201']],
            [id: UUID.randomUUID(), tab: '05', Type: 'context', dataType: ['202']],
            [id: UUID.randomUUID(), tab: '06', Type: 'context', dataType: ['203']],
            [id: UUID.randomUUID(), tab: '07', Type: 'list', dataType: ['201']],
            [id: UUID.randomUUID(), tab: '08', Type: 'context', dataType: ['204']],
            [id: UUID.randomUUID(), tab: '09', Type: 'context', dataType: ['205']]
    ]

    def index() {
        //國際博彩List
        def nw200Types = alltabs?.findAll(){it?.Type == 'webLink'}.dataType.flatten().findAll()
        def nw400Types = alltabs?.findAll(){it?.Type == 'context'}.dataType.flatten().findAll()
        def nw500Types = alltabs?.findAll(){it?.Type == 'list'}.dataType.flatten().findAll()

        //國際博彩資料
        def nw200I = Nw200.findAllByTypeInList(nw200Types)
        def nw400I = Nw400.findAllByTypeInList(nw400Types)
        def nw500I = Nw500.findAllByTypeInList(nw500Types)

        render view: "/nationGamble/index", model: [nw200I:nw200I, nw400I:nw400I, nw500I:nw500I, fragment : params.fragment, alltabs : alltabs]
    }
}
