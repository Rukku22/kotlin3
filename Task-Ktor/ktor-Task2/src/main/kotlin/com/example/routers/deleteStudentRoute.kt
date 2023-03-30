package com.example.routers

import com.example.model.Student
import com.example.service.StudentService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.delete() {
    val service = StudentService()
    routing {
        authenticate("auth-basic") {
            delete("/delete") {
                val params = call.receive<Student>()
                 val no = service.deleteById1(params)
                 if (no==0)
                    call.response.status(HttpStatusCode(418, "Ur Id is not there in table.."))
                else
                    call.respond(status =HttpStatusCode.OK,"sucessfully inserted")
            }
        }
    }
}
