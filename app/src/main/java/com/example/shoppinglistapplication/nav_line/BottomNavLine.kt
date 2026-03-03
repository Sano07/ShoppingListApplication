package com.example.shoppinglistapplication.nav_line

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.shoppinglistapplication.ui.theme.GreyUnselected
import com.example.shoppinglistapplication.ui.theme.Orange
import com.example.shoppinglistapplication.ui.theme.White_2

@Composable
fun BottomNavLine() {

    val listItems = listOf(BottomNavLineItem.ListItem, BottomNavLineItem.NoteItem, BottomNavLineItem.AboutItem, BottomNavLineItem.SettingsItem)

    BottomNavigation(backgroundColor = White_2){
        listItems.forEach { item ->
            BottomNavigationItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(painter = painterResource(id = item.iconId), contentDescription = "icon")
                },
                label = {
                    Text(text = item.title)
                },
                selectedContentColor = Orange,
                unselectedContentColor = GreyUnselected,
                alwaysShowLabel = false

            )
        }
    }
}