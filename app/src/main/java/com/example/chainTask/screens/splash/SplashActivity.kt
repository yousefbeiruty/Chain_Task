package com.example.chaintask.screens.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.chaintask.R
import com.example.chaintask.common.BaseBindingActivity
import com.example.chaintask.compose.ComposeMainActivity
import com.example.chaintask.databinding.ActivityAuthBinding
import com.example.chaintask.databinding.ActivitySplashBinding
import com.example.chaintask.extensions.collectLatest
import com.example.chaintask.screens.auth.AuthActivity
import com.example.chaintask.screens.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashActivity : BaseBindingActivity<ActivitySplashBinding>(R.layout.activity_splash)  {
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