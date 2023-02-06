package com.cleverlycode.vibes.screens.signup

import androidx.annotation.StringRes

data class SignUpUiState(
    val firstName: String = "",
    val isFirstNameError: Boolean = false,
    val firstNameErrorMsg: String = "",
    val lastName: String = "",
    val isLastNameError: Boolean = false,
    val lastNameErrorMsg: String = "",
    val email: String = "",
    val isEmailError: Boolean = false,
    @StringRes val emailErrorMsgResId: Int? = null,
    val password: String = "",
    val isPasswordError: Boolean = false,
    @StringRes val passwordErrorMsgResId: Int? = null,
    val confirmPassword: String = "",
    val isConfirmPasswordError: Boolean = false,
    @StringRes val confirmPasswordErrorMsgResId: Int? = null,
    val isPasswordVisible: Boolean = false,
    val isConfirmPasswordVisible: Boolean = false,
    val isButtonEnabled: Boolean = firstName.isNotEmpty() && lastName.isNotEmpty()
            && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()
)