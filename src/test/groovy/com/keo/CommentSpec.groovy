package com.keo

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CommentSpec extends Specification implements DomainUnitTest<Comment> {

     void "test domain constraints"() {
        when:
        Comment domain = new Comment()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
