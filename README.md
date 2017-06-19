# Kotlin workshop con Jooby

[Kotlin](http://kotlinlang.org/) web application workshop utlizando [Jooby](http://jooby.org) para [nerdear.la 2017](https://nerdear.la).

En este workshop vamos a crear un JSON API para una lista de tareas/pendientes (TODO items).

El workshop esta diseñado como una serie de ejercicios a completar/implementar.

Para cada ejercicio existe un [test](test/kotlin/nerdearla/WorkshopSpek.kt) que determina si el ejercicio fue completado de forma satisfactoria(success) o no (failure).

## instalar previamente

* Java 8
* Maven 3
* IDE: Intellij, Eclipse con Kotlin plugin o editor de texto.

## conocimiento básico sobre

* [Jooby](http://jooby.org)
* [Kotlin](http://kotlinlang.org/)
* [Maven](https://maven.apache.org/)

## Ejercicio: HTTP JSON API

- Implementar un HTTP API de modo tal que:
  - Formato sea `JSON`. Utilizar el modulo: [Jackson](http://jooby.org/doc/jackson)
  - `GET /api/todo`:
    - Liste todos los TODO items
  - `POST /api/todo`:
     - Reciba un TODO item en el body del mensaje HTTP, ej: `{"name": "Learn Kotlin"}`
     - Asigne un ID y guarde el TODO item
     - Retorne el TODO item guardado
  - `GET /api/todo/:id`
     - Retorne un TODO item utilizando el ID, o
     - `404` si el TODO item no existe
  - `PUT /api/todo`:
     - Reciba un TODO item en el body del mensaje HTTP
     - Actualize el TODO item con la nueva información y retorne el TODO item actualizado, o
     - `404` si el TODO item no existe
  -  `DELETE /api/todo/:id`
     - Retorne 204 (No content) para ID validos, o
     - `404` si el TODO item no existe

El ciclo de vida del proyecto esta a cargo de [Maven](https://maven.apache.org/) y el mismo contiene todas las dependencias necesarias para ejecutar el proyecto.

## validando el ejercicio

Para validar el ejercicio necesitas abrir una consola y ejecutar

    mvn clean test

En la consola aparecera un mensaje similar a este:

```
[INFO] Results:
[INFO]
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```

## ayuda

* [Jooby Kotlin module](http://jooby.org/doc/lang-kotlin)
* [Jooby](http://jooby.org/doc)

El ejercicio completo se encuentra en el branch `final`.

## ejercicio adicionales

* Imprimir "neardear.la" utilizando ascii art banners.

