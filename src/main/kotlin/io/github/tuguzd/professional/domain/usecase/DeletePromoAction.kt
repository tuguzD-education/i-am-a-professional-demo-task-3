package io.github.tuguzd.professional.domain.usecase

import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.repository.PromoActionRepository

class DeletePromoAction(private val repository: PromoActionRepository) {
    suspend fun deletePromoAction(id: PromoActionId) {
        repository.delete(id)
    }
}
