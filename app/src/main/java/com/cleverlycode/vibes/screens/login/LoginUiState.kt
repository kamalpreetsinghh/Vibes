package com.cleverlycode.vibes.screens.login

import androidx.annotation.StringRes

data class LoginUiState(
    val email: String = "",
    val isEmailError: Boolean = false,
    @StringRes val emailErrorMsgResId: Int? = null,
    val password: String = "",
    val isPasswordError: Boolean = false,
    @StringRes val passwordErrorMsgResId: Int? = null,
    val isButtonEnabled: Boolean = email.isNotEmpty() && password.isNotEmpty(),
    val isPasswordVisible: Boolean = false
)
