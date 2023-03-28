package io.github.tuguzd.professional.app.api.routes

import io.github.tuguzd.professional.app.api.Promo
import io.github.tuguzd.professional.domain.model.ParticipantId
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.usecase.DeleteParticipant
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.deleteParticipant() {
    val interactor: DeleteParticipant by inject()

    /** Удаление участника из промоакции по идентификаторам промоакции и участника. */
    delete<Promo.Id.Participant.Id> {
        val promoId = PromoActionId(it.parent.parent.promoId)
        val participantId = ParticipantId(it.participantId)
        interactor.deleteParticipant(promoId, participantId)
        call.respond(HttpStatusCode.NoContent)
    }
}
