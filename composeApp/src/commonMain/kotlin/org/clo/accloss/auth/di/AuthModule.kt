package org.clo.accloss.auth.di

import org.clo.accloss.auth.data.local.AuthLocalSource
import org.clo.accloss.auth.data.local.DefaultAuthLocalSource
import org.clo.accloss.auth.data.remote.AuthRemoteSource
import org.clo.accloss.auth.data.remote.DefaultAuthRemoteSource
import org.clo.accloss.auth.data.repository.DefaultAuthRepository
import org.clo.accloss.auth.data.source.AuthDataSource
import org.clo.accloss.auth.domain.repository.AuthRepository
import org.clo.accloss.core.data.source.DataSource
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun authModule(): Module {
    return module {
        singleOf(::DefaultAuthLocalSource) bind AuthLocalSource::class

        singleOf(::DefaultAuthRemoteSource) bind AuthRemoteSource::class

        singleOf(::AuthDataSource) bind DataSource::class

        singleOf(::DefaultAuthRepository) bind AuthRepository::class
    }
}
