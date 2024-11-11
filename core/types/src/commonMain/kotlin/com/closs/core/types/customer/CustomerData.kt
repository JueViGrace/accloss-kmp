package com.closs.core.types.customer

data class CustomerData(
    val customer: com.closs.core.types.customer.Customer,
    val orders: Int = 0,
    val debt: Double = 0.0,
    val expired: Double = 0.0
)
