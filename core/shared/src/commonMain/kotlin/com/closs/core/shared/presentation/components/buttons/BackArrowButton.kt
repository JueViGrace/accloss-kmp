package com.closs.core.shared.presentation.components.buttons

import accloss_kmp.core.shared.generated.resources.Res
import accloss_kmp.core.shared.generated.resources.ic_chevron_left
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.closs.core.shared.presentation.components.icons.IconComponent
import org.jetbrains.compose.resources.painterResource

@Composable
fun BackArrowButton(
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick
    ) {
        IconComponent(
            painter = painterResource(Res.drawable.ic_chevron_left),
            contentDescription = "On back"
        )
    }
}
