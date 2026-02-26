package com.example.shoppinglistapplication.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoppinglistapplication.data.entity.AddItemTableEntity
import com.example.shoppinglistapplication.data.entity.ShoppingListTableEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AddItemDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertItem(item: AddItemTableEntity)
    @Delete
    suspend fun deleteItem(item: AddItemTableEntity)
    @Query("SELECT * FROM add_item_table where listId = :listId")
    fun getAllItemsById(listId : Int) : Flow<List<AddItemTableEntity>>
    @Query("SELECT * FROM shop_list_table where id = :listId")
    suspend fun getListItemById(listId : Int) : ShoppingListTableEntity
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertItem(item: ShoppingListTableEntity)
}