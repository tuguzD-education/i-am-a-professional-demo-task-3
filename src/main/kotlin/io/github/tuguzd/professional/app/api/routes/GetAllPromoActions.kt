package io.github.tuguzd.professional.app.api.routes

import io.github.tuguzd.professional.app.api.Promo
import io.github.tuguzd.professional.domain.usecase.GetAllPromoActions
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllPromoActions() {
    val interactor: GetAllPromoActions by inject()

    /**
     * Получение краткой информации (без информации об
     * участниках и призах) обо всех промоакциях.
     */
    get<Promo> {
        val summary = interactor.getAllPromoActions()
        call.respond(HttpStatusCode.OK, summary)
    }
}
