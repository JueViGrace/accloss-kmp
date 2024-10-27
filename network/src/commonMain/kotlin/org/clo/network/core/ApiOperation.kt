package org.clo.network.core

sealed interface ApiOperation<T> {
    data class Success<T>(val data: T) : ApiOperation<T>
    data class Failure<T>(val error: String) : ApiOperation<T>
}
