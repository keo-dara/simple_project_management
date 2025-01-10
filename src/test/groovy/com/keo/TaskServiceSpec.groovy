package com.keo

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class TaskServiceSpec extends Specification implements ServiceUnitTest<TaskService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
