package com.closs.core.shared.presentation.components.buttons

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.closs.core.shared.presentation.components.display.LetterComponent

@Composable
fun AccountButton(
    letter: String = "C",
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick
    ) {
        LetterComponent(
            letter = letter
        )
    }
}