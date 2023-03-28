package io.github.tuguzd.professional.domain.model

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class PromoActionId(val value: Long)

@Serializable
data class PromoAction(
    val id: PromoActionId,
    val name: String,
    val description: String,
    val prizes: List<Prize>,
    val participants: List<Participant>,
)

@Serializable
data class GetPromoAction(
    val id: PromoActionId,
    val name: String,
    val description: String,
)

@Serializable
data class PostPromoAction(
    val name: String,
    val description: String?,
)

@Serializable
data class PutPromoAction(
    val name: String,
    val description: String,
)
