package com.keo

class UrlMappings {
    static mappings = {
        get "/api/project"(controller: 'project', action: 'index')
        "/auth/register"(resources: 'auth', action: 'save')
//        "/api/project"(resources: 'application', action: 'index')
        "/"(controller: 'application', action: 'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

    }
}
