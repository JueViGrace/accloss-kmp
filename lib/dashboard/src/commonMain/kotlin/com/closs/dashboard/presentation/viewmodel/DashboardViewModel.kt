package com.closs.dashboard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.closs.dashboard.presentation.state.DashboardState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel : ViewModel() {
    private var _state = MutableStateFlow(DashboardState())
    val state = _state.asStateFlow()
}
