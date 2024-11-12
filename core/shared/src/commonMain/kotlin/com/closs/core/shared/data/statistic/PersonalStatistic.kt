package com.closs.core.shared.data.statistic

data class PersonalStatistic(
    val prcmeta: Double = 0.0,
    val mtofactneto: Double = 0.0,
    val cantped: Double = 0.0,
    val meta: Double = 0.0,
    val mtocob: Double = 0.0,
    val deuda: Double = 0.0,
    val vencido: Double = 0.0,
    val promdiasvta: Double = 0.0,
    val cantdocs: Double = 0.0,
    val totmtodocs: Double = 0.0,
    val prommtopordoc: Double = 0.0,
    val nombre: String = "",
    val codigo: String = "",
    val statistic: com.closs.core.shared.data.statistic.Statistic? = null
)
