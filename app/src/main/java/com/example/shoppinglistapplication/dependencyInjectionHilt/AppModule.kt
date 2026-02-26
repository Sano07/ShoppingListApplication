package com.example.shoppinglistapplication.dependencyInjectionHilt

import android.app.Application
import androidx.room.Room
import com.example.shoppinglistapplication.data.MainDB
import com.example.shoppinglistapplication.data.repoImpl.AddItemRepoImpl
import com.example.shoppinglistapplication.data.repoImpl.NoteListRepoImpl
import com.example.shoppinglistapplication.data.repoImpl.ShoppingListRepoImpl
import com.example.shoppinglistapplication.data.repository.AddItemRepository
import com.example.shoppinglistapplication.data.repository.NoteListRepository
import com.example.shoppinglistapplication.data.repository.ShoppingListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//модуль для даггер хилт
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // инициализация базы данных
    @Provides
    @Singleton
    fun provideMainDb(app: Application) : MainDB {
        return Room.databaseBuilder(
            app,
            MainDB::class.java,
            "shop_list_db"
        ).build()
    }

    // инициализация репозиториев

    @Provides
    @Singleton
    fun provideShopRepo(db : MainDB) : ShoppingListRepository {
        return ShoppingListRepoImpl(db.shoppingListTableDao)
    }

    @Provides
    @Singleton
    fun provideAddItemRepo(db : MainDB) : AddItemRepository {
        return AddItemRepoImpl(db.addItemDao)
    }

    @Provides
    @Singleton
    fun provideNodeItemRepo(db : MainDB) : NoteListRepository {
        return NoteListRepoImpl(db.noteItemDao)
    }
}