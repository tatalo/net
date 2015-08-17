
import org.codehaus.groovy.grails.commons.metaclass.GroovyDynamicMethodsInterceptor
import org.codehaus.groovy.grails.web.metaclass.BindDynamicMethod
import grails.transaction.Transactional

@Transactional
class NetWinService {

    NetWinService() {
        GroovyDynamicMethodsInterceptor i = new GroovyDynamicMethodsInterceptor(this)
        i.addDynamicMethodInvocation(new BindDynamicMethod())
    }

    static void main(String[] args){
    }

    def getNw200List(params) { //回傳Nw200 List
        def nw200I = Nw200.findAll() {
            eq("type", params.pType)
        }
        return nw200I
    }

    def getNw400List(params) { //回傳Nw400 List
        def nw400I = Nw400.findAll(params) {
            eq("type", params.pType)
        }
        return nw400I
    }

    def getNw400(params) { //取得Nw400
        def nw400I = Nw400.get(params.id)
        return nw400I
    }

    def saveNw400(params) { //更新Nw400
        def nw400I = Nw400.get(params.id)

        bindData(nw400I, params)
        nw400I.manLastUpdated = "ADMIN"

        if (!nw400I.hasErrors()) {
            nw400I.save(flush: true)
        }

        return nw400I
    }

    def updateNw400BrowsCnts(params) { //更新閱讀次數後回傳Nw400
        def nw400I = Nw400.get(params.id)
        nw400I.browsercnts = ((nw400I?.browsercnts?:0)+1)
        nw400I.manLastUpdated = "BROWSER"
        nw400I.save(flush: true)
        return nw400I
    }

    def getNw500List(params) { //回傳Nw500 List
        def nw500I = Nw500.findAll() {
            eq("type", params.pType)
        }
        return nw500I
    }

    def getLottoList() {

    }
}
