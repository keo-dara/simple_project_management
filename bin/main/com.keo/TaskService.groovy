package com.keo

import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic

@CompileStatic
class TaskService {

    def doSomething() {

    }

    @Transactional
    static class AuthService {

        def serviceMethod() {

        }
    }
}