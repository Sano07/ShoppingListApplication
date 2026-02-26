package com.example.shoppinglistapplication.data.repoImpl

import com.example.shoppinglistapplication.data.entity.AddItemTableEntity
import com.example.shoppinglistapplication.data.entity.ShoppingListTableEntity
import com.example.shoppinglistapplication.data.repository.AddItemRepository
import com.example.shoppinglistapplication.data.dao.AddItemDao
import kotlinx.coroutines.flow.Flow

class AddItemRepoImpl(
    private val dao : AddItemDao
) : AddItemRepository {
    override suspend fun insertItem(item: AddItemTableEntity) {
        dao.insertItem(item)
    }
    override suspend fun deleteItem(item: AddItemTableEntity) {
        dao.deleteItem(item)
    }
    override fun getAllItemsById(listId: Int): Flow<List<AddItemTableEntity>> {
        return dao.getAllItemsById(listId)
    }
    override suspend fun getListItemById(listId: Int): ShoppingListTableEntity {
        return dao.getListItemById(listId)
    }
    override suspend fun insertItem(item: ShoppingListTableEntity) {
        dao.insertItem(item)
    }
}