package com.closs.core.shared.data.order

data class OrderDetails(
    val order: com.closs.core.shared.data.order.Order? = null,
    val orderLines: List<com.closs.core.shared.data.order.OrderLines> = emptyList()
)
