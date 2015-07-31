class GambleTechController {

    static void main(String[] args){
    }

    //分頁
    static def alltabs = [
            [tab: '01', bs101: ''],
            [tab: '02', bs101: ''],
            [tab: '03', bs101: ''],
            [tab: '04', bs101: ''],
            [tab: '05', bs101: ''],
            [tab: '06', bs101: ''],
            [tab: '07', bs101: ''],
            [tab: '08', bs101: ''],
            [tab: '09', bs101: '']
    ]

    def index() {
        //博彩技巧目前參數List
//        def bs101I = Bs101.findAllByPtype("NW200TYPE")

        //博彩技巧資料
//        def nw200I = Nw200.findAllByTypeInList(bs101I.pcode)

        render view: "/gambleTech/index", model: [fragment : params.fragment, alltabs : alltabs]
    }
}
