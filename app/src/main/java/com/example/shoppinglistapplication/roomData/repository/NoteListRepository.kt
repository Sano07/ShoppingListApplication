package com.example.shoppinglistapplication.roomData.repository

import com.example.shoppinglistapplication.roomData.entity.NoteItemTableEntity
import kotlinx.coroutines.flow.Flow

interface NoteListRepository {
    suspend fun insertItem(item: NoteItemTableEntity)
    suspend fun deleteItem(item: NoteItemTableEntity)
    fun getAllItems() : Flow<List<NoteItemTableEntity>>
    suspend fun getNoteItemById(id : Int) : NoteItemTableEntity
}