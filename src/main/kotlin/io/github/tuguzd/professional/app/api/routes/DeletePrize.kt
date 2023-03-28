package io.github.tuguzd.professional.app.api.routes

import io.github.tuguzd.professional.app.api.Promo
import io.github.tuguzd.professional.domain.model.PrizeId
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.usecase.DeletePrize
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.deletePrize() {
    val interactor: DeletePrize by inject()

    /** Удаление приза из промоакции по идентификаторам промоакции и приза. */
    delete<Promo.Id.Prize.Id> {
        val promoId = PromoActionId(it.parent.parent.promoId)
        val prizeId = PrizeId(it.prizeId)
        interactor.deletePrize(promoId, prizeId)
        call.respond(HttpStatusCode.NoContent)
    }
}
