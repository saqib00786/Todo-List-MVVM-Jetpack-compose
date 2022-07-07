package com.example.todolist.Model.Repository

import com.example.todolist.Model.Todo
import com.example.todolist.Model.TodoDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class TodoRepositoryImpl(
   private val todoDao: TodoDao
) : TodoRepository {

    override suspend fun mGetAllTodosRepo(): Flow<List<Todo>> {
        return todoDao.getAllTodos()
    }

    override suspend fun mGetTodoByIdRepo(id: Int): Flow<Todo> {
        return todoDao.getTodoById(id)
    }

    override suspend fun mInsertTodoRepo(todo: Todo) {
        todoDao.insertTodo(todo)
    }

    override suspend fun mUpdateTodoRepo(todo: Todo) {
        todoDao.updateTodo(todo)
    }

    override suspend fun mDeleteTodoRepo(todo: Todo) {
        todoDao.deleteTodo(todo)
    }
}