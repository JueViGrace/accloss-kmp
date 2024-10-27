package org.clo.types.common

fun Throwable.log(tag: String) =
    println(
        """
            $tag, 
            Message: ${this.message}\n
            Localized Message: ${this.localizedMessage}
        """.trimIndent()
    )
