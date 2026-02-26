package com.example.shoppinglistapplication.data.entity

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