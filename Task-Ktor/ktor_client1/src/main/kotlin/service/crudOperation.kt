
  import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
 import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
  import org.slf4j.LoggerFactory
  import service.Student

 object Client1 {
     val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            gson()
        }


//...........
        install(Auth) {
            basic {
                credentials {
                    BasicAuthCredentials(username = "admin", password = "admin")
                }
                realm = "Access to the '/' path"
            }
        }
    }

    //insert data.....
    suspend fun saveData(body: Student):List<Student> {
        val log: org.slf4j.Logger = LoggerFactory.getLogger(javaClass)
        log.info("insert body$body")
        val insert: HttpResponse = client.post("http://localhost:9092/insertdata") {
            contentType(ContentType.Application.Json)
            setBody(body)
        }
        return insert.body() as List<Student>
    }

    //get data
    suspend fun getData():  List<Student> {
        val getdata: HttpResponse = client.get("http://localhost:9092/studentAllDetails") {
            contentType(ContentType.Application.Json)
         }
        return getdata.body() as List<Student>
    }

    //update with id/name/request body....
    suspend fun update(params: Student): List<Student> {
        val update: HttpResponse = client.put("http://localhost:9092/update") {
            contentType(ContentType.Application.Json)
            setBody(params)
        }
        return update.body() as List<Student>
    }

    //path parameter with id.......
    suspend fun pathParameterId():List<Student> {
        val path: HttpResponse = client.get("http://localhost:9092/param") {
            contentType(ContentType.Application.Json)
            url {
                parameters.append("id", "2")
            }
        }
        return path.body() as List<Student>

    }

    //path parameter with name...
    suspend fun pathParameterName(): List<Student> {
        val path: HttpResponse = client.get("http://localhost:9092/getdataWithName") {
            contentType(ContentType.Application.Json)

            url {
                parameters.append("name", "ruksana")
            }
        }
        return path.body() as List<Student>

    }
    //path parameter with id and name
    suspend fun pathParamNameId():List<Student>{
        val path1: HttpResponse = client.get("http://localhost:9090/getwithNameorId") {
             contentType(ContentType.Application.Json)
            url {
                parameters.append("id", "1")

                parameters.append("name", "ruksana")
            }
        }
        return path1.body() as List<Student>

    }


    //query parameter with id and name...
    suspend fun queryParameterIdName():List<Student> {
        val query1: HttpResponse = client.get("http://localhost:9090/student") {
            contentType(ContentType.Application.Json)
        }
        return query1.body() as List<Student>
    }

    //query parameter with name...
    suspend fun queryParamWithName():List<Student> {
        val query2: HttpResponse = client.get("http://localhost:9090/getWithName") {
            contentType(ContentType.Application.Json)

        }
        return query2.body() as List<Student>

    }
}

