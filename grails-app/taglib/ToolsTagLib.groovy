class ToolsTagLib {
    static namespace = "bs"

    static returnObjectForTags = [
            "bs101",
            "bs101s"
    ]

    //取得BS101名稱
    def bs101 = { attrs, body ->
        def ptype = attrs.remove('ptype')
        def pcode = attrs.remove('pcode')

        return Bs101.findByPtypeAndPcode(ptype, pcode)?.pdesc ?: attrs.notfound ?: ""
    }

    //取得BS101參數List
    def bs101s = { attrs, body ->
        def ptype = attrs.remove('ptype')

        def list = Bs101.findAllByPtype(ptype, [sort: "porder", order: "asc"])
        return list
    }

}
