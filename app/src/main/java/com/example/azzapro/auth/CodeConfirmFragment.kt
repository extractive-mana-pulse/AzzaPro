package com.example.azzapro.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.fragment.findNavController
import com.example.azzapro.R
import com.example.azzapro.auth.util.showKeyboard
import com.example.azzapro.databinding.FragmentCodeConfirmBinding


class CodeConfirmFragment : Fragment() {

    private val binding by lazy { FragmentCodeConfirmBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            topAppBar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }

            confirmBtn.setOnClickListener {
                findNavController().navigate(R.id.action_codeConfirmFragment_to_homeFragment)
            }

        }
    }
}