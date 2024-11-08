package com.closs.types.manager

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ManagerResponse(
    @SerialName("kng_codgcia")
    val kngCodgcia: String? = null,

    @SerialName("kng_codcoord")
    val kngCodcoord: String? = null,

    @SerialName("fechamodifi")
    val fechamodifi: String? = null
)
