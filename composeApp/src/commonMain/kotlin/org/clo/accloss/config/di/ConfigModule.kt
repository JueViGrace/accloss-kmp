package org.clo.accloss.config.di

import org.clo.accloss.config.data.local.ConfigLocalSource
import org.clo.accloss.config.data.local.DefaultConfigLocalSource
import org.clo.accloss.config.data.remote.source.ConfigRemoteSource
import org.clo.accloss.config.data.remote.source.DefaultConfigRemoteSource
import org.clo.accloss.config.data.repository.DefaultConfigRepository
import org.clo.accloss.config.data.source.ConfigDataSource
import org.clo.accloss.config.domain.repository.ConfigRepository
import org.clo.accloss.core.data.source.DataSource
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun configModule(): Module {
    return module {
        singleOf(::DefaultConfigLocalSource) bind ConfigLocalSource::class

        singleOf(::DefaultConfigRemoteSource) bind ConfigRemoteSource::class

        singleOf(::ConfigDataSource) bind DataSource::class

        singleOf(::DefaultConfigRepository) bind ConfigRepository::class
    }
}
