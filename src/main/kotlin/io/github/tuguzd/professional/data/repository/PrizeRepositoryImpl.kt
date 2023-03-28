package io.github.tuguzd.professional.data.repository

import io.github.tuguzd.professional.data.client.RepositoryClient
import io.github.tuguzd.professional.data.model.PrizeEntity
import io.github.tuguzd.professional.data.model.PromoActionEntity
import io.github.tuguzd.professional.domain.model.PostPrize
import io.github.tuguzd.professional.domain.model.PrizeId
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.repository.PrizeRepository

class PrizeRepositoryImpl(
    private val client: RepositoryClient
) : PrizeRepository {
    override suspend fun create(promoId: PromoActionId, new: PostPrize): PrizeId = client.transaction {
        val promo = PromoActionEntity.findById(promoId.value)
        PrizeEntity.new {
            description = new.description
            promoAction = checkNotNull(promo)
        }.toDomain().id
    }

    override suspend fun delete(promoId: PromoActionId, prizeId: PrizeId) = client.transaction {
        val promo = PromoActionEntity.findById(promoId.value)
        checkNotNull(promo)

        val prize = PrizeEntity.findById(prizeId.value)
        checkNotNull(prize).delete()
    }
}
