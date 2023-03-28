package io.github.tuguzd.professional.app.api.routes

import io.github.tuguzd.professional.app.api.Promo
import io.github.tuguzd.professional.domain.model.PostParticipant
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.usecase.CreateParticipant
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.post
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.createParticipant() {
    val interactor: CreateParticipant by inject()

    /** Добавление участника в промоакцию по идентификатору промоакции. */
    post<Promo.Id.Participant> {
        val promoId = PromoActionId(it.parent.promoId)
        val body = call.receive<PostParticipant>()
        val id = interactor.postParticipant(promoId, body)
        call.respond(HttpStatusCode.Created, id.value)
    }
}
