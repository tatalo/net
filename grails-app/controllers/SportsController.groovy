class SportsController {

    static void main(String[] args){
    }

    def index() {
        deft bs100List = Bs100

        def nw200I = Nw200.all
        println "nw200I = " + nw200I

        render( view: "/sports/index")
    }

    def query() {
//        if (params.type in ['01','02','03','04','05']) {
            render(template: "/sports/result1")
//        } else if (params.type in ['06','07','08']) {
//            render(template: "/sports/result2")
//        }
    }
}
