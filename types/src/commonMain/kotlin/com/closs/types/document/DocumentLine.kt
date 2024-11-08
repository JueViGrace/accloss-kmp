package com.closs.types.document

data class DocumentLine(
    val agencia: String = "",
    val cantidad: Double = 0.0,
    val cntdevuelt: Double = 0.0,
    val codcoord: String = "",
    val codhijo: String = "",
    val codigo: String = "",
    val dmontoneto: Double = 0.0,
    val dmontototal: Double = 0.0,
    val documento: String = "",
    val dpreciofin: Double = 0.0,
    val dpreciounit: Double = 0.0,
    val dvndmtototal: Double = 0.0,
    val fechadoc: String = "",
    val fechamodifi: String = "",
    val grupo: String = "",
    val nombre: String = "",
    val origen: Double = 0.0,
    val pid: String = "",
    val subgrupo: String = "",
    val timpueprc: Double = 0.0,
    val tipodoc: String = "",
    val tipodocv: String = "",
    val unidevuelt: Double = 0.0,
    val vendedor: String = "",
    val vndcntdevuelt: Double = 0.0,
    val empresa: String = ""
)
