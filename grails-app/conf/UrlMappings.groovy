class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "base", action: "index")

//        "/sports"(resources:"sports")
//        "/nationGamble"(resources:"nationGamble")
//        "/gambleTech"(resources:"gambleTech")
//        "/lotto"(resources:"lotto")
        "/editContent"(controller: "base", action: "editContent")

        "/sports"(controller: "sports", action: "index")
        "/lotto"(controller: "lotto", action: "index")
        "/nationGamble"(controller: "nationGamble", action: "index")
        "/gambleTech"(controller: "gambleTech", action: "index")
        "/scoreLive"(controller: "scoreLive", action: "index")
        "/gameAnalytics"(controller: "gameAnalytics", action: "index")

        "500"(controller: "error", action: "500")
        "404"(controller: "error", action: "404")
    }
}
