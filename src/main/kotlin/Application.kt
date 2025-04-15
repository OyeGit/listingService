package com.luxesoft

import com.luxesoft.model.MySQLTaskRepository
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val repository = MySQLTaskRepository()
    configureSerialization(repository)
    configureDatabases()
    configureRouting()
}

