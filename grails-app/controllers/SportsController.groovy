class SportsController {
    def netReptileService

    static void main(String[] args){
    }

    def index() {
        //運動分頁中tabs
        def bs101I = Bs101.findAllByPtype("NW200TYPE")

        //各tabs中資料
        def nw200I = Nw200.findAllByTypeInList(bs101I.pcode)

        render view: "/sports/index", model: [bs101I : bs101I, bs101INum : bs101I.size(), nw200I : nw200I]
    }
}
