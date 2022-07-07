package com.example.todolist.Model.Repository

import com.example.todolist.Model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun mGetAllTodosRepo(): Flow<List<Todo>>

    suspend fun mGetTodoByIdRepo(id: Int): Flow<Todo>

    suspend fun mInsertTodoRepo(todo: Todo)

    suspend fun mUpdateTodoRepo(todo: Todo)

    suspend fun mDeleteTodoRepo(todo: Todo)

}