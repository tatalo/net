class SportsController {
    static void main(String[] args){
    }

    //分頁
    static def alltabs = [
        [tab: '01', bs101: '01'],
        [tab: '02', bs101: '02'],
        [tab: '03', bs101: '03'],
        [tab: '04', bs101: '04'],
        [tab: '05', bs101: '05'],
        [tab: '06', bs101: '06'],
        [tab: '07', bs101: '99']
    ]

    def index() {
        //運動目前參數List
        def bs101I = Bs101.findAllByPtype("NW200TYPE")

        //運動資料
        def nw200I = Nw200.findAllByTypeInList(bs101I.pcode)

        render view: "/sports/index", model: [nw200I : nw200I, fragment : params.fragment, alltabs : alltabs]
    }
}
