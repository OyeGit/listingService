package com.luxesoft

import com.luxesoft.model.MySQLTaskRepository
import com.luxesoft.model.task.FakeTaskRepository
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val repository = FakeTaskRepository()
    configureSerialization(repository)
    configureDatabases()
    configureRouting()

}

