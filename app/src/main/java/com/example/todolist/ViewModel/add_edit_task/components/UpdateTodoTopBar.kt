package com.example.todolist.ViewModel.add_edit_task.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UpdateTodoTopBar(
    navigateToHomeScreen : () -> Unit
){
    SmallTopAppBar(
    title = {
        Text(
            text = "Edit & Update Todo"
        )
    },
    navigationIcon = {
        IconButton(
            onClick = {
                navigateToHomeScreen()
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "Back",
            )
        }
    },
)
}