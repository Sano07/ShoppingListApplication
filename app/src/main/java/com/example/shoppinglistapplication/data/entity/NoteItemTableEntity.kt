package com.example.shoppinglistapplication.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_item_table")
data class NoteItemTableEntity(
    @PrimaryKey
    val id : Int? = null,
    val title : String,
    val desc : String,
    val time : String
)