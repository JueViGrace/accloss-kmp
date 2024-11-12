package com.closs.core.types.data

import kotlinx.coroutines.CoroutineScope

interface LocalSource {
    val scope: CoroutineScope
}
