package tabs



class SportsController {

    def index() {
        render( view: "/sports/index")
    }

    def query() {
        println "params = " + params
        if (params.type in ['01','02','03','04','05']) {
            render(template: "/sports/result1")
        } else if (params.type in ['06','07','08']) {
            render(template: "/sports/result2")
        }
    }
}
