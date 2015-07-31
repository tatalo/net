class LottoController {

    static void main(String[] args){
    }

    //分頁
    static def alltabs = [
            [tab: '01', bs101: ''],
            [tab: '02', bs101: ''],
            [tab: '03', bs101: '01'],
            [tab: '04', bs101: '02'],
            [tab: '05', bs101: '03'],
            [tab: '06', bs101: '04'],
            [tab: '07', bs101: '05'],
            [tab: '08', bs101: '06'],
            [tab: '09', bs101: '07'],
            [tab: '10', bs101: '08'],
            [tab: '11', bs101: '09'],
            [tab: '12', bs101: '10'],
            [tab: '13', bs101: '11'],
            [tab: '14', bs101: '']
    ]

    def index() {
        //彩球目前參數List
//        def bs101I = Bs101.findAllByPtype("NW200TYPE")

        //彩球資料
//        def nw200I = Nw200.findAllByTypeInList(bs101I.pcode)

        render view: "/lotto/index", model: [fragment : params.fragment, alltabs : alltabs]
    }
}
