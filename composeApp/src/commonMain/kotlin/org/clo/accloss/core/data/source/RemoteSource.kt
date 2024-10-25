package org.clo.accloss.core.data.source

import kotlinx.coroutines.CoroutineScope

interface RemoteSource {
    val scope: CoroutineScope
}