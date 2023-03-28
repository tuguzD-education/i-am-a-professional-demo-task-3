package io.github.tuguzd.professional.domain.usecase

import io.github.tuguzd.professional.domain.model.PromoAction
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.repository.PromoActionRepository

class GetPromoActionById(private val repository: PromoActionRepository) {
    suspend fun getPromoAction(id: PromoActionId): PromoAction? {
        return repository.getById(id)
    }
}
