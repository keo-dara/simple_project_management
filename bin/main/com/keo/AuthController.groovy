package com.keo


import grails.rest.*
import grails.converters.*

class AuthController {
	static responseFormats = ['json', 'xml']

    AuthService authService

    def save() {
        def requestBody = request.JSON
        def user = new User(requestBody)

        if (user.validate()) {
            def p = authService.save(user.username, user.password)
            respond p
        } else {
            respond project.errors
        }
    }
}
