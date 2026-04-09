package com.example.shoppinglistapplication.roomData.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingListTableDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertItem(item: ShoppingListTableEntity)
    @Delete
    suspend fun deleteItem(item: ShoppingListTableEntity)
    @Query("DELETE FROM added_item_table WHERE listId = :listId")
    suspend fun deleteAddedItems( listId : Int)
    @Query("SELECT * FROM shop_list_table")
    // FLOW корутина которая следит за обновлением в БД , не нужно каждый раз вызывать функцию
    fun getAllItems() : Flow<List<ShoppingListTableEntity>>

    // для запуска нескольких функций
    @Transaction
    suspend fun deleteShoppingListAndAddedItems(item: ShoppingListTableEntity) {
         deleteAddedItems(item.id!!)
        deleteItem(item)
    }
}