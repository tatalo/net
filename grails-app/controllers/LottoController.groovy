class LottoController {

    static void main(String[] args){
        def nw300I = new Nw300()
        println "nw300I = " + nw300I
    }

    def index() {

        render( view: "/lotto/index")
    }
    def result() {
        render( template: "/lotto/result")
    }
}
