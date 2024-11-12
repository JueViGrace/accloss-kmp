package com.closs.core.types.data

import kotlinx.coroutines.CoroutineScope

interface RemoteSource {
    val scope: CoroutineScope
}
