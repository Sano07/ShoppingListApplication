package com.example.shoppinglistapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shoppinglistapplication.data.dao.AddItemDao
import com.example.shoppinglistapplication.data.dao.NoteItemDao
import com.example.shoppinglistapplication.data.dao.ShoppingListTableDao
import com.example.shoppinglistapplication.data.entity.AddItemTableEntity
import com.example.shoppinglistapplication.data.entity.NoteItemTableEntity
import com.example.shoppinglistapplication.data.entity.ShoppingListTableEntity


@Database(
    entities = [AddItemTableEntity::class, NoteItemTableEntity::class, ShoppingListTableEntity::class],
    version = 1
)
abstract class MainDB : RoomDatabase(){
    abstract val shoppingListTableDao: ShoppingListTableDao
    abstract val noteItemDao: NoteItemDao
    abstract val addItemDao: AddItemDao

}