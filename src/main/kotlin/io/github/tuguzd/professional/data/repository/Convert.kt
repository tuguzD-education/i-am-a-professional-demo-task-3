package io.github.tuguzd.professional.data.repository

import io.github.tuguzd.professional.data.model.ParticipantEntity
import io.github.tuguzd.professional.data.model.PrizeEntity
import io.github.tuguzd.professional.data.model.PromoActionEntity
import io.github.tuguzd.professional.domain.model.*

fun PromoActionEntity.toDomain(): PromoAction = PromoAction(
    id = PromoActionId(id.value),
    name = name, description = description,
    prizes = prizes.map(PrizeEntity::toDomain),
    participants = participants.map(ParticipantEntity::toDomain),
)

fun PrizeEntity.toDomain(): Prize = Prize(
    id = PrizeId(id.value),
    description = description,
)

fun ParticipantEntity.toDomain(): Participant = Participant(
    id = ParticipantId(id.value), name = name,
)
