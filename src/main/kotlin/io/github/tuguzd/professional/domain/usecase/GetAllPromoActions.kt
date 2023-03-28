package io.github.tuguzd.professional.domain.usecase

import io.github.tuguzd.professional.domain.model.GetPromoAction
import io.github.tuguzd.professional.domain.repository.PromoActionRepository

class GetAllPromoActions(private val repository: PromoActionRepository) {
    suspend fun getAllPromoActions(): List<GetPromoAction> {
        val summary = repository.getAll().map {
            GetPromoAction(
                id = it.id, name = it.name,
                description = it.description,
            )
        }
        return summary
    }
}
