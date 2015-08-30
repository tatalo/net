class SportsController {
    def netWinService

    static void main(String[] args) {
    }

    def index() { //運動
        redirect action: "webLinkTianSia"
    }

    def list() {
    }

    def webLinkTianSia() {
        params.pType = "01"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/formWebLink1", model: [nw200I: nw200I, title: g.message(code: "sports.tab01.label")]
    }

    def webLink35688() {
        params.pType = "02"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/formWebLink2", model: [nw200I: nw200I, title: g.message(code: "sports.tab02.label")]
    }

    def webLink35688China() {
        params.pType = "03"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/formWebLink2", model: [nw200I: nw200I, title: g.message(code: "sports.tab03.label")]
    }

    def webLinkSinSinBao() {
        params.pType = "04"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/formWebLink2", model: [nw200I: nw200I, title: g.message(code: "sports.tab04.label")]
    }

    def webLinkYingSyong() {
        params.pType = "05"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/formWebLink1", model: [nw200I: nw200I, title: g.message(code: "sports.tab05.label")]
    }

    def webLinkRongHuaHuei() {
        params.pType = "06"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/formWebLink2", model: [nw200I: nw200I, title: g.message(code: "sports.tab06.label")]
    }

    def webLinkOther() {
        params.pType = "99"
        def nw200I = netWinService.getNw200List(params)
        render view: "/sports/formWebLink2", model: [nw200I: nw200I, title: g.message(code: "sports.tab07.label")]
    }
}
