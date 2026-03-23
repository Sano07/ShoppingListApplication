package com.example.shoppinglistapplication.roomData.repoImpl

import com.example.shoppinglistapplication.roomData.entity.AddedItemTableEntity
import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import com.example.shoppinglistapplication.roomData.repository.AddedItemRepository
import com.example.shoppinglistapplication.roomData.dao.AddedItemDao
import kotlinx.coroutines.flow.Flow

class AddedItemRepoImpl(
    private val dao : AddedItemDao
) : AddedItemRepository {
    override suspend fun insertItem(item: AddedItemTableEntity) {
        dao.insertItem(item)
    }
    override suspend fun deleteItem(item: AddedItemTableEntity) {
        dao.deleteItem(item)
    }
    override fun getAllItemsById(listId: Int): Flow<List<AddedItemTableEntity>> {
        return dao.getAllItemsById(listId)
    }
    override suspend fun getListItemById(listId: Int): ShoppingListTableEntity {
        return dao.getListItemById(listId)
    }
    override suspend fun insertItem(item: ShoppingListTableEntity) {
        dao.insertItem(item)
    }
}