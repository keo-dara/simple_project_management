package com.keo


class ProjectController {

    def projectService
    def springSecurityService

	static responseFormats = ['json', 'xml']

    def index() {

        def result = projectService.list()

        respond result
    }

    def save() {
        def requestBody = request.JSON
        def user = springSecurityService.currentUser
        def project = new Project(requestBody)
        project.manager = user

        if (project.validate()) {
            project.save()
            respond project
        } else {
            respond project.errors
        }

    }
}
