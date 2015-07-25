class ErrorController {

    static void main(String[] args){
    }

    def index(HandleErrorCommand erc) {
        redirect(action:"${erc.code}")
    }

    def '500'(){
        render(status: 500, view:"/system/error/500")
    }

    def '404'(){
        render(status: 404, view:"/system/error/404")
    }
}

class HandleErrorCommand{
    String code
}