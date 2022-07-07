package com.example.todolist.ViewModel.add_edit_task

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todolist.ViewModel.add_edit_task.components.UpdateTodoContent
import com.example.todolist.ViewModel.add_edit_task.components.UpdateTodoTopBar
import com.example.todolist.ViewModel.main_screen.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditScreen(
    todoId : Int,
    navigateToHomeScreen : () -> Unit,
    viewModel : HomeScreenViewModel = hiltViewModel()
){
    LaunchedEffect(Unit){
        viewModel.getSingleTodo(todoId)
    }

    Scaffold(
        topBar = {
           UpdateTodoTopBar(
                navigateToHomeScreen = navigateToHomeScreen
            )
        },
        content = { values ->
            UpdateTodoContent(
                values = values,
                todoId = todoId,
                navigateToHomeScreen = navigateToHomeScreen
            )

        }
    )
}