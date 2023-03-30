package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        get("/hh") {
            call.respondText("Hello World!")
            var a=10
            a=20
            println(a)
         }
    }
}
