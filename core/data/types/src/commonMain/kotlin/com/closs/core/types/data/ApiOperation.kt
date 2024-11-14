package com.closs.core.types.data

sealed interface ApiOperation<out T> {
    data class Success<T>(val data: T) : ApiOperation<T>
    data class Failure(val error: DataError) : ApiOperation<Nothing>
}
