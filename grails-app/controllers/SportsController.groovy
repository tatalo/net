class SportsController {
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
        [id: UUID.randomUUID(), tab: '04', Type: 'webLink', dataType: '04'],
        [id: UUID.randomUUID(), tab: '05', Type: 'webLink', dataType: '05'],
        [id: UUID.randomUUID(), tab: '06', Type: 'webLink', dataType: '06'],
        [id: UUID.randomUUID(), tab: '07', Type: 'webLink', dataType: '99']
    ]

    def index() {
        //運動類型List
        def nw200Types = alltabs?.findAll(){it?.Type == 'webLink'}.dataType

        //運動資料
        def nw200I = Nw200.findAllByTypeInList(nw200Types)

        render view: "/sports/index", model: [nw200I : nw200I, fragment : params?.fragment, alltabs : alltabs]
    }
}
