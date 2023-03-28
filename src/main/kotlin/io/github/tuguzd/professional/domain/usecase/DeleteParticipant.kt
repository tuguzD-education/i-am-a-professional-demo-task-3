package io.github.tuguzd.professional.domain.usecase

import io.github.tuguzd.professional.domain.model.ParticipantId
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.repository.ParticipantRepository

class DeleteParticipant(private val repository: ParticipantRepository) {
    suspend fun deleteParticipant(promoId: PromoActionId, participantId: ParticipantId) {
        repository.delete(promoId, participantId)
    }
}
