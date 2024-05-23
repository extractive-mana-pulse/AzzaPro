package com.example.azzapro.auth.presentation.vm

import androidx.lifecycle.ViewModel
import com.example.azzapro.auth.presentation.sealed.LoginUiEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel: ViewModel() {

    private val channel = MutableStateFlow<LoginUiEvent>(LoginUiEvent.NothingState)
    val loginUiEvent = channel.asStateFlow()

    private fun onLoginPressed() {
        channel.value = LoginUiEvent.OnLoginButtonClicked
    }

    fun uIEvent(event: LoginUiEvent) {
        when(event) {
            is LoginUiEvent.OnLoginButtonClicked -> { onLoginPressed() }
            is LoginUiEvent.NothingState -> {  }
        }
    }
}