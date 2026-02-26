package com.example.shoppinglistapplication.data.repository

import com.example.shoppinglistapplication.data.entity.AddItemTableEntity
import com.example.shoppinglistapplication.data.entity.ShoppingListTableEntity
import kotlinx.coroutines.flow.Flow

interface AddItemRepository {
    suspend fun insertItem(item: AddItemTableEntity)
    suspend fun deleteItem(item: AddItemTableEntity)
    fun getAllItemsById(listId : Int) : Flow<List<AddItemTableEntity>>
    suspend fun getListItemById(listId : Int) : ShoppingListTableEntity
    suspend fun insertItem(item: ShoppingListTableEntity)
}