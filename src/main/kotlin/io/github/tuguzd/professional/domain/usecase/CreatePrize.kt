package io.github.tuguzd.professional.domain.usecase

import io.github.tuguzd.professional.domain.model.PostPrize
import io.github.tuguzd.professional.domain.model.PrizeId
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.repository.PrizeRepository

class CreatePrize(private val repository: PrizeRepository) {
    suspend fun postPrize(id: PromoActionId, body: PostPrize): PrizeId {
        return repository.create(id, body)
    }
}
