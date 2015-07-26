class BaseController {

    static void main(String[] args){
    }

    def index() {
        render view:"/index"
    }

    def build() {
        render view:"/build"
    }
}
