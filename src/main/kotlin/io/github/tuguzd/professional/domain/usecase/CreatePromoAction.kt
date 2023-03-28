package io.github.tuguzd.professional.domain.usecase

import io.github.tuguzd.professional.domain.model.PostPromoAction
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.model.PutPromoAction
import io.github.tuguzd.professional.domain.repository.PromoActionRepository

class CreatePromoAction(private val repository: PromoActionRepository) {
    suspend fun postPromoAction(body: PostPromoAction): PromoActionId {
        val putPromoAction = PutPromoAction(
            body.name, body.description.orEmpty(),
        )
        val newPromoAction = repository.create(putPromoAction)
        return newPromoAction.id
    }
}
