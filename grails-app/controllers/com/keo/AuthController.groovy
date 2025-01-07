package com.keo


import grails.rest.*
import grails.converters.*

class AuthController {
	static responseFormats = ['json', 'xml']
	
    def index() { }

    def save() {


        print("NEW USER CREATED")
        UserAuthority.withTransaction { status ->
            def role1 = new Authority(authority:"ROLE_USER").save()
            def user1 = new User(username:"admin",password:"12345678").save()
            def userAuthority = UserAuthority.create(user1, role1)

            if (!userAuthority) {
                log.error "Failed to create UserAuthority"
                return
            }
        }

        respond UserAuthority.list()


//        respond UserAuthority.create(user1,role1)
    }
}
