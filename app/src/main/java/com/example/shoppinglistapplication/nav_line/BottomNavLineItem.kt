package com.example.shoppinglistapplication.nav_line

import com.example.shoppinglistapplication.R

sealed class BottomNavLineItem(
        val title : String,
        val iconId : Int,
        val route : String
) {
    object ListItem : BottomNavLineItem("List", R.drawable.ic_add, "route_1")
    object NoteItem : BottomNavLineItem("Note", R.drawable.ic_add, "route_2")
    object AboutItem : BottomNavLineItem("About", R.drawable.ic_add, "route_3")
    object SettingsItem : BottomNavLineItem("Settings", R.drawable.ic_add, "route_4")
}