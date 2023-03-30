package com.example.routers

import com.example.exception.MissingFieldException
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

fun Application.SaveData() {
    val log: Logger = LoggerFactory.getLogger(javaClass)

    val service = StudentService()
    routing {
        authenticate("auth-basic") {
            post("/insertdata") {
                val data = call.receive<Student>()
                 var data1= service.save(data)
                 if (data1>0) {
                  log.info("insert data :$data")
               call.respond(status =HttpStatusCode.OK,"sucessfully inserted")

                  }
                  else {
                    call.respond(status =HttpStatusCode.BadRequest,"something went wrong not inserted..")

                }
            }
        }
    }
}