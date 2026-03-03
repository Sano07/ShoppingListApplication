package com.example.shoppinglistapplication.roomData.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppinglistapplication.roomData.entity.NoteItemTableEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: NoteItemTableEntity)
    @Delete
    suspend fun deleteItem(item: NoteItemTableEntity)
    @Query("SELECT * FROM note_item_table")
    fun getAllItems() : Flow<List<NoteItemTableEntity>>
    @Query("SELECT * FROM note_item_table where id = :id")
    suspend fun getNoteItemById(id : Int) : NoteItemTableEntity
}