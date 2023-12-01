package com.example.chainTask.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.chainTask.R
import com.example.chainTask.common.BaseBindingActivity
import com.example.chainTask.databinding.ActivitySplashBinding
import com.example.chainTask.screens.auth.AuthActivity
import com.example.chainTask.screens.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashActivity : BaseBindingActivity<ActivitySplashBinding>(
    R.layout.activity_splash)  {
    val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.isUserLoggedIn()
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
               // collectLatest(viewModel.navigateViewState, ::handleNavigation)
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }, 2000)
        }
    }

    private fun handleNavigation(splashNavigationViewState: SplashNavigationViewState) {
        when (splashNavigationViewState) {
            is SplashNavigationViewState.NavigateToMain -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
            is SplashNavigationViewState.NavigateToLogin -> {
                val intent = Intent(this, AuthActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }

        }
    }
}