package com.keo

import grails.gorm.transactions.Transactional


import org.springframework.stereotype.Service

@Service
@Transactional
class AuthService {

    @Transactional
    def save(String username, String password) {

        def existing = get(username);
        if (existing) {
            return  existing
        }

        def role1 = new Authority(authority:"ROLE_USER").save(flush: true)
        def user1 = new User(username: username, password: password).save(flush: true)
        def userAuthority = UserAuthority.create(user1, role1).save(flush: true)

        if (!userAuthority) {
            log.error "Failed to create UserAuthority"
            return
        }
        return  user1
    }

    def get(String username){
        def u = User.get(username: username)
        return  u
    }
}
