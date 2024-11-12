package com.closs.core.shared.data.sync

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SyncBody(
    @SerialName("sincroonizacion")
    var synchronization: com.closs.core.shared.data.sync.Synchronization
)

@Serializable
data class Synchronization(
    @SerialName("usuario")
    var usuario: String,
    @SerialName("fecha")
    var fecha: String,
    @SerialName("version")
    var version: String,
)

@Serializable
data class Estado(
    @SerialName("estado")
    val response: com.closs.core.shared.data.sync.Response
)

@Serializable
data class Response(
    @SerialName("status")
    val status: Int,
    @SerialName("usuario")
    val user: String
)
