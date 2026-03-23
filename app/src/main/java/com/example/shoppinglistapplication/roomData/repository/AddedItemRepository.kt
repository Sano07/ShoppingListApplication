package com.example.shoppinglistapplication.roomData.repository

import com.example.shoppinglistapplication.roomData.entity.AddedItemTableEntity
import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import kotlinx.coroutines.flow.Flow

interface AddedItemRepository {
    suspend fun insertItem(item: AddedItemTableEntity)
    suspend fun deleteItem(item: AddedItemTableEntity)
    fun getAllItemsById(listId : Int) : Flow<List<AddedItemTableEntity>>
    suspend fun getListItemById(listId : Int) : ShoppingListTableEntity
    suspend fun insertItem(item: ShoppingListTableEntity)
}