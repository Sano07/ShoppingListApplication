package com.example.shoppinglistapplication.data.repoImpl

import com.example.shoppinglistapplication.data.entity.NoteItemTableEntity
import com.example.shoppinglistapplication.data.repository.NoteListRepository
import com.example.shoppinglistapplication.data.dao.NoteItemDao
import kotlinx.coroutines.flow.Flow

class NoteListRepoImpl(
    private val dao : NoteItemDao
) : NoteListRepository {
    override suspend fun insertItem(item: NoteItemTableEntity) {
        dao.insertItem(item)
    }
    override suspend fun deleteItem(item: NoteItemTableEntity) {
        dao.deleteItem(item)
    }
    override fun getAllItems(): Flow<List<NoteItemTableEntity>> {
        return dao.getAllItems()
    }
    override suspend fun getNoteItemById(id: Int): NoteItemTableEntity {
        return dao.getNoteItemById(id)
    }

}