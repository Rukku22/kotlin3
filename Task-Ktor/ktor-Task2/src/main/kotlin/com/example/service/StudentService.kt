package com.example.service

import com.example.model.Student
import com.example.repository.StudentRepository

class StudentService {
    private val repo = StudentRepository()
    suspend fun save(params: Student): Int {

        return repo.savedata(params)
    }

    suspend fun UpdateStudentsDataId(param:Student,id1:Int,name1:String): Int {
        return repo.updateByNameOrId(param,id1,name1)
    }

    suspend fun getdata(Id: Int,name:String): List<Student> {
        return repo.getdata(Id,name)
    }

    suspend fun deleteById1(params: Student): Int {
        return repo.deleteById(params)
    }
    suspend fun getTotalData():List<Student>{
        return repo.gettotal()
    }

   suspend fun paramId(Id: Int): List<Student> {
       return repo.getparamId(Id)
    }

 suspend fun  queryParameter(Id:Int, name: String): List<Student> {
     return repo.getQueryParameter(Id,name)
 }
    suspend fun  queryParameterName(name: String): List<Student> {
        return repo.getparamName(name)
    }
    suspend fun getdataWithName(name: String):List<Student>{
        return repo.getdataWithName(name)
    }

}

