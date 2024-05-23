package com.example.azzapro.auth.presentation.sealed

sealed class RegistrationUiEvent {

    data object NothingState: RegistrationUiEvent()
    data object OnBackPressed: RegistrationUiEvent()
    data object OnConfirmClicked : RegistrationUiEvent()
}