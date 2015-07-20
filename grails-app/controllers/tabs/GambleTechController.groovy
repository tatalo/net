package tabs

class GambleTechController {

    def index() {
        render( view: "/gambleTech/index")
    }
    def result() {
        render( template: "/gambleTech/result")
    }
}
