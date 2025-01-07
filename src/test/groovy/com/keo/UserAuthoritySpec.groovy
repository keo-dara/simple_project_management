package com.keo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserAuthoritySpec extends Specification implements DomainUnitTest<UserAuthority> {

     void "test domain constraints"() {
        when:
        UserAuthority domain = new UserAuthority()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
