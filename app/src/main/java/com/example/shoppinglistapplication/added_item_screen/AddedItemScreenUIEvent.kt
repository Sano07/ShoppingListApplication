package com.example.shoppinglistapplication.added_item_screen

import com.example.shoppinglistapplication.roomData.entity.AddedItemTableEntity

sealed class AddedItemScreenUIEvent {
    data class OnDelete(val item: AddedItemTableEntity) : AddedItemScreenUIEvent()
    data class OnShowEditDialog(val item: AddedItemTableEntity) : AddedItemScreenUIEvent()
    data class OnTextChange(val text: String) : AddedItemScreenUIEvent()
    data class OnCheckedChange(val item: AddedItemTableEntity) : AddedItemScreenUIEvent()
    object OnItemSave : AddedItemScreenUIEvent()
}