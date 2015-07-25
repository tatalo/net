class GambleTechController {

    static void main(String[] args){
    }

    def index() {
        render( view: "/gambleTech/index")
    }
    def result() {
        render( template: "/gambleTech/result")
    }
}
