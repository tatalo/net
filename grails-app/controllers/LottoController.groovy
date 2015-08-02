class LottoController {

    static void main(String[] args){
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
    static def alltabs = [ //dataType: Nw300.Type
            [tab: '01', dataType: ''],
            [tab: '02', dataType: ''],
            [tab: '03', dataType: '01'],
            [tab: '04', dataType: '02'],
            [tab: '05', dataType: '03'],
            [tab: '06', dataType: '04'],
            [tab: '07', dataType: '05'],
            [tab: '08', dataType: '06'],
            [tab: '09', dataType: '07'],
            [tab: '10', dataType: '08'],
            [tab: '11', dataType: '09'],
            [tab: '12', dataType: '10'],
            [tab: '13', dataType: '11'],
            [tab: '14', dataType: '']
    ]

    def index() {
        //彩球目前參數List
//        def bs101I = Bs101.findAllByPtype("NW200TYPE")

        //彩球資料
//        def nw200I = Nw200.findAllByTypeInList(bs101I.pcode)

        render view: "/lotto/index", model: [fragment : params.fragment, alltabs : alltabs]
    }
}
