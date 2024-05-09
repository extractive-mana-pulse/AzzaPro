package com.example.azzapro.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            codeConfirmContainer.setOnClickListener {
                it.showKeyboard()
            }
            back.setOnClickListener { findNavController().popBackStack() }
        }
    }
}