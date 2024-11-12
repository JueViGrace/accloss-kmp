package com.closs.feature.contact.domain.usecase

import com.closs.core.shared.data.RequestState
import com.closs.core.shared.data.salesman.Salesman
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class GetContacts(
    private val coroutineContext: CoroutineContext
) {
    operator fun invoke(): Flow<RequestState<List<Salesman>>> = flow {
        emit(RequestState.Loading)
    }.flowOn(coroutineContext)
}
