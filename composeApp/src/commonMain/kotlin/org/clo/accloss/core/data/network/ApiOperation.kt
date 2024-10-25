package org.clo.accloss.core.data.network

import org.jetbrains.compose.resources.StringResource

sealed interface ApiOperation<T> {
    data class Success<T>(val data: T) : ApiOperation<T>
    data class Failure<T>(val error: StringResource) : ApiOperation<T>
}
