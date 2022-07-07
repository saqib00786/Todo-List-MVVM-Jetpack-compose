package com.example.todolist.Model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabaseApp : RoomDatabase() {
    abstract fun todoDao() : TodoDao
}