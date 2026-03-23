package com.example.shoppinglistapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shoppinglistapplication.about_screen.AboutScreen
import com.example.shoppinglistapplication.note_screen.NoteScreen
import com.example.shoppinglistapplication.settings_screen.SettingsScreen
import com.example.shoppinglistapplication.shopping_list_screen.ShoppingListScreen
import com.example.shoppinglistapplication.utils.Routes

@Composable
fun GeneralNavigationGraph(navController : NavHostController, onNavigate: (String) -> Unit) {

    NavHost(navController, startDestination = Routes.SHOPPING_LIST ) {

        composable(Routes.SHOPPING_LIST) {
            ShoppingListScreen() { route ->
                onNavigate(route)
            }
        }
        composable(Routes.NOTE_LIST) {
            NoteScreen()
        }
        composable(Routes.ABOUT) {
            AboutScreen()
        }
        composable(Routes.SETTINGS) {
            SettingsScreen()
        }
    }
}