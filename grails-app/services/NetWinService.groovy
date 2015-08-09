import grails.transaction.Transactional

@Transactional
class NetWinService {

    static void main(String[] args){
    }

    def getNw200List(params) {
        def nw200I = Nw200.findAll() {
            eq("type", params.pType)
        }
        return nw200I
    }

    def getNw400List(params) {
        def nw400I = Nw400.findAll() {
            eq("type", params.pType)
        }
        return nw400I
    }

    def getNw500List(params) {
        def nw500I = Nw500.findAll() {
            eq("type", params.pType)
        }
        return nw500I
    }
}
