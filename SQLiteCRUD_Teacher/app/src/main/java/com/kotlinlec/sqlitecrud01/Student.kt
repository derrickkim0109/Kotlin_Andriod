package com.kotlinlec.sqlitecrud01

class Student(code: String, name: String, dept: String , phone: String){

    var code: String? = null
    var name: String? = null
    var dept: String? = null
    var phone: String? = null

    init {
        this.code = code
        this.name = name
        this.dept = dept
        this.phone = phone
    }

}