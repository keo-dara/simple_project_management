package com.keo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AuthoritySpec extends Specification implements DomainUnitTest<Authority> {

     void "test domain constraints"() {
        when:
        Authority domain = new Authority()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
