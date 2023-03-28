package io.github.tuguzd.professional.app.api.routes

import io.github.tuguzd.professional.app.api.Promo
import io.github.tuguzd.professional.domain.model.PostPrize
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.usecase.CreatePrize
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.post
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.createPrize() {
    val interactor: CreatePrize by inject()

    /** Добавление приза в промоакцию по идентификатору промоакции. */
    post<Promo.Id.Prize> {
        val promoId = PromoActionId(it.parent.promoId)
        val body = call.receive<PostPrize>()
        val id = interactor.postPrize(promoId, body)
        call.respond(HttpStatusCode.Created, id.value)
    }
}
