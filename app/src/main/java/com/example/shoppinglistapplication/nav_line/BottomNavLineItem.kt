package com.example.shoppinglistapplication.nav_line

import com.example.shoppinglistapplication.R

sealed class BottomNavLineItem(
        val title : String,
        val iconId : Int,
        val route : String
) {
    object ListItem : BottomNavLineItem("List", R.drawable.ic_add, "list_screen")
    object NoteItem : BottomNavLineItem("Note", R.drawable.ic_note, "note_screen")
    object AboutItem : BottomNavLineItem("About", R.drawable.ic_about, "about_screen")
    object SettingsItem : BottomNavLineItem("Settings", R.drawable.ic_settings, "settings_screen")
}