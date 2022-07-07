package com.example.todolist.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val mId : Int,
    val mTitle : String,
    val mAuthor : String
)
