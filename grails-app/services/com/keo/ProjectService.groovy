package com.keo


class ProjectService {

    def create() {
        def p = new Project(name: 'App', description: 'wow').save()
        return  p
    }
    
    def list() {
        def plist = Project.list()
        return  plist
    }
}