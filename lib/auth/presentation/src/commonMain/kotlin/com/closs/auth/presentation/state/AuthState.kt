package com.closs.auth.presentation.state

import com.closs.core.types.data.auth.Session
import com.closs.core.types.data.company.Company
import org.jetbrains.compose.resources.StringResource

data class AuthState(
    val sessions: List<Session> = emptyList(),
    val session: Session? = null,
    val company: Company? = null,

    val menuVisibility: Boolean = false,
    val navigateBack: Boolean = false,

    val loadingCompany: Boolean = false,
    val loadingUser: Boolean = false,
    val loginEnabled: Boolean = false,

    val companyValue: String = "",
    val usernameValue: String = "",
    val passwordValue: String = "",

    val companyError: StringResource? = null,
    val usernameError: StringResource? = null,
    val passwordError: StringResource? = null,
    val authError: StringResource? = null
)