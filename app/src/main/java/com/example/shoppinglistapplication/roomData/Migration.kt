package com.example.shoppinglistapplication.roomData

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {

        db.execSQL("ALTER TABLE add_item_table RENAME TO added_item_table")
    }
}