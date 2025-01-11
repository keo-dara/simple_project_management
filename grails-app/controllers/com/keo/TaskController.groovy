package com.keo


import grails.rest.*
import grails.converters.*

class TaskController extends RestfulController {


    def springSecurityService
    TaskService taskService

    static responseFormats = ['json', 'xml']

    TaskController() {
        super(Project)
    }

    @Override
    def save() {
        def req_body = request.JSON
        def user = springSecurityService.currentUser
        def project_id = req_body["projectId"]

        if (!project_id) {
            project_found()
            return
        }

        def project = Project.findWhere(id:
                Long.parseLong(project_id.toString()))

        if (!project) {
            project_found()
            return
        }

        def task = new Task(req_body)
        task.by = user
        task.status = Status.NOT_START
        task.project = project


        if (task.validate()) {
            def t = taskService.save(task)
            respond t
        } else {
            respond task.errors
        }

    }

    def project_found() {
        render status: 404, text: "Project ID not found"
    }
}
