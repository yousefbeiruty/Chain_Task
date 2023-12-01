package com.example.chainTask.screens.main.ui.more

sealed class MoreViewState {

    object NavigateToSettings :MoreViewState()
    object LogoutUser:MoreViewState()
}
