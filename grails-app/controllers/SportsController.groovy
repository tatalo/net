class SportsController {

    static void main(String[] args){
    }

    def index() {
        render( view: "/sports/index")
    }

    def query() {
        Power228Generator

        if (params.type in ['01','02','03','04','05']) {
            render(template: "/sports/result1")
        } else if (params.type in ['06','07','08']) {
            render(template: "/sports/result2")
        }
    }
}
