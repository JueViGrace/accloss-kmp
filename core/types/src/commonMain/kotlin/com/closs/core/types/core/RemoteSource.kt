package com.closs.core.types.core

import kotlinx.coroutines.CoroutineScope

interface RemoteSource {
    val scope: CoroutineScope
}
