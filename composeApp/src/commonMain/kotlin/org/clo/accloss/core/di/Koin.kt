package org.clo.accloss.core.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.clo.accloss.auth.di.authModule
import org.clo.accloss.company.di.companyModule
import org.clo.accloss.config.di.configModule
import org.clo.accloss.core.data.database.DbHelper
import org.clo.accloss.user.di.userModule
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

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

    private fun databaseModule(): Module {
        return module {
            singleOf(::DbHelper)
        }
    }

    private fun coroutinesModule(): Module {
        return module {
            single<CoroutineContext> { Dispatchers.Default }

            singleOf(::CoroutineScope) bind CoroutineScope::class
        }
    }

    private fun sharedModule(): Module {
        return module {
            includes(authModule(), companyModule(), configModule(), userModule())
        }
    }
}
