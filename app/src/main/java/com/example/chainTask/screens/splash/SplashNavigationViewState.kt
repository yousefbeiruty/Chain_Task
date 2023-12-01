package com.example.chaintask.screens.splash

sealed class SplashNavigationViewState {
    object NavigateToMain : SplashNavigationViewState()
    object NavigateToLogin : SplashNavigationViewState()
}