package com.example.shoppinglistapplication.bottom_line

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shoppinglistapplication.ui.theme.GreyUnselected
import com.example.shoppinglistapplication.ui.theme.Orange
import com.example.shoppinglistapplication.ui.theme.White_2

@Composable
fun BottomNavLine(navController: NavHostController) {

    val listItems = listOf(BottomNavLineItem.ListItem, BottomNavLineItem.NoteItem, BottomNavLineItem.AboutItem, BottomNavLineItem.SettingsItem)

    BottomNavigation(backgroundColor = White_2){
        listItems.forEach { item ->

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = "icon",
                        tint = if (currentRoute == item.route) Orange else GreyUnselected
                    )
                },
                label = {
                    Text(text = item.title)
                },
                unselectedContentColor = GreyUnselected,
                alwaysShowLabel = false
            )
        }
    }
}