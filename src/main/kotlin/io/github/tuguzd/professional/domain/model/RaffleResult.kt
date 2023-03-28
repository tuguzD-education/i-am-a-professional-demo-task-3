package io.github.tuguzd.professional.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class RaffleResult(
    val winner: Participant,
    val prize: Prize,
)
