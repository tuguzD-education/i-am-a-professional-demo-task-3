package io.github.tuguzd.professional.domain.usecase

import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.model.PutPromoAction
import io.github.tuguzd.professional.domain.repository.PromoActionRepository

class UpdatePromoAction(private val repository: PromoActionRepository) {
    suspend fun putPromoAction(id: PromoActionId, body: PutPromoAction) {
        repository.update(id, body)
    }
}
