package com.example.shoppinglistapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoppinglistapplication.add_item_screen.AddItemScreen
import com.example.shoppinglistapplication.main_screen.ShopListMainScreen
import com.example.shoppinglistapplication.new_note_screen.NewNoteScreen
import com.example.shoppinglistapplication.utils.Routes

@Composable
fun ShopListMainNavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Routes.MAIN_SCREEN ) {

        composable(Routes.ADD_ITEM) {
            AddItemScreen()
        }
        composable(Routes.NEW_NOTE) {
            NewNoteScreen()
        }
        composable(Routes.MAIN_SCREEN) {
            ShopListMainScreen(navController)
        }
    }
}