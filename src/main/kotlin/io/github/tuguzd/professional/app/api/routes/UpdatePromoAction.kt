package io.github.tuguzd.professional.app.api.routes

import io.github.tuguzd.professional.app.api.Promo
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.model.PutPromoAction
import io.github.tuguzd.professional.domain.usecase.UpdatePromoAction
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.put
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.updatePromoAction() {
    val interactor: UpdatePromoAction by inject()

    /**
     * Редактирование промоакции по идентификатору промоакции.
     * Редактировать можно только свойства name, description.
     * Удалить имя таким образом нельзя, описание – можно.
     */
    put<Promo.Id> {
        val id = PromoActionId(it.promoId)
        val body = call.receive<PutPromoAction>()
        interactor.putPromoAction(id, body)
        call.respond(HttpStatusCode.NoContent)
    }
}
