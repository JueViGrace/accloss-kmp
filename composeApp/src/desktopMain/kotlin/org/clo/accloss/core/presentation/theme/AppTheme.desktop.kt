package org.clo.accloss.core.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.clo.accloss.core.presentation.theme.AppTypography
import org.clo.accloss.core.presentation.theme.darkScheme
import org.clo.accloss.core.presentation.theme.lightScheme

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
