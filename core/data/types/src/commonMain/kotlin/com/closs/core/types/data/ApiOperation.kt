package com.closs.core.types.data

interface ApiOperation<T> {
    data class Success<T>(val data: T) : ApiOperation<T>
    data class Failure<T>(val error: Int) : ApiOperation<T>
}
