package org.clo.accloss.core.presentation.navigation

import cafe.adriel.voyager.navigator.tab.Tab
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

sealed class NavMenuTabs(val tab: Tab, val index: UShort, val title: StringResource, val icon: DrawableResource) {

}