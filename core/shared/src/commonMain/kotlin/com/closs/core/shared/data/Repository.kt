package com.closs.core.shared.data

import kotlin.coroutines.CoroutineContext

interface Repository<S> {
    val dataSource: S
    val coroutineContext: CoroutineContext
}
