package com.closs.auth.domain.usecase

import com.closs.auth.domain.repository.AuthRepository
import com.closs.core.types.data.RequestState
import com.closs.core.types.data.auth.Session
import kotlinx.coroutines.flow.Flow

class GetCurrentUser(
    private val authRepository: AuthRepository,
) {
    operator fun invoke(): Flow<RequestState<Session>> {
        return authRepository.getCurrentUser()
    }
}
