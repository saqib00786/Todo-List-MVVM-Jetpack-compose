package com.example.todolist.ViewModel.add_edit_task.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todolist.Model.Todo
import com.example.todolist.ViewModel.main_screen.HomeScreenViewModel

@Composable
fun UpdateTodoContent(
    values: PaddingValues,
    todoId: Int,
    navigateToHomeScreen: () -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val title = viewModel.mTodo.mTitle
    val author = viewModel.mTodo.mAuthor
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(values),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = title,
            onValueChange = { title ->
                viewModel.updateTitle(title)
            },
            shape = RoundedCornerShape(50),

            placeholder = {
                Text(text = "Title")

            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )

        TextField(
            value = author, onValueChange = { author ->
                viewModel.updateAuthor(author)
            },
            shape = RoundedCornerShape(50),
            placeholder = {
                Text(text = "Author")
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
        )

        Button(onClick = {
            val updateTodo = Todo(todoId, title, author)
            viewModel.updateTodo(updateTodo)
            navigateToHomeScreen()
        },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.1f),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiaryContainer)
            ) {
            Text(text = "Update",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}