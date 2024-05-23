package com.example.azzapro.auth.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.azzapro.R
import com.example.azzapro.auth.presentation.sealed.RegistrationUiEvent
import com.example.azzapro.auth.presentation.vm.RegistrationViewModel
import com.example.azzapro.databinding.FragmentCodeConfirmBinding

class CodeConfirmFragment : Fragment() {

    private val viewModel: RegistrationViewModel by viewModels()
    private val binding by lazy { FragmentCodeConfirmBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.apply {


            topAppBar.setNavigationOnClickListener { viewModel.uIEvent(RegistrationUiEvent.OnBackPressed) }

            confirmBtn.setOnClickListener { viewModel.uIEvent(RegistrationUiEvent.OnConfirmClicked) }

            lifecycleScope.launchWhenStarted {
                viewModel.registrationUiEvent.collect { event ->
                    when (event) {
                        is RegistrationUiEvent.OnConfirmClicked -> { findNavController().navigate(R.id.action_codeConfirmFragment_to_homeFragment) }

                        is RegistrationUiEvent.OnBackPressed -> { findNavController().navigate(R.id.action_codeConfirmFragment_to_loginFragment) }

                        is RegistrationUiEvent.NothingState -> {  }
                    }
                }
            }
        }
    }
}