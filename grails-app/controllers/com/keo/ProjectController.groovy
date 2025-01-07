package com.keo


class ProjectController {

    def projectService

	static responseFormats = ['json', 'xml']

    def index() {

        def result = projectService.list()

        respond result
    }
}
