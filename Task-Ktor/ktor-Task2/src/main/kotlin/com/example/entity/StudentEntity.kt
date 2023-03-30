package com.example.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Student : Entity<Student> {
    val id: Int
    var name: String
    var gender: String
    var number: String
    var city: String
    var state: String
    var country: String
    var pincode: String
}
    object Students : Table<Student>("studentnew") {
        var id = int("id").primaryKey().bindTo { it.id }
        var name = varchar("name").bindTo { it.name }
        var gender = varchar("gender").bindTo { it.gender }
        var number = varchar("number").bindTo { it.number }
        var city = varchar("city").bindTo { it.city }
        var state = varchar("state").bindTo { it.state }
        var country = varchar("country").bindTo { it.country }
        var pincode = varchar("pincode").bindTo { it.pincode }

}

