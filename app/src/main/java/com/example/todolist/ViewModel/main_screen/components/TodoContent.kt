package com.example.todolist.ViewModel.main_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todolist.ViewModel.main_screen.HomeScreenViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TodoContent(
    padding: PaddingValues,
    navigateToAddEditScreen: (bookId: Int) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
    ) {
        LazyColumn {
            items(
                items =viewModel.mTodos
            ) { todo ->
                TodoCard(
                    todo = todo,
                    deleteTodo = {
                        viewModel.deleteTodo(todo)
                    },
                    navigateToAddEditScreen = navigateToAddEditScreen
                )
            }
        }
    }
}