package com.keo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AuthenticationTokenSpec extends Specification implements DomainUnitTest<AuthenticationToken> {

     void "test domain constraints"() {
        when:
        AuthenticationToken domain = new AuthenticationToken()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
