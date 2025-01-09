package com.keo

class Project {

    String name
    String description
    Date startDate
    Date endDate
    int managerId

    static constraints = {
        name: nullable: false
        description: nullable: false
        managerId: nullable: false
        startDate blank: true, nullable: true
        endDate blank: true, nullable: true
    }
}