package com.keo

import groovy.transform.CompileStatic


@CompileStatic
enum Status {
    NOT_START(-1),
    IN_PROGRESS(0),
    COMPLETED(1),

    final int id
    private Status(int id) { this.id = id }
}

class Task {

    String name
    String description
    Status status

    static  mapping = {
        status enumType: 'ordinal'
    }

    static constraints = {
        name: nullable: false
        description: nullable: false
        status nullable: false
    }

    static  belongsTo = [by: User, project: Project]
}
