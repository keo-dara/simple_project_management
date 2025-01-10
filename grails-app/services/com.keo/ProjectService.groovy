package com.keo

import grails.gorm.transactions.Transactional

import org.springframework.stereotype.Service

@Service
@Transactional
class ProjectService {

    def create(String name, String description) {
        def p = new Project(name: name, description: description).save()
        return  p
    }
    
    def list(params) {
        return [data: Project.list(params), count: Project.count()]
    }

    def delete(int id) {
        def p = findOne(id)
        p.delete()
        return  p
    }

    def findOne(int id) {
        return Project.get(id)
    }

    @Transactional
    def update(int id, body, user) {
        def p = Project.findById(id)

        if (!p) {
            return null
        }

        p.properties = body

        if (p.validate()) {
            return p.save(flush:  true)
        } else {
            println("Failed to update project. Errors: ${p.errors.allErrors}")
            return p.errors
        }

    }
}