package com.keo

class ProjectController {

    def projectService
    def springSecurityService

	static responseFormats = ['json', 'xml']

    def index() {
        def params = params
        def max = params['max'] as int
        params["max"] = Math.min(max ?: 10, 100)
        def result = projectService.list(params)
        respond result
    }

    def save() {
        def requestBody = request.JSON
        def user = springSecurityService.currentUser
        def project = new Project(requestBody)

        if (project.validate()) {
           def p = projectService.create(project.name, project.description, user.id)
            respond p
        } else {
            respond project.errors
        }
    }

    def delete(int id) {
        respond projectService.delete(id)
    }

    def show(int id) {
        respond projectService.findOne(id)
    }


    def patch(int id) {
        def body = request.JSON
        def user = springSecurityService.currentUser
        respond projectService.update(id, body, user)
    }
}
