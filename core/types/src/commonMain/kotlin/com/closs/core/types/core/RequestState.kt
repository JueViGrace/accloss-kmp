package com.closs.core.types.core

sealed class RequestState<out T> {
    data object Idle : com.closs.core.types.core.RequestState<Nothing>()
    data object Loading : com.closs.core.types.core.RequestState<Nothing>()
    data class Success<T>(val data: T) : com.closs.core.types.core.RequestState<T>()
    data class Error(val message: Int) : com.closs.core.types.core.RequestState<Nothing>()

    fun isLoading() = this is com.closs.core.types.core.RequestState.Loading
    fun isSuccess() = this is com.closs.core.types.core.RequestState.Success
    fun isError() = this is com.closs.core.types.core.RequestState.Error

    /**
     * Returns data from a [Success].
     * @throws ClassCastException If the current state is not [Success]
     *  */
    fun getSuccessData() = (this as com.closs.core.types.core.RequestState.Success).data
    fun getSuccessDataOrNull(): T? {
        return try {
            (this as com.closs.core.types.core.RequestState.Success).data
        } catch (e: Exception) {
            null
        }
    }
    fun getSuccessDataSafe(): T? = if (this.isSuccess()) (this as com.closs.core.types.core.RequestState.Success).data else getSuccessDataOrNull()

    /**
     * Returns an error message from an [Error]
     * @throws ClassCastException If the current state is not [Error]
     *  */
    fun getErrorMessage() = (this as com.closs.core.types.core.RequestState.Error).message
    fun getErrorMessageOrEmpty(): Int {
        return try {
            (this as com.closs.core.types.core.RequestState.Error).message
        } catch (e: Exception) {
            0
        }
    }
}
