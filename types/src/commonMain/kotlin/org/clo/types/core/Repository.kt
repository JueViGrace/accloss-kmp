package org.clo.types.core

import kotlin.coroutines.CoroutineContext

interface Repository<S> {
    val dataSource: S
    val coroutineContext: CoroutineContext
}
