package io.github.tuguzd.professional.domain.usecase

import io.github.tuguzd.professional.domain.model.PrizeId
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.repository.PrizeRepository

class DeletePrize(private val repository: PrizeRepository) {
    suspend fun deletePrize(promoId: PromoActionId, prizeId: PrizeId) {
        repository.delete(promoId, prizeId)
    }
}
