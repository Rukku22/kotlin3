package com.example

import com.example.databaseconfig.Databasefactory
import com.example.model.Student
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.routers.SaveData
import com.example.routers.configureRouting
import com.example.routers.delete
import com.example.routers.updatedata
import io.ktor.server.auth.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
 import org.ktorm.database.Database

@Suppress
fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
var connection: Database? = null

fun Application. main() {

    install(Authentication) {
        basic("auth-basic") {
            realm = "Access to the '/' path"
            validate { credentials ->
                if (credentials.name == "admin" && credentials.password == "admin") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
    install(DefaultHeaders) {
        header("name", "admin")
        header("password","admin")
    }
    install(RequestValidation) {
        validate<Student> { student ->
            if (student.id < 0)
                ValidationResult.Invalid("A customer ID should be greater than 0")
             else ValidationResult.Valid
        }

    }

    configureSerialization()
    SaveData()
    updatedata()
    configureRouting()
    delete()
     connection = Databasefactory.init()





}


