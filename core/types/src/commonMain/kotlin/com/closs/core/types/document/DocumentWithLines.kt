package com.closs.core.types.document

data class DocumentWithLines(
    val document: com.closs.core.types.document.Document? = null,
    val lines: List<com.closs.core.types.document.DocumentLine> = emptyList()
)
