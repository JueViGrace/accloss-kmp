package com.clo.accloss.core.presentation.components.layout

import ac_closs.composeapp.generated.resources.Res
import ac_closs.composeapp.generated.resources.ic_logout
import ac_closs.composeapp.generated.resources.log_out
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clo.accloss.core.presentation.components.display.CustomText
import com.clo.accloss.core.presentation.components.display.RowComponent
import com.clo.accloss.core.presentation.components.icons.IconComponent
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun EndSessionMenuItem(
    onClick: () -> Unit
) {
    RowComponent(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable {
                onClick()
            },
        icon = {
            IconComponent(
                painter = painterResource(Res.drawable.ic_logout),
                contentDescription = "Log out icon"
            )
        },
        title = {
            CustomText(
                modifier = Modifier.weight(1f),
                text = stringResource(Res.string.log_out)
            )
        }
    )
}
