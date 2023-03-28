package io.github.tuguzd.professional.domain.repository

import io.github.tuguzd.professional.domain.model.ParticipantId
import io.github.tuguzd.professional.domain.model.PostParticipant
import io.github.tuguzd.professional.domain.model.PromoActionId

interface ParticipantRepository {
    suspend fun create(promoId: PromoActionId, new: PostParticipant): ParticipantId

    suspend fun delete(promoId: PromoActionId, participantId: ParticipantId)
}
