package com.cleverlycode.vibes.screens.password_recover

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleverlycode.vibes.data.service.AccountService
import com.cleverlycode.vibes.nav_graphs.Graph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasswordRecoverViewModel @Inject constructor(
    private val accountService: AccountService
) : ViewModel() {
    var passwordRecoverUiState = mutableStateOf(PasswordRecoverUiState())
        private set

    private val email get() = passwordRecoverUiState.value.email

    fun onPasswordRecoverEmailChange(newValue: String) {
        passwordRecoverUiState.value = passwordRecoverUiState.value.copy(email = newValue)
    }

    fun onRecoverPasswordClick(navigate: (String) -> Unit) {
        viewModelScope.launch {
            accountService.sendRecoveryEmail(email) { error ->
                if(error == null) {
                    navigate(Graph.HOME)
                } else {
                    /* TODO */
                }
            }
        }
    }
}