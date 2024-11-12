package com.closs.core.shared.data

import kotlinx.coroutines.CoroutineScope

interface LocalSource {
    val scope: CoroutineScope
}
