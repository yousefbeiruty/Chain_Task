package com.example.chaintask.screens.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.chaintask.R
import com.example.chaintask.common.BaseFragment
import com.example.chaintask.databinding.FragmentLoginBinding
import com.example.chaintask.extensions.collectLatest
import com.example.chaintask.screens.auth.signup.ValidationFactory
import com.example.chaintask.screens.auth.signup.ValidationViewState
import com.example.chaintask.screens.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataBinding()
        collectLatest(viewModel.loginSuccess, ::handleLoginSuccess)
        collectLatest(viewModel.state, ::handleViewState)
        collectLatest(viewModel.validationError, ::handleValidationError)
    }

    private fun initDataBinding() {
        viewBinding?.viewModel = viewModel
    }

    private fun handleLoginSuccess(loggedIn: Boolean?) {
        startActivity(Intent(requireContext(), MainActivity::class.java))
        requireActivity().finish()
    }

    private fun handleValidationError(validationError: ValidationViewState) {
        ValidationFactory.validate(validationError, requireContext())
    }
}