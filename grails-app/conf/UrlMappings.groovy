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

    // IndexController.groovy
    class IndexController {
        def index() {  // index is the default action for any controller
            println "test"
//            [myDomainObjList: My.findAll()] // the model available to the view
        }
    }
}
