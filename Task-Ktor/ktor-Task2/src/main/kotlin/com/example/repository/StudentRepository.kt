package com.example.repository

import com.example.databaseconfig.Databasefactory
import com.example.entity.Students
import com.example.model.Student
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class StudentRepository {
    //save data........
    suspend fun savedata(params: Student): Int {
        return Databasefactory.dbQuery {

            Databasefactory.getConnection().insert(Students) {
                set(it.id, params.id)
                set(it.name, params.name)
                set(it.gender, params.gender)
                set(it.number, params.number)
                set(it.city, params.city)
                set(it.state, params.state)
                set(it.country, params.country)
                set(it.pincode, params.pincode)
            }
        }
    }
    // get all data....
    suspend fun gettotal(): List<Student> {
        return Databasefactory.getConnection().from(Students).select().map { row -> Students.createEntity(row) }
            .map {
                Student(
                    it.id,
                    it.name,
                    it.gender,
                    it.number,
                    it.city,
                    it.state,
                    it.country,
                    it.pincode
                )
            }
    }

    //get data with id.........
    suspend fun getdata(Id: Int,name: String): List<Student> {
        return Databasefactory.getConnection().from(Students).select().where { (Students.id eq Id) or (Students.name eq name) }
            .map { row -> Students.createEntity(row) }
            .map {
                Student(
                    it.id,
                    it.name,
                    it.gender,
                    it.number,
                    it.city,
                    it.state,
                    it.country,
                    it.pincode
                )
            }
    }
    //get data with name....
    suspend fun getdataWithName(name:String): List<Student> {
        return Databasefactory.getConnection().from(Students).select().where { Students.name eq name }
            .map { row -> Students.createEntity(row) }
            .map {
                Student(
                    it.id,
                    it.name,
                    it.gender,
                    it.number,
                    it.city,
                    it.state,
                    it.country,
                    it.pincode
                )
            }
    }

    //update with id.or name...
    suspend fun updateByNameOrId(param:Student,id1:Int,name1:String): Int {
        return Databasefactory.dbQuery {
            Databasefactory.getConnection().update(Students){
                set(it.name,param.name)
                set(it.gender,param.gender)
                set(it.number,param.number)
                set(it.city,param.city)
                set(it.state,param.state)
                set(it.country,param.country)
                set(it.pincode,param.pincode)
                where { (it.id eq id1) or (it.name eq name1) }
            }

        }
    }
    fun getparamId(id: Int): List<Student> {
        return Databasefactory.getConnection().from(Students).select().where { Students.id eq id }
            .map { row -> Students.createEntity(row) }.map {
                Student(
                    it.id,
                    it.name,
                    it.gender,
                    it.number,
                    it.city,
                    it.state,
                    it.country,
                    it.pincode
                )
            }
    }

    suspend fun deleteById(params: Student): Int {
        return Databasefactory.dbQuery {
            Databasefactory.getConnection().delete(Students) {
                it.id eq params.id
            }
        }
    }

    suspend fun getQueryParameter(Id: Int, name: String): List<Student> {
        return Databasefactory.getConnection().from(Students).select(Students.id, Students.name)
            .where { (Students.id eq Id) or (Students.name eq name) }
            .map { row -> Students.createEntity(row) }.map {
                Student(
                    it.id,
                    it.name,
                    it.gender,
                    it.number,
                    it.city,
                    it.state,
                    it.country,
                    it.pincode
                )
            }
    }

    fun getparamName(name: String): List<Student> {
        return Databasefactory.getConnection().from(Students).select().where { Students.name eq name }
            .map { row -> Students.createEntity(row) }.map {
                Student(
                    it.id,
                    it.name,
                    it.gender,
                    it.number,
                    it.city,
                    it.state,
                    it.country,
                    it.pincode
                )
            }
    }

}








