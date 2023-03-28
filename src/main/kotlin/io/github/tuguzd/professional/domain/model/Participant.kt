package io.github.tuguzd.professional.domain.model

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class ParticipantId(val value: Long)

@Serializable
data class Participant(
    val id: ParticipantId,
    val name: String,
)

@Serializable
data class PostParticipant(
    val name: String,
)
