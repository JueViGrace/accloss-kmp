package com.closs.feature.auth.domain.usecase

import com.closs.shared.data.RequestState
import com.closs.shared.data.company.Company
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class FetchCompany(
    private val coroutineContext: CoroutineContext
) {
    operator fun invoke(): Flow<RequestState<Company>> {
        //todo: fetch company

        return flow {
            emit(RequestState.Loading)
        }.flowOn(coroutineContext)
    }
}
