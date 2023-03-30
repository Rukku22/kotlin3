
 import Client1.getData
 import Client1.pathParamNameId
 import Client1.pathParameterId
 import Client1.pathParameterName
 import Client1.queryParamWithName
 import Client1.queryParameterIdName
 import Client1.saveData
 import Client1.update
 import service.Student
 import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
 import org.slf4j.Logger
 import org.slf4j.LoggerFactory

 fun Application.insertData() {
     val log: Logger = LoggerFactory.getLogger(javaClass)

     routing {
         post("/insert") {
            var body = call.receive<Student>()
            var data = saveData(body)
                  log.info("insert data:$body")

        }
        get ("/getdata"){
            var totaldata= getData()
                   call.respond(totaldata)
            log.info("get all data:$totaldata")
        }
        put ("/update"){
            var data=call.receive<Student>()
            call.respond(update(data))
            log.info("update data with id/name:$data")

        }
        //path  parameter
        get("/paramid") {
            var data=pathParameterId()
            log.info("param data with id:$data")
            call.respond(data)
        }
        get("/paramname") {
            var data=pathParameterName()
             call.respond(data)
            log.info("param data with name:$data")
        }
        get("/paramidname") {
            var data=pathParamNameId()
             call.respond(data)
            log.info("param data with id & name:$data")
        }
        //query parameter.....
        get ("/queryidname"){

        var data1=queryParameterIdName()
             call.respond(data1)
            log.info("query param data with id &name:$data1")

        }
        get ("/queryid"){

            var data1=queryParamWithName()
            log.info("query param data with name:$data1")
            call.respond(data1)

        }
    }


}