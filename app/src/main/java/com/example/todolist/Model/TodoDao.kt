package com.example.todolist.Model

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table ORDER BY mId ASC")
    fun getAllTodos(): Flow<List<Todo>>

    @Query("SELECT * FROM todo_table WHERE mId =:id")
    fun getTodoById(id: Int): Flow<Todo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(todo: Todo)

    @Update
    fun updateTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)

}