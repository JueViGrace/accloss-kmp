package org.clo.di.core

import org.clo.di.auth.authModule
import org.clo.di.company.companyModule
import org.clo.di.config.configModule
import org.clo.di.coroutines.coroutinesModule
import org.clo.di.database.databaseModule
import org.clo.di.statistic.statisticModule
import org.clo.di.user.userModule
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.koinApplication
import org.koin.dsl.module

object Koin {
    fun koinConfiguration(
        additionalModules: List<Module> = emptyList(),
        appDeclaration: KoinAppDeclaration = {}
    ) = koinApplication {
        appDeclaration()
        modules(appModule() + additionalModules)
    }

    private fun appModule(): List<Module> {
        return listOf(databaseModule(), coroutinesModule(), sharedModule())
    }

    private fun sharedModule(): Module {
        return module {
            includes(
                authModule(),
                companyModule(),
                configModule(),
                userModule(),
                statisticModule()
            )
        }
    }
}
