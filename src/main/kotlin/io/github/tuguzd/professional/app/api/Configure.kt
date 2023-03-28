package io.github.tuguzd.professional.app.api

import io.github.tuguzd.professional.app.api.routes.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.resources.*
import io.ktor.server.routing.*

fun Application.configureRoutes() {
    install(ContentNegotiation) {
        json()
    }
    install(Resources)

    routing {
        routes()
        openAPI(path = "openapi")
        swaggerUI(path = "swagger")
    }
}

fun Route.routes() {
    createPromoAction()
    getAllPromoActions()
    getPromoActionById()
    updatePromoAction()
    deletePromoAction()

    createPrize()
    deletePrize()

    createParticipant()
    deleteParticipant()

    rafflePromoAction()
}
