package com.closs.core.di

import com.closs.core.database.di.databaseModule
import com.closs.core.di.modules.coroutinesModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.koinApplication

object KoinBuilder {
    private val app = koinApplication()
    private val requiredModules = listOf(
        databaseModule(),
        coroutinesModule(),
    )

    fun addModule(modules: List<Module>): KoinBuilder {
        app.modules(modules + requiredModules)
        return this
    }

    fun addModule(vararg modules: Module): KoinBuilder {
        addModule(modules.toList())
        return this
    }

    fun addModule(module: Module): KoinBuilder {
        addModule(listOf(module))
        return this
    }

    fun addConfig(appDeclaration: KoinAppDeclaration = {}): KoinBuilder {
        app.apply(appDeclaration)
        return this
    }

    fun build() = startKoin(app)
}
