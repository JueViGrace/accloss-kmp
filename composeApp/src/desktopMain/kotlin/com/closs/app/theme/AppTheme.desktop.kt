package com.closs.app.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.closs.app.presentation.theme.AppTypography
import com.closs.app.presentation.theme.darkScheme
import com.closs.app.presentation.theme.lightScheme

@Composable
actual fun AppTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}