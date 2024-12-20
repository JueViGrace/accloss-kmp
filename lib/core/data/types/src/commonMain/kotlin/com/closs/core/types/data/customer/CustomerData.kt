package com.closs.core.types.data.customer

data class CustomerData(
    val customer: Customer,
    val orders: Int = 0,
    val debt: Double = 0.0,
    val expired: Double = 0.0
)
