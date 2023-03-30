package com.example.routers

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

 fun Application.updatedata() {
    val log: Logger = LoggerFactory.getLogger(javaClass)
    val service = StudentService()
    routing {
        authenticate("auth-basic") {
            put("/update") {
                var params = call.receive<Student>()
                  var id=params.id
                var name=params.name
                var data = service.UpdateStudentsDataId(params,id,name)
                 if (data > 0) {
                     log.info("updata data with id/name:$params")
                     call.respond(status = HttpStatusCode.OK, "sucessfully updated")
                 } else {
                    call.respond(status = HttpStatusCode.BadRequest, "not updated")
                      log.error("not updated")
                }
            }
        }

        }
 }



