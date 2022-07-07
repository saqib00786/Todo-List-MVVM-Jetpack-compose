package com.example.todolist.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist.Model.Repository.TodoRepository
import com.example.todolist.Model.Repository.TodoRepositoryImpl
import com.example.todolist.Model.TodoDao
import com.example.todolist.Model.TodoDatabaseApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TodoAppModule {
/*
    @Provides
    fun getDBApp(application: Application): TodoDatabaseApp {
        return Room.databaseBuilder(
            application,
            TodoDatabaseApp::class.java,
            "Todo_DB"
        ).build()
    }

    @Provides
    fun getDao(todoDatabaseApp: TodoDatabaseApp): TodoDao {
        return todoDatabaseApp.todoDao()
    }


    @Provides
    fun getRepository(todoDao: TodoDao): TodoRepository {
        return TodoRepositoryImpl(todoDao)
    }*/

    @Provides
    fun getDBApp(
        @ApplicationContext
        context : Context
    ) = Room.databaseBuilder(
        context,
        TodoDatabaseApp::class.java,
        "todo_Database"
    ).build()

    @Provides
    fun provideTodoDao(
        todoDatabaseApp: TodoDatabaseApp
    ) = todoDatabaseApp.todoDao()

    @Provides
    fun provideTodoRepository(
        todoDao: TodoDao
    ) : TodoRepository = TodoRepositoryImpl(todoDao)
}