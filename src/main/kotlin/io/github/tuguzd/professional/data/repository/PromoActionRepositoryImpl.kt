package io.github.tuguzd.professional.data.repository

import io.github.tuguzd.professional.data.client.RepositoryClient
import io.github.tuguzd.professional.data.model.PromoActionEntity
import io.github.tuguzd.professional.domain.model.PromoAction
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.model.PutPromoAction
import io.github.tuguzd.professional.domain.repository.PromoActionRepository

class PromoActionRepositoryImpl(
    private val client: RepositoryClient
): PromoActionRepository {
    override suspend fun create(new: PutPromoAction): PromoAction = client.transaction {
        PromoActionEntity.new {
            name = new.name
            description = new.description
        }.toDomain()
    }

    override suspend fun getAll(): List<PromoAction> = client.transaction {
        PromoActionEntity.all().map(PromoActionEntity::toDomain)
    }

    override suspend fun getById(id: PromoActionId): PromoAction? = client.transaction {
        PromoActionEntity.findById(id.value)?.toDomain()
    }

    override suspend fun update(id: PromoActionId, new: PutPromoAction) = client.transaction {
        val promo = PromoActionEntity.findById(id.value)
        checkNotNull(promo).run {
            name = new.name
            description = new.description
        }
    }

    override suspend fun delete(id: PromoActionId) = client.transaction {
        val promo = PromoActionEntity.findById(id.value)
        checkNotNull(promo).delete()
    }
}
