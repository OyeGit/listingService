package com.luxesoft

import com.luxesoft.model.task.FakeTaskRepository
import com.luxesoft.model.task.PostgresTaskRepository
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

