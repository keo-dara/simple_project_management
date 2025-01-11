package com.keo



import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.springframework.beans.factory.annotation.*

@Integration
@Rollback
class TaskSpec extends Specification {

    @Autowired
    AuthService authService
    @Autowired
    TaskService taskService
    @Autowired
    ProjectService projectService

    User u

    def setup() {
        u = authService.save("admin2", "12345678")
    }

    void "test new project"() {
        def p = projectService.create("App","wow", u)

        def new_task = new Task(name: "To do", description: "You")

        def t = taskService.save(new_task, u, p)

        expect:"fix me"
        t.name == "To do"
        t.description == "You"
    }

}
