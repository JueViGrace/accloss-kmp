package com.closs.app.presentation.components.layout

import accloss_kmp.composeapp.generated.resources.Res
import accloss_kmp.composeapp.generated.resources.bills
import accloss_kmp.composeapp.generated.resources.customers
import accloss_kmp.composeapp.generated.resources.ic_dots_vertical
import accloss_kmp.composeapp.generated.resources.ic_receipt
import accloss_kmp.composeapp.generated.resources.ic_report_analytics
import accloss_kmp.composeapp.generated.resources.ic_search
import accloss_kmp.composeapp.generated.resources.ic_shopping_bag
import accloss_kmp.composeapp.generated.resources.ic_users_group
import accloss_kmp.composeapp.generated.resources.orders
import accloss_kmp.composeapp.generated.resources.search
import accloss_kmp.composeapp.generated.resources.statistics
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.closs.app.presentation.components.display.CustomText
import com.closs.app.presentation.components.icons.IconComponent
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TopBarActionsComponent(
    onMenuClick: (TopBarActions) -> Unit,
    items: List<TopBarActions>
) {
    var actionsVisible by remember {
        mutableStateOf(false)
    }

    IconButton(
        onClick = {
            actionsVisible = !actionsVisible
        }
    ) {
        IconComponent(
            painter = painterResource(Res.drawable.ic_dots_vertical),
            contentDescription = "More options"
        )
    }

    DropdownMenu(
        expanded = actionsVisible,
        onDismissRequest = { actionsVisible = false }
    ) {
        items.forEach { action ->
            DropdownMenuItem(
                leadingIcon = if (action.icon != null) {
                    {
                        IconComponent(
                            modifier = Modifier.size(18.dp),
                            painter = painterResource(action.icon),
                            contentDescription = "Search"
                        )
                    }
                } else {
                    null
                },
                text = {
                    CustomText(
                        text = stringResource(action.title),
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
                    )
                },
                onClick = {
                    onMenuClick(action)
                    actionsVisible = false
                }
            )
        }
    }
}

sealed class TopBarActions(
    val title: StringResource,
    val icon: DrawableResource? = null
) {
    data object Search : TopBarActions(
        title = Res.string.search,
        icon = Res.drawable.ic_search
    )

    data object Statistics : TopBarActions(
        title = Res.string.statistics,
        icon = Res.drawable.ic_report_analytics
    )

    data object Customers : TopBarActions(
        title = Res.string.customers,
        icon = Res.drawable.ic_users_group
    )
    data object Orders : TopBarActions(
        title = Res.string.orders,
        icon = Res.drawable.ic_shopping_bag
    )

    data object Bills : TopBarActions(
        title = Res.string.bills,
        icon = Res.drawable.ic_receipt
    )
}
