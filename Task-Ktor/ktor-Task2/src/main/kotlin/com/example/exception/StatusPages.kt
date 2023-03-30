package com.example.exception


import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.statusPages(){
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, status ->
            call.respondText(text = "404: Page Not Found", status = status)
        }
        status(HttpStatusCode.BadRequest) { call, status ->
            call.respondText(text = "400: bad request", status = status)
        }
        status(HttpStatusCode.MethodNotAllowed) { call, status ->
            call.respondText(text = "405:this method is not allowed", status = status)
        }
        status(HttpStatusCode.InternalServerError) { call, status ->
            call.respondText(text = "500:Internal server Error", status = status)
        }


    }

}