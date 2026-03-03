package com.example.shoppinglistapplication.roomData.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "add_item_table")
data class AddItemTableEntity(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val isChecked : Boolean,
    val listId : Int
)