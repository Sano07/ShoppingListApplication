package com.example.shoppinglistapplication.nav_line

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavLine() {

    val listItems = listOf(BottomNavLineItem.ListItem, BottomNavLineItem.NoteItem, BottomNavLineItem.AboutItem, BottomNavLineItem.SettingsItem)

    BottomNavigation(backgroundColor = Color.Gray) {

    }
}