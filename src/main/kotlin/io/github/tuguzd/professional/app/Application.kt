@file:Suppress("unused")

package io.github.tuguzd.professional.app

import io.github.tuguzd.professional.app.api.configureRoutes
import io.github.tuguzd.professional.app.di.configureDI
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    configureDI()
    configureRoutes()
}
