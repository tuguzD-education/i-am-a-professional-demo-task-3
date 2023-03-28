package io.github.tuguzd.professional.app.di

import io.github.tuguzd.professional.data.client.RepositoryClient
import io.github.tuguzd.professional.data.repository.ParticipantRepositoryImpl
import io.github.tuguzd.professional.data.repository.PrizeRepositoryImpl
import io.github.tuguzd.professional.data.repository.PromoActionRepositoryImpl
import io.github.tuguzd.professional.domain.repository.ParticipantRepository
import io.github.tuguzd.professional.domain.repository.PrizeRepository
import io.github.tuguzd.professional.domain.repository.PromoActionRepository
import org.koin.core.module.Module
import org.koin.dsl.module

fun createDataModule(
    databaseUri: String, driverClassName: String,
): Module = module {
    single { RepositoryClient(databaseUri, driverClassName) }
    factory<PromoActionRepository> { PromoActionRepositoryImpl(get()) }
    factory<ParticipantRepository> { ParticipantRepositoryImpl(get()) }
    factory<PrizeRepository> { PrizeRepositoryImpl(get()) }
}
