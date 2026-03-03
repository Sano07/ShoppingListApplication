package com.example.shoppinglistapplication.shop_list_screen

import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity

// перечень событий которые используются на экране Shopping List Screen , каждое действие наследуется от класса событий
sealed class ShoppingListEvent {
    data class onShowDeleteDialog(val item : ShoppingListTableEntity) : ShoppingListEvent()
    data class onShowEditDialog(val item : ShoppingListTableEntity) : ShoppingListEvent()
    data class onShowItemClick(val item : ShoppingListTableEntity) : ShoppingListEvent()
    // при сохранении все данные берутся из ViewModel , название которое указывается в диалоговом окне напрямую отправляется в ViewModel
    object OnItemSave : ShoppingListEvent()
}

