package com.keo

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ProjectServiceSpec extends Specification implements ServiceUnitTest<ProjectService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
