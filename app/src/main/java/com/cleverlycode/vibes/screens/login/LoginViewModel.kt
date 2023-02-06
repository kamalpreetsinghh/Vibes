package com.cleverlycode.vibes.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleverlycode.vibes.R
import com.cleverlycode.vibes.data.service.AccountService
import com.cleverlycode.vibes.nav_graphs.AuthRoutes
import com.cleverlycode.vibes.nav_graphs.Graph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
//    private val accountService: AccountService,
) : ViewModel() {
    var loginUiState = mutableStateOf(LoginUiState())
        private set

    private val email get() = loginUiState.value.email
    private val password get() = loginUiState.value.password

    fun onEmailChange(newValue: String) {
        loginUiState.value = loginUiState.value.copy(email = newValue)
        enableOrDisableButton()
        loginUiState.value = loginUiState.value.copy(
            isEmailError = false,
            emailErrorMsgResId = null
        )
    }

    fun onPasswordChange(newValue: String) {
        loginUiState.value = loginUiState.value.copy(password = newValue)
        enableOrDisableButton()
        loginUiState.value = loginUiState.value.copy(
            isPasswordError = false,
            passwordErrorMsgResId = null
        )
    }

    fun togglePasswordIcon() {
        loginUiState.value =
            loginUiState.value.copy(isPasswordVisible = !loginUiState.value.isPasswordVisible)
    }

    fun onSignInClick(navigate: (String) -> Unit) {
        viewModelScope.launch {
//            accountService.signInWithEmailAndPassword(email, password) { error ->
//                if (error == null) {
//                    navigate(Graph.HOME)
//                } else {
//                    showIncorrectLoginDetailsMsg()
//                }
//            }
        }
    }

    fun onForgotPasswordClick(navigate: (String) -> Unit) {
        navigate(AuthRoutes.PasswordRecover.route)
    }

    private fun enableOrDisableButton() {
        loginUiState.value =
            loginUiState.value.copy(isButtonEnabled = isButtonEnabled())
    }

    private fun isButtonEnabled() = email.isNotEmpty() && password.isNotEmpty()

    private fun showIncorrectLoginDetailsMsg() {
        loginUiState.value = loginUiState.value.copy(
            isEmailError = true,
            isPasswordError = true,
            passwordErrorMsgResId = R.string.error_incorrect_credentials
        )
    }
}