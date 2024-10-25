package org.clo.accloss.auth.domain.model

data class Session(
    val nombre: String = "",
    val nombreEmpresa: String = "",
    val user: String = "",
    val empresa: String = "",
    val enlaceEmpresa: String = "",
    val enlaceEmpresaPost: String = "",
    val active: Boolean = true,
    val lastSync: String = "",
)
