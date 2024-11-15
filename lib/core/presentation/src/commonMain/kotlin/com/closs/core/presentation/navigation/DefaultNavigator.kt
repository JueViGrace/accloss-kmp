package com.closs.core.presentation.navigation

import com.closs.core.presentation.navigation.routes.Destinations

class DefaultNavigator(
    val startDestination: Destinations = Destinations.AuthGraph,
) : Navigator
