package io.github.tuguzd.professional.app.api.routes

import io.github.tuguzd.professional.app.api.Promo
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.usecase.GetPromoActionById
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getPromoActionById() {
    val interactor: GetPromoActionById by inject()

    /**
     * Получение полной информации (с информацией об
     * участниках и призах) о промоакции по идентификатору.
     */
    get<Promo.Id> {
        val promoId = PromoActionId(it.promoId)

        when (val promoAction = interactor.getPromoAction(promoId)) {
            null -> call.respond(HttpStatusCode.NotFound)
            else -> call.respond(HttpStatusCode.OK, promoAction)
        }
    }
}
