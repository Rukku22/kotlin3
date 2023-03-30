package com.example.plugins

import com.example.Customer
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    val customerStorage = mutableListOf<Customer>()
    customerStorage.addAll(
        arrayOf(
            Customer(1, "Jane", "Smith"),
            Customer(2, "John", "Smith"),
            Customer(3, "Jet", "Brains")
        )
    )
    routing {
        get("/customer/{id}") {
            val id = call.parameters["id"]
            val customer: Customer = customerStorage.find { it.id == id!!.toInt() }!!
            call.respond(customer)
        }

        delete("/customer/{id}") {
            val id = call.parameters["id"]
            customerStorage.removeIf { it.id == id!!.toInt() }
            call.respondText("Customer id  is removed", status = HttpStatusCode.NoContent)
        }
        get("/getdata") {
            val data=customerStorage.size
            call.respond(data)
        }
        get("/hello") {
            val uri = call.request.uri
            call.respondText("Request uri: $uri")
        }
    }
}
