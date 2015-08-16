class GambleTechController {
    def netWinService
    def grailsApplication

    static void main(String[] args){
    }

    // 分頁參數管理
    // Type: webLink => NW200
    //       context => NW400
    //       list => NW500
    static def alltabs = [
            [tab: '01', subTab: [[tab: '01' ,Type: '', dataType: [] ]]],
            [tab: '02', subTab: [[tab: '01' ,Type: 'context', dataType: ['302'] ],
                                 [tab: '02' ,Type: 'context_list', dataType: ['352'] ]]],
            [tab: '03', subTab: [[tab: '01' ,Type: 'context', dataType: ['303'] ],
                                 [tab: '02' ,Type: 'context_list', dataType: ['353'] ]]],
            [tab: '04', subTab: [[tab: '01' ,Type: 'context', dataType: ['304'] ],
                                 [tab: '02' ,Type: 'context_list', dataType: ['354'] ]]],
            [tab: '05', subTab: [[tab: '01' ,Type: 'context', dataType: ['305'] ],
                                 [tab: '02' ,Type: 'context_list', dataType: ['355'] ]]],
            [tab: '06', subTab: [[tab: '01' ,Type: 'context', dataType: ['306'] ],
                                 [tab: '02' ,Type: 'context_list', dataType: ['356'] ]]],
            [tab: '07', subTab: [[tab: '01' ,Type: 'context', dataType: ['307'] ],
                                 [tab: '02' ,Type: 'context_list', dataType: ['357'] ]]],
            [tab: '08', subTab: [[tab: '01' ,Type: 'context', dataType: ['308'] ],
                                 [tab: '02' ,Type: 'context_list', dataType: ['358'] ]]],
            [tab: '09', subTab: [[tab: '01' ,Type: 'context', dataType: ['309'] ],
                                 [tab: '02' ,Type: 'context_list', dataType: ['359'] ]]]
    ]
    def index() { //博彩技巧
        render view: "/gambleTech/index", model: [alltabs : alltabs]
    }

    def list() {
        if (params.pTab in ["01"] && params.pSubTab in ["01"]) {
            render template: "/base/build"
        } else if (params.pTab in ["02", "03", "04", "05", "06", "07", "08", "09"]
                        && params.pSubTab in ["01"]) {
            params.pType = Eval.me(params.pTypes)[0]
            def nw400I = netWinService.getNw400List(params)

            render template: "/gambleTech/content1", model: [nw400I: nw400I]
        } else if (params.pTab in ["02", "03", "04", "05", "06", "07", "08", "09"]
                && params.pSubTab in ["02"]) {
            params.pType = Eval.me(params.pTypes)[0]
            params.max = grailsApplication.config.grails.plugins.remotepagination.max
            def nw400I = netWinService.getNw400List(params)

            render template: "/gambleTech/list1", model: [nw400I: nw400I, totalCount: nw400I?.totalCount,
                                                          divId : params.divId, pTab: params.pTab, pSubTab: params.pSubTab, pTypes : params.pTypes, offset : params.offset]
        }
    }

    def list2Content ={
        def nw400I = netWinService.updateNw400BrowsCnts(params)
        render view: "/gambleTech/_list1ToContent1", model: [nw400I: nw400I ,
                                                             divId : params.divId, pTab: params.pTab, pSubTab: params.pSubTab, pTypes : params.pTypes, offset : params.offset]
    }
}
