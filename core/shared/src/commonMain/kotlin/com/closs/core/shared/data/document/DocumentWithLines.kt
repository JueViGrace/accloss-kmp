package com.closs.core.shared.data.document

data class DocumentWithLines(
    val document: com.closs.core.shared.data.document.Document? = null,
    val lines: List<com.closs.core.shared.data.document.DocumentLine> = emptyList()
)
