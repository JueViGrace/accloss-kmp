package org.clo.accloss.auth.domain.model

data class Login(
    val baseUrl: String = "",
    val username: String = "",
    val password: String = ""
)
