package io.github.tuguzd.professional.app.api.routes

import io.github.tuguzd.professional.app.api.Promo
import io.github.tuguzd.professional.domain.model.PostPromoAction
import io.github.tuguzd.professional.domain.usecase.CreatePromoAction
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.resources.post
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.createPromoAction() {
    val interactor: CreatePromoAction by inject()

    /**
     * Добавление промоакции с возможностью указания названия (name), описания (description).
     * Описание – не обязательный параметр, название – обязательный.
     */
    post<Promo> {
        val body = call.receive<PostPromoAction>()
        val id = interactor.postPromoAction(body)
        call.respond(HttpStatusCode.Created, id.value)
    }
}
