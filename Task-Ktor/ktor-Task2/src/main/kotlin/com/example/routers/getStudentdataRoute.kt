package com.example.routers

import com.example.entity.Students.id
import com.example.model.Student
import com.example.service.StudentService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun Application.configureRouting() {
    val log: Logger = LoggerFactory.getLogger(javaClass)

    val service = StudentService()
    routing {
        authenticate("auth-basic") {

               // get all data........
                get("/studentAllDetails") {
                    call.respond(service.getTotalData())
                }
                //get data with id.........
                get("/studentsWithrequestbody") {
                    val student = call.receive<Student>()
                    val name = student.name ?: toString()
                    val id = student.id.toInt() ?: "0".toInt()
                    val students = service.getdata(id, name)
                    if (students != null) {
                        if (students.size > 0)
                            call.respond(students)
                        else
                            call.respond("no student found with this details")
                    }
                }
                //get data with name...
                get("/getdataWithName") {
                    var name = call.parameters["name"].toString()
                    var data = service.getdataWithName(name)
                    if (data.equals(0)) {
                        call.respond(HttpStatusCode(404, "not found ur name data"))
                    } else
                        call.respond(data)
                }
//get data with id and name...
                get("/getwithNameorId") {
                    var id = call.parameters["id"]?.toInt()
                    var name = call.parameters["name"].toString()
                    var data2 = id?.let { it1 -> service.getdata(it1, name) }
                    if (data2 != null) {
                        call.respond(data2)
                    } else {
                        call.respond(status = HttpStatusCode.InternalServerError, "something went wrong")

                    }
                }

                //path parameter.......
                get("/param") {
                    var id = Integer.parseInt(call.parameters["id"])
                    var param = service.paramId(id)
                    if (id > 0) {
                        call.respond(param)
                    } else {
                        call.respond(status = HttpStatusCode.InternalServerError, "something went wrong")
                    }
                }
            }
            //query param...........
            get("/student") {
                var id = call.request.queryParameters["id"]?.toInt()
                var name = call.request.queryParameters["name"].toString()
                println("name $name")
                val data = id?.let { it1 -> service.queryParameter(id, name) }
                if (data != null) {
                    call.respond("$data")

                } else {
                    call.respond(status = HttpStatusCode.BadRequest, "something went wrong")

                }
            }
            get("/getWithName") {
                var name = call.request.queryParameters["name"]
                var param = name?.let { it1 -> service.queryParameterName(it1) }
                if (param != null) {
                    call.respond(param)
                } else {
                    call.respond(status = HttpStatusCode.BadRequest, "something went wrong")
                }
            }
        }

    }





