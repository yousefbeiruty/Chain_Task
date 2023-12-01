package com.example.chainTask.screens.splash

sealed class SplashNavigationViewState {
    object NavigateToMain : SplashNavigationViewState()
    object NavigateToLogin : SplashNavigationViewState()
}