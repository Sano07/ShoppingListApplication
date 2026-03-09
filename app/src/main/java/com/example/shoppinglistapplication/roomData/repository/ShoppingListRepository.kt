package com.example.shoppinglistapplication.roomData.repository

import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import kotlinx.coroutines.flow.Flow

// репозиторий с перечнем функций выполняемых в Активити, к нему будет образаться Вью модел + будет реализация в Модуле ДАГЕР ХИЛТ
interface ShoppingListRepository {
    suspend fun insertItem(item: ShoppingListTableEntity)
    suspend fun deleteItem(item: ShoppingListTableEntity)
    fun getAllItems() : Flow<List<ShoppingListTableEntity>>
}