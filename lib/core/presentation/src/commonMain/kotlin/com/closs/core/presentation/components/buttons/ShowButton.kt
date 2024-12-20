package com.closs.core.presentation.components.buttons

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import closs_kmp.lib.core.resources.generated.resources.Res
import closs_kmp.lib.core.resources.generated.resources.ic_caret_down
import closs_kmp.lib.core.resources.generated.resources.ic_caret_up
import com.closs.core.presentation.components.icons.IconComponent
import org.jetbrains.compose.resources.painterResource

@Composable
fun ShowButton(
    modifier: Modifier = Modifier,
    state: Boolean,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        AnimatedContent(
            targetState = state,
        ) {
            IconComponent(
                modifier = Modifier.size(24.dp),
                painter = if (it) {
                    painterResource(Res.drawable.ic_caret_down)
                } else {
                    painterResource(Res.drawable.ic_caret_up)
                },
                contentDescription = "Show button"
            )
        }
    }
}
