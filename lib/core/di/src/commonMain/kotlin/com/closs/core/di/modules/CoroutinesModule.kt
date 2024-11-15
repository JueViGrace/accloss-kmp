package com.closs.core.di.modules

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

fun coroutinesModule(): Module = module {
    single<CoroutineContext> { SupervisorJob() + Dispatchers.IO }

    singleOf(::CoroutineScope) bind CoroutineScope::class
}
