package com.example.shoppinglistapplication.shop_list_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppinglistapplication.dialog.MainAlertDialog

@Composable
fun ShoppingListScreen(
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    MainAlertDialog(viewModel)
}