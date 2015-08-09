class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"base")

//        "/"(controller:"entry")
        "/sports"(controller:"sports",action: "index")
        "/nationGamble"(controller:"nationGamble",action: "index")
        "/gambleTech"(controller:"gambleTech",action: "index")
//        "500"(view:'/error')
        "500"(controller: "error", action: "500")
        "404"(controller: "error", action: "404")
	}
}
