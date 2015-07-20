package tabs

class LottoController {

    def index() {
        render( view: "/lotto/index")
    }
    def result() {
        render( template: "/lotto/result")
    }
}
