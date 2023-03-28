package io.github.tuguzd.professional.domain.repository

import io.github.tuguzd.professional.domain.model.PromoAction
import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.model.PutPromoAction

interface PromoActionRepository {
    suspend fun getAll(): List<PromoAction>

    suspend fun create(new: PutPromoAction): PromoAction

    suspend fun getById(id: PromoActionId): PromoAction?

    suspend fun update(id: PromoActionId, new: PutPromoAction)

    suspend fun delete(id: PromoActionId)
}
