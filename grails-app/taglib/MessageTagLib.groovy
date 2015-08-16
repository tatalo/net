class MessageTagLib {

    static namespace = "msg"

    /**
     * 執行成功訊息
     * @attr message REQUIRED 訊息內容
     */
    def success = { attr, body ->
        out << custom(type: "success", message: "<strong>成功！</strong>" + attr.message)
    }

    /**
     * 執行失敗訊息
     * @attr message REQUIRED 訊息內容
     */
    def failed = { attr, body ->
        out << custom(type: "danger", message: "<strong>失敗！</strong>" + attr.message)
    }
    /**
     * 通知訊息
     * @attr message REQUIRED 訊息內容
     */
    def info = { attr, body ->
        out << custom(type: "info", message: "<strong>通知！</strong>" + attr.message)
    }

    /**
     * 客製化訊息
     * @attr message REQUIRED 訊息內容
     */
    def custom = { attr, body ->
        out << """<div id="message" class="alert alert-${attr.type} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" style="right: 0px;"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            """
        out << attr.message
        out << body()
        out << """
            </div>"""
    }
}
