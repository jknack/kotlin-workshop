package nerdearla

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import io.restassured.RestAssured.*;
import org.hamcrest.Matchers.*;

class WorkshopSpek: Spek({

  describe("TODO API") {

    /** Start/stop application: */
    val app = App()
    beforeGroup { app.start("server.join=false") }
    afterGroup { app.stop() }

    given("todo items") {
      it("should list all items") {
        get("/api/todo")
            .then()
            .statusCode(200)
            .contentType("application/json")
            .body(equalTo("[]"))
      }

      it("should create a todo item") {
        given()
            .contentType("application/json")
            .body("""{"name": "Learn Kotlin"}""")
            .post("/api/todo")
            .then()
            .statusCode(200)
            .contentType("application/json")
            .body(equalTo("""{"id":1,"name":"Learn Kotlin","done":false}"""))
      }

      it("should get an item by ID") {
        get("/api/todo/1")
            .then()
            .statusCode(200)
            .contentType("application/json")
            .body(equalTo("""{"id":1,"name":"Learn Kotlin","done":false}"""))
      }

      it("should update a todo item") {
        given()
            .contentType("application/json")
            .body("""{"id":1,"name":"Learn Kotlin","done":true}""")
            .put("/api/todo")
            .then()
            .statusCode(200)
            .contentType("application/json")
            .body(equalTo("""{"id":1,"name":"Learn Kotlin","done":true}"""))
      }

      it("should get 404 if we try to update a missing todo item") {
        given()
            .contentType("application/json")
            .body("""{"id":0,"name":"Missing","done":true}""")
            .put("/api/todo")
            .then()
            .statusCode(404)
      }

      it("should get an item by ID") {
        get("/api/todo/1")
            .then()
            .statusCode(200)
            .contentType("application/json")
            .body(equalTo("""{"id":1,"name":"Learn Kotlin","done":true}"""))
      }

      it("should get 404 for invalid items") {
        get("/api/todo/0")
            .then()
            .statusCode(404)
      }

      it("should list all items") {
        get("/api/todo")
            .then()
            .statusCode(200)
            .contentType("application/json")
            .body(equalTo("""[{"id":1,"name":"Learn Kotlin","done":false}]"""))
      }

      it("should delete an item by ID") {
        delete("/api/todo/1")
            .then()
            .statusCode(204)
      }

      it("should get 404 for invalid items") {
        get("/api/todo/1")
            .then()
            .statusCode(404)
      }
    }
  }

})
