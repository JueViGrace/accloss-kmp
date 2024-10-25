package org.clo.accloss.core.domain.repository

import kotlin.coroutines.CoroutineContext

interface Repository<S> {
    val dataSource: S
    val coroutineContext: CoroutineContext
}
