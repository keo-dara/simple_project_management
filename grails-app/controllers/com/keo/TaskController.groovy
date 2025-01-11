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

        def project_id = req_body.get("projectId")

        if (!projectId) {
            project_found()
            return
        }

        def project = Project.findWhere({ id:
        projectId })

        if (!project){
            project_found()
            return
        }


        def task = new Task(req_body)


        if (task.validate()) {
            def t = taskService.save(task, user,)
            respond t
        } else {
            respond task.errors
        }

    }

    def project_found() {
        render status: 404, text: "Project ID not found"
    }
}
