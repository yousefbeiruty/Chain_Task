package com.example.chaintask.screens.main.ui.more

sealed class MoreViewState {

    object NavigateToSettings :MoreViewState()
    object LogoutUser:MoreViewState()
}
