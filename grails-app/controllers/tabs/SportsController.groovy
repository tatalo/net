package tabs



class SportsController {

    def index() {
        render( view: "/sports/index")
    }

    def result() {
        render( template: "/sports/result")
    }

    def result2() {
        render( template: "/sports/result2")
    }
}
