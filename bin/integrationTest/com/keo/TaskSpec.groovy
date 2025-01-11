package com.keo


import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class TaskSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }

    @Integration
    @Rollback
    static class AuthSpec extends Specification {

        @Autowired
        AuthService authService



        void "test create project"() {
            user = authService.save("admin", "password")
            when: "a new project is created"
            def u = authService.get("admin")
    //        def p = projectService.create("App","wow", u.id)
    //
            then:
            u.username == "admin"
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
}
