package com.closs.auth.domain.usecase

import com.closs.auth.domain.repository.AuthRepository
import com.closs.core.types.data.RequestState
import com.closs.core.types.data.company.Company
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class FetchCompany(
    private val authRepository: AuthRepository,
    private val coroutineContext: CoroutineContext
) {
    suspend operator fun invoke(code: String): RequestState<Company> {
        return withContext(coroutineContext) {
            authRepository.fetchCompany(code)
        }
    }
}
