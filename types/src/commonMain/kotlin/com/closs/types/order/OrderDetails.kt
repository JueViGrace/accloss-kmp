package com.closs.types.order

data class OrderDetails(
    val order: Order? = null,
    val orderLines: List<OrderLines> = emptyList()
)
