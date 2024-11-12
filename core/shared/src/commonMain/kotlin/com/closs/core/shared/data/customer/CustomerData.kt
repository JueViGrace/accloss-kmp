package com.closs.core.shared.data.customer

data class CustomerData(
    val customer: com.closs.core.shared.data.customer.Customer,
    val orders: Int = 0,
    val debt: Double = 0.0,
    val expired: Double = 0.0
)
