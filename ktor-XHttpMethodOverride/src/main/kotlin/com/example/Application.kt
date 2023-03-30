package com.example

import com.example.plugins.configureRouting
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.methodoverride.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
      configureRouting()

     install(XHttpMethodOverride)
     install(ContentNegotiation) {
          gson{}
     }

}
