package com.example.shoppinglistapplication.dependencyInjectionHilt

import android.app.Application
import androidx.room.Room
import com.example.shoppinglistapplication.roomData.MainDB
import com.example.shoppinglistapplication.roomData.repoImpl.AddItemRepoImpl
import com.example.shoppinglistapplication.roomData.repoImpl.NoteListRepoImpl
import com.example.shoppinglistapplication.roomData.repoImpl.ShoppingListRepoImpl
import com.example.shoppinglistapplication.roomData.repository.AddItemRepository
import com.example.shoppinglistapplication.roomData.repository.NoteListRepository
import com.example.shoppinglistapplication.roomData.repository.ShoppingListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//модуль для даггер хилт
// эти функции не используем, использует ДАГЕР ХИЛТ под капотом
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // инициализация базы данных
    @Provides
    @Singleton
    fun provideMainDb(app: Application) : MainDB {  // функция возвращает инициализированную БД
        return Room.databaseBuilder(
            app,                                   // контекст Арр для построения БД
            MainDB::class.java,                    // класс со структурой БД , таблицами и ДАО ( описаные запросы к БД )
            "shop_list_db"                   // название БД
        ).build()
    }

    // инициализация репозиториев для которого выше инициализировали БД ,
    // для репозиториев нужна БД

    @Provides
    @Singleton
    fun provideShopRepo(db : MainDB) : ShoppingListRepository {  // инициализация репозитория
        return ShoppingListRepoImpl(db.shoppingListTableDao)     // для имплементации репозитория нужен ДАО
    }                                                            // он есть в БД, которую инициализировали выше

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