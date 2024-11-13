package com.closs.feature.auth.domain.usecase

import com.closs.core.types.data.RequestState
import com.closs.core.types.data.user.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class FetchUser(
    private val coroutineContext: CoroutineContext
) {
    operator fun invoke(): Flow<RequestState<User>> {
        // todo: fetch user

        return flow {
            emit(RequestState.Loading)
        }.flowOn(coroutineContext)
    }
}
