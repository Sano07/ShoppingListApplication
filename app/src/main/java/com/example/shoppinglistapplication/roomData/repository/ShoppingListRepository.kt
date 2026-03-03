package com.example.shoppinglistapplication.roomData.repository

import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import kotlinx.coroutines.flow.Flow

// репозиторий в который обращается вью модел
interface ShoppingListRepository {
    suspend fun insertItem(item: ShoppingListTableEntity)
    suspend fun deleteItem(item: ShoppingListTableEntity)
    fun getAllItems() : Flow<List<ShoppingListTableEntity>>
}