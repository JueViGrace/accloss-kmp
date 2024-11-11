package com.clo.accloss.core.presentation.components.buttons

import ac_closs.composeapp.generated.resources.Res
import ac_closs.composeapp.generated.resources.ic_x
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clo.accloss.core.presentation.components.icons.IconComponent
import org.jetbrains.compose.resources.painterResource

@Composable
fun CloseIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier.size(size = 28.dp),
        onClick = onClick
    ) {
        IconComponent(
            painter = painterResource(Res.drawable.ic_x),
            contentDescription = "Close icon"
        )
    }
}
