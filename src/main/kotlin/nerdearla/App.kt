package nerdearla

import org.jooby.*

/**
 * TODO API:
 */
class App : Kooby({

  get {
    "Hola neardear.la"
  }

})

fun main(args: Array<String>) {
  run(::App, *args)
}

