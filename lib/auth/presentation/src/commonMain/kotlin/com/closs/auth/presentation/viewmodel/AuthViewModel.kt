package com.closs.auth.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.closs.auth.domain.usecase.FetchCompany
import com.closs.auth.domain.usecase.FetchUser
import com.closs.auth.presentation.events.AuthEvent
import com.closs.auth.presentation.state.AuthState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(
    private val fetchCompany: FetchCompany,
    private val fetchUser: FetchUser
) : ViewModel() {
    private var _state = MutableStateFlow(AuthState())
    val state = _state.asStateFlow()

    init {
        // todo: validate user
    }

    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.OnCompanyChanged -> handleCompanyChanged(event.value)
            is AuthEvent.OnUsernameChanged -> handleUsernameChanged(event.value)
            is AuthEvent.OnPasswordChanged -> handlePasswordChanged(event.value)
            AuthEvent.OnCompanyClicked -> handleCompanyClick()
            AuthEvent.OnLoginClicked -> handleLoginClick()
            AuthEvent.OnLoginDismiss -> onLoginDismiss()
            is AuthEvent.OnAccountSelected -> handleAccountSelected(event.id)
            AuthEvent.ToggleAuthMenu -> toggleAuthMenu()
        }
    }

    private fun handleCompanyChanged(value: String) {
        _state.update { state ->
            return@update state.copy(
                companyValue = value
            )
        }
    }

    private fun handleUsernameChanged(value: String) {
        _state.update { state ->
            return@update state.copy(
                usernameValue = value
            )
        }
    }

    private fun handlePasswordChanged(value: String) {
        _state.update { state ->
            return@update state.copy(
                passwordValue = value
            )
        }
    }

    private fun handleCompanyClick() {
        viewModelScope.launch {

        }
    }

    private fun handleLoginClick() {
    }

    private fun onLoginDismiss() {
    }

    private fun handleAccountSelected(id: String) {
    }

    private fun toggleAuthMenu() {
    }
}
