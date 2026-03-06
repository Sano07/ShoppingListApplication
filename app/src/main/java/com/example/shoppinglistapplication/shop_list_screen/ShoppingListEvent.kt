package com.example.shoppinglistapplication.shop_list_screen

import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity

// перечень событий которые используются на экране Shopping List Screen , каждое действие наследуется от класса событий
sealed class ShoppingListEvent {
    data class onShowDeleteDialog(val item : ShoppingListTableEntity) : ShoppingListEvent()
    data class onShowEditDialog(val item : ShoppingListTableEntity) : ShoppingListEvent()
    // передается роут на экран который хочу открыть при нажатии на элемент
    data class onShowItemClick(val route: String) : ShoppingListEvent()
    // при сохранении все данные берутся из ViewModel , название которое указывается в диалоговом окне напрямую отправляется в ViewModel,
    // item заполняется в ViewModel при обработке ивента
    object OnItemSave : ShoppingListEvent()
}

