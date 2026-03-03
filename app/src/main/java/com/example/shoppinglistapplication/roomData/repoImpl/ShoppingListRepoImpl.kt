package com.example.shoppinglistapplication.roomData.repoImpl

import com.example.shoppinglistapplication.roomData.repository.ShoppingListRepository
import com.example.shoppinglistapplication.roomData.dao.ShoppingListTableDao
import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import kotlinx.coroutines.flow.Flow

// имплементация репозитория в который обращается репозиторий, в который обращается вью модел
class ShoppingListRepoImpl(
    private val dao: ShoppingListTableDao
) : ShoppingListRepository {
    override suspend fun insertItem(item: ShoppingListTableEntity) {
        dao.insertItem(item)
    }
    override suspend fun deleteItem(item: ShoppingListTableEntity) {
        dao.deleteItem(item)
    }
    override fun getAllItems(): Flow<List<ShoppingListTableEntity>> {
        return dao.getAllItems()
    }

}