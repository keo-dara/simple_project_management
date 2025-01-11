package com.keo


import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.springframework.beans.factory.annotation.*

@Integration
@Rollback
class ProjectSpec extends Specification {


    @Autowired
    ProjectService projectService

    @Autowired
    AuthService authService

    User u

    def setup() {
        u = authService.save("admin2", "12345678")
    }

    void "test create project"() {
        when: "a new project is created"
        def p = projectService.create("App","wow", u)

        then:
        u.username == "admin2"
        p.name == "App"
        p.description == "wow"
    }

    void "test delete project"() {
        when: "a new project is created"
        def p = projectService.create("App 2", "Wow", u)
        def old_count = projectService.count()
        projectService.delete(p.id.toInteger())
        def new_count = projectService.count()
        then:
        new_count == old_count - 1
    }
}
