package com.example.todolist.ViewModel.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.Model.Repository.TodoRepository
import com.example.todolist.Model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {
    var mTodos by mutableStateOf(emptyList<Todo>())
    var mTodo by mutableStateOf(Todo(0,"",""))
    var isDialogOpen by mutableStateOf(false)

    fun getAllTodos() = viewModelScope.launch {
        repository.mGetAllTodosRepo().collect{
            mTodos = it
        }
    }

    fun getSingleTodo(id : Int) = viewModelScope.launch {
        repository.mGetTodoByIdRepo(id).collect{
            mTodo = it
        }
    }

    fun updateTitle(title : String){
        mTodo = mTodo.copy(mTitle = title)
    }

    fun updateAuthor(author : String){
        mTodo = mTodo.copy(mAuthor = author)
    }

    fun addTodo(todo: Todo) = viewModelScope.launch (Dispatchers.IO){
        repository.mInsertTodoRepo(todo)
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.mUpdateTodoRepo(todo)
    }

    fun deleteTodo (todo: Todo) = viewModelScope.launch(Dispatchers.IO){
        repository.mDeleteTodoRepo(todo)
    }

}