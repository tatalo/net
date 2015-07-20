package tabs

class NationGambleController {

    def index() {
        render( view: "/nationGamble/index")
    }

    def result() {
        render( template: "/nationGamble/result")
    }

    def result2() {
        render( template: "/nationGamble/result2")
    }
}
