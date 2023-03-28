package io.github.tuguzd.professional.data.repository

import io.github.tuguzd.professional.data.client.RepositoryClient
import io.github.tuguzd.professional.data.model.ParticipantEntity
import io.github.tuguzd.professional.data.model.PromoActionEntity
import io.github.tuguzd.professional.domain.model.ParticipantId
import io.github.tuguzd.professional.domain.model.PostParticipant
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.repository.ParticipantRepository

class ParticipantRepositoryImpl(
    private val client: RepositoryClient
) : ParticipantRepository {
    override suspend fun create(promoId: PromoActionId, new: PostParticipant): ParticipantId = client.transaction {
        val promo = PromoActionEntity.findById(promoId.value)
        ParticipantEntity.new {
            name = new.name
            promoAction = checkNotNull(promo)
        }.toDomain().id
    }

    override suspend fun delete(promoId: PromoActionId, participantId: ParticipantId) = client.transaction {
        val promo = PromoActionEntity.findById(promoId.value)
        checkNotNull(promo)

        val prize = ParticipantEntity.findById(participantId.value)
        checkNotNull(prize).delete()
    }
}
