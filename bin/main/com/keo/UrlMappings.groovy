package com.keo

class UrlMappings {
    static mappings = {
        delete "/api/$controller/$id(.$format)?"(action:"delete")
        get "/api/$controller(.$format)?"(action:"index")
        get "/api/$controller/$id(.$format)?"(action:"show")
        post "/api/$controller(.$format)?"(action:"save")
        put "/api/$controller/$id(.$format)?"(action:"update")
        patch "/api/$controller/$id(.$format)?"(action:"patch")

        "/auth/register"(resources: 'auth', action: 'save')
        "/"(controller: 'application', action: 'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

    }
}
