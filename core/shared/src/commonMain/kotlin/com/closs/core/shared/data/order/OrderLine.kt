package com.closs.core.shared.data.order

data class OrderLines(
    val kmvArtprec: Double = 0.0,
    val kmvCant: Double = 0.0,
    val kmvCodart: String = "",
    val kmvDctolin: Double = 0.0,
    val kmvNombre: String = "",
    val kmvStot: Double = 0.0,
    val ktiNdoc: String = "",
    val ktiTdoc: String = "",
    val ktiTipprec: Double = 0.0,
    val userId: String = "",
)