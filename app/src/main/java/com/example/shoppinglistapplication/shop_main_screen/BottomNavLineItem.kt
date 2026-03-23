package com.example.shoppinglistapplication.shop_main_screen

import com.example.shoppinglistapplication.R
import com.example.shoppinglistapplication.utils.Routes

sealed class BottomNavLineItem(
        val title : String,
        val iconId : Int,
        val route : String
) {
    object ListItem : BottomNavLineItem("list", R.drawable.ic_list, Routes.SHOPPING_LIST)
    object NoteItem : BottomNavLineItem("note", R.drawable.ic_note, Routes.NOTE_LIST)
    object AboutItem : BottomNavLineItem("about", R.drawable.ic_about, Routes.ABOUT)
    object SettingsItem : BottomNavLineItem("settings", R.drawable.ic_settings, Routes.SETTINGS)
}