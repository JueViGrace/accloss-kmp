package com.closs.types.auth

data class Session(
    val id: String = "",
    val nombre: String = "",
    val nombreEmpresa: String = "",
    val user: String = "",
    val empresa: String = "",
    val enlaceEmpresa: String = "",
    val enlaceEmpresaPost: String = "",
    val active: Boolean = false,
)
