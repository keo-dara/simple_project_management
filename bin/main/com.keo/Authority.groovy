package com.keo


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Authority implements Serializable {

    private static final long serialVersionUID = 1

    String authority

    static constraints = {
        authority blank: false, unique: true
    }

    static mapping = {
        cache true
    }
}