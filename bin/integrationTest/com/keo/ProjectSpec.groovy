package com.keo


import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.springframework.beans.factory.annotation.*

import com.keo.*

@Integration
@Rollback
class ProjectSpec extends Specification {


    @Autowired
    ProjectService projectService

    @Autowired
    AuthService authService


    void "test create project"() {
        when: "a new project is created"
        def user = authService.save("admin", "password")
//        def u = authService.get("admin")
//        def p = projectService.create("App","wow", u.id)
//
        then:
        user.username == "admin"
//        p.description == "wow"
    }
//
//    void "test delete project"() {
//        when: "a new project is created"
//        def p = projectService.create("App 2", "Wow")
//        def old_count = projectService.count()
//        projectService.delete(p.id.toInteger())
//        def new_count = projectService.count()
//        then:
//        new_count == old_count - 1
//    }
}
