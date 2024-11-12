package com.closs.feature.auth.domain.repository

import com.closs.core.shared.data.RequestState
import com.closs.core.shared.data.company.Company
import com.closs.core.shared.data.user.User

interface AuthRepository {
    fun fetchCompany(code: String): RequestState<Company>

    fun login(baseUrl: String, username: String, password: String): RequestState<User>

}
