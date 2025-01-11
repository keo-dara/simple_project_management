grails.plugin.springsecurity.rest.token.storage.memcached.password = ''
grails.plugin.springsecurity.rest.token.storage.memcached.expiration = 86400

grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.keo.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.keo.UserAuthority'
grails.plugin.springsecurity.authority.className = 'com.keo.Authority'
grails.plugin.springsecurity.rest.token.storage.jwt.secret = 'pleaseChangeThisSecretForANewOne'

grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"

grails.plugin.springsecurity.interceptUrlMap = [
        [pattern: '/api/**', access: ['IS_AUTHENTICATED_FULLY']],
        [pattern: '/**',          access: ['IS_AUTHENTICATED_ANONYMOUSLY']]
]


grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/api/**', filters: 'JOINED_FILTERS,-exceptionTranslationFilter'],
        [pattern: '/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
]


grails.plugin.springsecurity.rest.logout.endpointUrl = '/api/logout'
grails.plugin.springsecurity.rest.validate.endpointUrl = '/api/validate'
grails.plugin.springsecurity.rest.token.validation.useBearerToken = true
grails.plugin.springsecurity.rest.token.validation.enableAnonymousAccess = false
grails.plugin.springsecurity.rest.login.active = true
grails.plugin.springsecurity.password.hashing.bcrypt.logRounds = 10 // Adjust log rounds as needed
grails.plugin.springsecurity.password.algorithm = 'bcrypt'
grails.plugin.springsecurity.rest.token.storage.useGorm = true
grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = 'com.keo.AuthenticationToken'
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.rest.token.storage.jwt.expiration = 3600 * 24 * 30
grails.gorm.default.mapping = {
    '*'(cascadeValidate: 'dirty')
}
