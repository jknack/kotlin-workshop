package nerdearla

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.jooby.*
import org.jooby.json.Jackson
import java.util.concurrent.ConcurrentHashMap

data class Todo(var id: Int?, val name: String, val done: Boolean = false)

/**
 * TODO API:
 */
class App : Kooby({

  use(Jackson(jacksonObjectMapper()))
  val todos = ConcurrentHashMap<Int, Todo>()

  route("/api/todo") {

    get { -> todos.values.toList() }

    post {->
      val todo = body<Todo>()
      // set id
      val nextId = todos.size + 1
      todo.id = nextId

      // save
      todos[nextId] = todo

      todo
    }

    get ("/:id") {->
      val id = param<Int>("id")
      todos[id] ?: throw Err(404)
    }

    put {->
      val todo = body<Todo>()
      // id
      val id = todo.id ?: throw Err(400)
      // update
      todos[id] ?: throw Err(404)

      todos[id] = todo

      todo
    }

    delete ("/:id") {->
      val id = param<Int>("id")
      todos.remove(id) ?: throw Err(404)
      Results.noContent()
    }
  }
})

fun main(args: Array<String>) {
  run(::App, *args)
}

