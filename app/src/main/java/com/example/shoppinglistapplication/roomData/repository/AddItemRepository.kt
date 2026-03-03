package com.example.shoppinglistapplication.roomData.repository

import com.example.shoppinglistapplication.roomData.entity.AddItemTableEntity
import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import kotlinx.coroutines.flow.Flow

interface AddItemRepository {
    suspend fun insertItem(item: AddItemTableEntity)
    suspend fun deleteItem(item: AddItemTableEntity)
    fun getAllItemsById(listId : Int) : Flow<List<AddItemTableEntity>>
    suspend fun getListItemById(listId : Int) : ShoppingListTableEntity
    suspend fun insertItem(item: ShoppingListTableEntity)
}