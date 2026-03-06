package com.example.shoppinglistapplication.roomData.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_list_table")
data class ShoppingListTableEntity(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val time: String,
    val allItemsCount : Int,
    val allSelectedItemsCount: Int
)