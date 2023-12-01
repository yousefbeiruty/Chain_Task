package com.example.chainTask.screens.main.ui.more

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.chainTask.R
import com.example.chainTask.common.BaseFragment
import com.example.chainTask.databinding.FragmentMoreBinding
import com.example.chainTask.extensions.collectLatest
import com.example.chainTask.screens.auth.AuthActivity
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