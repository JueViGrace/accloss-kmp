package com.closs.core.types.core

import kotlinx.coroutines.CoroutineScope

interface LocalSource {
    val scope: CoroutineScope
}
