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
            return existing
        }

        def role = createOrFindRole()
        def user1 = new User(username: username, password: password).save()
        def userAuthority = UserAuthority.create(user1, role).save(flush: true)

        if (!userAuthority) {
            log.error "Failed to create UserAuthority"
            return
        }
        return  user1
    }

    def get(String username){
        def u = User.findWhere(username: username)
        return  u
    }

    def createOrFindRole() {

        def r = Authority.findWhere(authority: "ROLE_USER")

        if (!r) {
            r = new Authority(authority: "ROLE_USER").save()
        }

        return r

    }
}
