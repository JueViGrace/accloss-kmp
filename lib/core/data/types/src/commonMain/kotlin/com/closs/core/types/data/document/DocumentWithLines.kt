package com.closs.core.types.data.document

data class DocumentWithLines(
    val document: Document? = null,
    val lines: List<DocumentLine> = emptyList()
)
