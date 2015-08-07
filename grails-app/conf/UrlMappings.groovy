class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"base")
        "500"(controller: "error", action: "500")
        "404"(controller: "error", action: "404")
	}
}
