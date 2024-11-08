package com.closs.types.core

import kotlinx.coroutines.CoroutineScope

interface RemoteSource {
    val scope: CoroutineScope
}
