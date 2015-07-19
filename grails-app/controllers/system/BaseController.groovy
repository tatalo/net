package system

class BaseController {

    def index() {
        render view:"/index"
    }

    def build() {
        render view:"/system/base/build"
    }
}
