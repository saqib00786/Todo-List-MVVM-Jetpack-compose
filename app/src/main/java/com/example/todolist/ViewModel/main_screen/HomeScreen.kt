package com.example.todolist.ViewModel.main_screen

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todolist.ViewModel.main_screen.components.AddTodoAleartDialog
import com.example.todolist.ViewModel.main_screen.components.TodoAppBar
import com.example.todolist.ViewModel.main_screen.components.TodoContent
import com.example.todolist.ViewModel.main_screen.components.TodoFloatingActionBtn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navigateToAddEditScreen: (todoId: Int) -> Unit
) {
    val mDialogIsOpen = viewModel.isDialogOpen

    fun mDialogOpen() {
        viewModel.isDialogOpen = true
    }

    fun mDialogClose() {
        viewModel.isDialogOpen = false
    }

    LaunchedEffect(Unit) {
        viewModel.getAllTodos()
    }
    Scaffold(
        Modifier.background(MaterialTheme.colorScheme.onPrimary),
        topBar = {
            TodoAppBar()
        },
        floatingActionButton = {
            TodoFloatingActionBtn(
                openDialog = {
                    mDialogOpen()
                }
            )
        },
        content = { padding ->
            TodoContent(
                padding = padding,
                navigateToAddEditScreen = navigateToAddEditScreen
            )

            if (mDialogIsOpen) {
                AddTodoAleartDialog(
                    closeDialogfn = {
                        mDialogClose()
                    },
                    insertTodo = { todo ->
                        viewModel.addTodo(todo)
                    }
                )
            }
        }

    )

}

