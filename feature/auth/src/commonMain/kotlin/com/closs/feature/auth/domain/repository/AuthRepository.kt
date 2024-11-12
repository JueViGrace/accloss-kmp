package com.closs.feature.auth.domain.repository

import com.closs.shared.data.RequestState
import com.closs.shared.data.company.Company
import com.closs.shared.data.user.User

interface AuthRepository {
    fun fetchCompany(code: String): RequestState<Company>

    fun login(baseUrl: String, username: String, password: String): RequestState<User>

}
