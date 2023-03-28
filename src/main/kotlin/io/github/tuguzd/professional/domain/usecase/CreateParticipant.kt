package io.github.tuguzd.professional.domain.usecase

import io.github.tuguzd.professional.domain.model.ParticipantId
import io.github.tuguzd.professional.domain.model.PostParticipant
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.repository.ParticipantRepository

class CreateParticipant(private val repository: ParticipantRepository) {
    suspend fun postParticipant(id: PromoActionId, body: PostParticipant): ParticipantId {
        return repository.create(id, body)
    }
}
