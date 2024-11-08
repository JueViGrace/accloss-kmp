package com.closs.types.core

import kotlinx.coroutines.CoroutineScope

interface LocalSource {
    val scope: CoroutineScope
}
