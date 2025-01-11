package com.keo

import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic

@CompileStatic
class TaskService {

    Task save(Task task, User user, Project project) {
        task.by = user
        task.project = project
        task.save()
        return task
    }

}