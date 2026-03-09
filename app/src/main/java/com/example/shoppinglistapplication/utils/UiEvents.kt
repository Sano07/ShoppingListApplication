package com.example.shoppinglistapplication.utils

// обработка ивентов в UI , навигация, показ инфо сообщений  и тд
sealed class UiEvents {
    object popBackStack: UiEvents()
    data class navigate(val route : String) : UiEvents()
    data class showSnackBar(val exception: String) : UiEvents()
}