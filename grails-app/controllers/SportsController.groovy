import grails.gorm.*

class SportsController {
    static void main(String[] args){
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
    static def alltabs = [
        [id: UUID.randomUUID(), tab: '01', Type: 'webLink', dataType: ['01']],
        [id: UUID.randomUUID(), tab: '02', Type: 'webLink', dataType: ['02']],
        [id: UUID.randomUUID(), tab: '03', Type: 'webLink', dataType: ['03']],
        [id: UUID.randomUUID(), tab: '04', Type: 'webLink', dataType: ['04']],
        [id: UUID.randomUUID(), tab: '05', Type: 'webLink', dataType: ['05']],
        [id: UUID.randomUUID(), tab: '06', Type: 'webLink', dataType: ['06']],
        [id: UUID.randomUUID(), tab: '07', Type: 'webLink', dataType: ['99']]
    ]

    def index() {
        //運動類型List
        def nw200Types = alltabs?.findAll(){it?.Type == 'webLink'}.dataType.flatten().findAll()

        //運動資料
//        def nw200I2 = Nw200.findAllByTypeInList(nw200Types)

        params.max = 5
        def nw200I = Nw200.createCriteria().list(params) {
//            projections {
//                property("id")
//            }
            inList("type",["01"])
        }

        def test = Nw300.findAll(params) {
            inList("type", ["02"])
            nw301s {
                inList("isspno",0 as Long)
            }
        }
        println "test = " + test

        def test2 = Nw300.createCriteria().list(params) {
            inList("type", ["02"])
            nw301s {
                inList("isspno",0)
            }
        }
        println "test2 = " + test2

//        def counts = nw200I.totalCount

//
        println "nw200I = " + nw200I
        println "nw200I.totalCount2 = " + counts

//
////        println "nw200I = " + nw200I.
//        println "nw200I = " + nw200I.

        render view: "/sports/index", model: [nw200I : nw200I, total: nw200I.totalCount, fragment : params?.fragment, alltabs : alltabs]
    }
}
