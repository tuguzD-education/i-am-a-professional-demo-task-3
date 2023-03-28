package io.github.tuguzd.professional.domain.model

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class PrizeId(val value: Long)

@Serializable
data class Prize(
    val id: PrizeId,
    val description: String,
)

@Serializable
data class PostPrize(
    val description: String,
)
