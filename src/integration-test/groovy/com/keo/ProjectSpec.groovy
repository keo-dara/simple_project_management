package com.keo


import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.springframework.beans.factory.annotation.*
import org.springframework.beans.factory.annotation.Qualifier

import com.keo.*

@Integration
@Rollback
class ProjectSpec extends Specification {


    @Autowired
    ProjectService projectService

    def setup() {
    }

    def cleanup() {
    }

    void "test create project"() {
        when: "a new project is created"
        def p = projectService.create()

        then:
        p.name == "App"
        p.description == "wow"
    }
}
