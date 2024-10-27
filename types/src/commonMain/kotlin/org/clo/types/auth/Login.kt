package org.clo.types.auth

data class Login(
    val baseUrl: String = "",
    val username: String = "",
    val password: String = ""
)
