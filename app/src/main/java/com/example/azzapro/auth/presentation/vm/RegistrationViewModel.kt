package com.example.azzapro.auth.presentation.vm

import androidx.lifecycle.ViewModel
import com.example.azzapro.auth.presentation.sealed.RegistrationUiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegistrationViewModel: ViewModel() {

    private val channel = MutableStateFlow<RegistrationUiEvent>(RegistrationUiEvent.NothingState)
    val registrationUiEvent = channel.asStateFlow()

    private fun onConfirmClicked() {
        channel.value = RegistrationUiEvent.OnConfirmClicked
    }
    private fun onBackClicked() {
        channel.value = RegistrationUiEvent.OnBackPressed
    }

    fun uIEvent(event: RegistrationUiEvent) {
        when(event) {
            is RegistrationUiEvent.OnConfirmClicked -> { onConfirmClicked() }
            is RegistrationUiEvent.OnBackPressed -> { onBackClicked() }
            is RegistrationUiEvent.NothingState -> {  }
        }
    }

}