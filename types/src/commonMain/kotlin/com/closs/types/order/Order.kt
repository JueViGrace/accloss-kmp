package com.closs.types.order

data class Order(
    val fechamodifi: String = "",
    val kePedstatus: String = "",
    val ktiCodcli: String = "",
    val ktiCodven: String = "",
    val ktiCondicion: String = "",
    val ktiDocsol: String = "",
    val ktiFchdoc: String = "",
    val ktiNdoc: String = "",
    val ktiNegesp: String = "",
    val ktiNombrecli: String = "",
    val ktiNroped: String = "",
    val ktiStatus: String = "",
    val ktiTdoc: String = "",
    val ktiTipprec: Double = 0.0,
    val ktiTotneto: Double = 0.0,
    val userId: String = "",
)
