package com.example.shoppinglistapplication.shop_main_screen

sealed class ShopMainScreenEvent {
    object OnShowEditDialog : ShopMainScreenEvent()
    object OnItemSave : ShopMainScreenEvent()
}
