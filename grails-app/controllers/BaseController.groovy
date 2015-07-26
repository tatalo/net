class BaseController {

    static void main(String[] args){
//        def nw300I = Nw300.read("268435459")
        def nw300I = new Nw300(manCreated: 'system',manLastUpdated: 'system')
//        nw300I.manLastUpdated = "test55"
        nw300I.validate()

        nw300I.errors.each {
            println "it = " + it
        }

        nw300I.save flush: true

    }

    def index() {
        println "1"
//        def nw300I = new Nw300(manCreated: 'system',manLastUpdated: 'system')
        def nw300I = Nw300.get("268435459")
        nw300I.manLastUpdated = "test3"
        nw300I.validate()

        nw300I.errors.each {
            println "it = " + it
        }

        nw300I.save flush: true



        println "nw300Is = " + nw300I
        println "2"
        println "3"
        render view:"/index"
    }

    def build() {
        render view:"/system/base/build"
    }
}
