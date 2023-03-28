package io.github.tuguzd.professional.domain.usecase

import io.github.tuguzd.professional.domain.model.PromoActionId
import io.github.tuguzd.professional.domain.model.RaffleResult
import io.github.tuguzd.professional.domain.repository.PromoActionRepository
import kotlin.random.Random

class RafflePromoAction(
    private val repository: PromoActionRepository,
    private val random: Random = Random.Default,
) {
    suspend fun postRaffleResult(id: PromoActionId): List<RaffleResult> {
        val promo = repository.getById(id)
        checkNotNull(promo) { "Промоакция не существует по переданному ID" }
        if (promo.prizes.size != promo.participants.size) {
            throw Exception()
        }

        val prizes = promo.prizes.shuffled(random)
        val participants = promo.participants.shuffled(random)
        val raffleResults = (participants zip prizes)
            .map { (winner, prize) -> RaffleResult(winner, prize) }
        return raffleResults
    }

    class Exception : IllegalStateException(
        "Проведение розыгрыша возможно только в том случае, " +
                "когда количество участников и призов в промоакции совпадает"
    )
}
