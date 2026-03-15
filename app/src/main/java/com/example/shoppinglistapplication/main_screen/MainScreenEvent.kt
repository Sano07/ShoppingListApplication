package com.example.shoppinglistapplication.main_screen

import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import com.example.shoppinglistapplication.shop_list_screen.ShoppingListEvent

sealed class MainScreenEvent {
    object OnShowEditDialog : MainScreenEvent()
    object OnItemSave : MainScreenEvent()
}
