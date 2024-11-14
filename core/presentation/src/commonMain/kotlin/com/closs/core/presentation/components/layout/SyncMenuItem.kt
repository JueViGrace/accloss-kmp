package com.closs.core.presentation.components.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import closs_kmp.core.resources.generated.resources.Res
import closs_kmp.core.resources.generated.resources.ic_cloud
import closs_kmp.core.resources.generated.resources.synchronize
import com.closs.core.presentation.components.display.CustomText
import com.closs.core.presentation.components.display.RowComponent
import com.closs.core.presentation.components.icons.IconComponent
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SyncMenuItem(
    actions: @Composable RowScope.() -> Unit,
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
                painter = painterResource(Res.drawable.ic_cloud),
                contentDescription = "Log out icon"
            )
        },
        actions = actions,
        title = {
            CustomText(
                modifier = Modifier.weight(1f),
                text = stringResource(Res.string.synchronize)
            )
        }
    )
}
