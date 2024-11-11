package com.clo.accloss.core.presentation.components.layout

import ac_closs.composeapp.generated.resources.Res
import ac_closs.composeapp.generated.resources.empty
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.clo.accloss.core.presentation.components.display.CustomText
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ErrorComponent(message: StringResource? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        CustomText(
            text = stringResource(message ?: Res.string.empty),
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
            color = MaterialTheme.colorScheme.error
        )
    }
}
