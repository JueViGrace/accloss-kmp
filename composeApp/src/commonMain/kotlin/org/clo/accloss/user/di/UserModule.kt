package org.clo.accloss.user.di

import org.clo.accloss.core.data.source.DataSource
import org.clo.accloss.user.data.local.DefaultUserLocalSource
import org.clo.accloss.user.data.local.UserLocalSource
import org.clo.accloss.user.data.remote.source.DefaultUserRemoteSource
import org.clo.accloss.user.data.remote.source.UserRemoteSource
import org.clo.accloss.user.data.repository.DefaultUserRepository
import org.clo.accloss.user.data.source.UserDataSource
import org.clo.accloss.user.domain.repository.UserRepository
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun userModule(): Module {
    return module {
        singleOf(::DefaultUserLocalSource) bind UserLocalSource::class

        singleOf(::DefaultUserRemoteSource) bind UserRemoteSource::class

        singleOf(::UserDataSource) bind DataSource::class

        singleOf(::DefaultUserRepository) bind UserRepository::class
    }
}
