package com.closs.types.document

data class DocumentWithLines(
    val document: Document? = null,
    val lines: List<DocumentLine> = emptyList()
)
