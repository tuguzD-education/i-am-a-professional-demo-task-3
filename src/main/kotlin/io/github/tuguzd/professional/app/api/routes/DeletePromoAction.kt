package io.github.tuguzd.professional.app.api.routes

import io.github.tuguzd.professional.app.api.Promo
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.usecase.DeletePromoAction
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.deletePromoAction() {
    val interactor: DeletePromoAction by inject()

    /** Удаление промоакции по идентификатору */
    delete<Promo.Id> {
        val promoId = PromoActionId(it.promoId)
        interactor.deletePromoAction(promoId)
        call.respond(HttpStatusCode.NoContent)
    }
}
