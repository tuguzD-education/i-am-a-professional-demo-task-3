package io.github.tuguzd.professional.domain.repository

import io.github.tuguzd.professional.domain.model.PostPrize
import io.github.tuguzd.professional.domain.model.PrizeId
import io.github.tuguzd.professional.domain.model.PromoActionId

interface PrizeRepository {
    suspend fun create(promoId: PromoActionId, new: PostPrize): PrizeId

    suspend fun delete(promoId: PromoActionId, prizeId: PrizeId)
}
