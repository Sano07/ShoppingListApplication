package com.example.shoppinglistapplication.roomData

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shoppinglistapplication.roomData.dao.AddedItemDao
import com.example.shoppinglistapplication.roomData.dao.NoteItemDao
import com.example.shoppinglistapplication.roomData.dao.ShoppingListTableDao
import com.example.shoppinglistapplication.roomData.entity.AddedItemTableEntity
import com.example.shoppinglistapplication.roomData.entity.NoteItemTableEntity
import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity


@Database(
    entities = [AddedItemTableEntity::class, NoteItemTableEntity::class, ShoppingListTableEntity::class],
    version = 2
)
abstract class MainDB : RoomDatabase(){
    abstract val shoppingListTableDao: ShoppingListTableDao
    abstract val noteItemDao: NoteItemDao
    abstract val addedItemDao: AddedItemDao

}