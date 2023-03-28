package io.github.tuguzd.professional.app.api.routes

import io.github.tuguzd.professional.app.api.Promo
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.usecase.RafflePromoAction
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.resources.post
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.rafflePromoAction() {
    val interactor: RafflePromoAction by inject()

    /** Проведение розыгрыша призов в промоакции по идентификатору промоакции,
     * которое возможно только в том случае, когда
     * количество участников и призов в промоакции совпадает. */
    post<Promo.Id.Raffle> {
        val id = PromoActionId(it.parent.promoId)
        try {
            val results = interactor.postRaffleResult(id)
            call.respond(HttpStatusCode.OK, results)
        } catch (e: RafflePromoAction.Exception) {
            call.respond(HttpStatusCode.Conflict)
        }
    }
}
