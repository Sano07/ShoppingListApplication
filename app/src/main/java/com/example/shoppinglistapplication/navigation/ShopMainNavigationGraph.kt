package com.example.shoppinglistapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoppinglistapplication.added_item_screen.AddItemScreen
import com.example.shoppinglistapplication.shop_main_screen.ShopMainScreen
import com.example.shoppinglistapplication.new_note_screen.NewNoteScreen
import com.example.shoppinglistapplication.utils.Routes

@Composable
fun ShopMainNavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Routes.MAIN_SCREEN ) {

        composable(Routes.ADDED_ITEM + "/{listId}") {
            AddItemScreen()
        }
        composable(Routes.NEW_NOTE) {
            NewNoteScreen()
        }
        composable(Routes.MAIN_SCREEN) {
            ShopMainScreen(navController)
        }
    }
}