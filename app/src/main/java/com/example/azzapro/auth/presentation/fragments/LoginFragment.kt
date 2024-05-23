package com.example.azzapro.auth.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.azzapro.R
import com.example.azzapro.auth.presentation.sealed.LoginUiEvent
import com.example.azzapro.auth.presentation.vm.LoginViewModel
import com.example.azzapro.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    private val viewModel: LoginViewModel by viewModels()
    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            confirmPhoneBtn.setOnClickListener { viewModel.uIEvent(LoginUiEvent.OnLoginButtonClicked) }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.loginUiEvent.collect {
                when (it) {
                    is LoginUiEvent.OnLoginButtonClicked -> {
                        findNavController().navigate(R.id.action_loginFragment_to_codeConfirmFragment)
                    }
                    is LoginUiEvent.NothingState -> {}
                }
            }
        }
    }
}