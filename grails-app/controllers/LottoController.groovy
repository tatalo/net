class LottoController {

    static void main(String[] args){
    }

    def index() {

        render( view: "/lotto/index")
    }
    def result() {
        render( template: "/lotto/result")
    }
}
