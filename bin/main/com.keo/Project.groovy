package com.keo

class Project {

    String name
    String description
    Date startDate
    Date endDate

    static  belongsTo = [manager: User]

    static constraints = {
        name: nullable: false
        description: nullable: false
        startDate blank: true, nullable: true
        endDate blank: true, nullable: true
        manager blank: true, nullable: true
    }
}