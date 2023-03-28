package io.github.tuguzd.professional.app.di

import io.github.tuguzd.professional.domain.usecase.*
import org.koin.core.module.Module
import org.koin.dsl.module

fun createInteractorModule(): Module = module {
    factory { CreatePromoAction(get()) }
    factory { GetAllPromoActions(get()) }
    factory { GetPromoActionById(get()) }
    factory { UpdatePromoAction(get()) }
    factory { DeletePromoAction(get()) }

    factory { CreateParticipant(get()) }
    factory { DeleteParticipant(get()) }

    factory { CreatePrize(get()) }
    factory { DeletePrize(get()) }

    factory { RafflePromoAction(get()) }
}
