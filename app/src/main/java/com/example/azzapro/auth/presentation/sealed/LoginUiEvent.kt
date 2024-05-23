package com.example.azzapro.auth.presentation.sealed

sealed class LoginUiEvent {

    data object OnLoginButtonClicked : LoginUiEvent()
    data object NothingState: LoginUiEvent()
}