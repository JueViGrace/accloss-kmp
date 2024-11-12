package com.closs.core.shared.data

import kotlinx.coroutines.CoroutineScope

interface RemoteSource {
    val scope: CoroutineScope
}
