package com.closs.core.types.data.order

data class OrderDetails(
    val order: Order? = null,
    val orderLines: List<OrderLines> = emptyList()
)
