package com.example.chaintask.screens.main.ui.more

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.chaintask.R
import com.example.chaintask.common.BaseFragment
import com.example.chaintask.databinding.FragmentMoreBinding
import com.example.chaintask.extensions.collectLatest
import com.example.chaintask.screens.auth.AuthActivity
import com.example.domain.model.signup.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreFragment : BaseFragment<FragmentMoreBinding, MoreViewModel>(R.layout.fragment_more) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getUserDetails()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataBinding()
        collectLatest(viewModel.personalDetailsSuccess, ::handleUserDetailsSuccess)
        collectLatest(viewModel.state, ::handleViewState)
        viewLifecycleOwner.collectLatest(viewModel.viewState, ::handleMoreState)
    }

    private fun initDataBinding() {
        viewBinding?.viewModel = viewModel
    }

    private fun handleUserDetailsSuccess(user: User?) {
        viewBinding?.user = user
    }

    private fun handleMoreState(viewState: MoreViewState?) {
        when (viewState) {
            is MoreViewState.LogoutUser -> {
                startActivity(Intent(requireActivity(), AuthActivity::class.java))
                requireActivity().finish()
            }
            is MoreViewState.NavigateToSettings -> {
                findNavController().navigate(R.id.action_homeFragment_to_settingFragment)
            }
            else -> {}
        }
    }
}