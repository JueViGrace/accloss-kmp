package com.closs.core.types.order

data class OrderDetails(
    val order: com.closs.core.types.order.Order? = null,
    val orderLines: List<com.closs.core.types.order.OrderLines> = emptyList()
)
