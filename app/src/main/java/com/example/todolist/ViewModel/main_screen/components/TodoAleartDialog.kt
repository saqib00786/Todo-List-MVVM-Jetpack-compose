package com.example.todolist.ViewModel.main_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.example.todolist.Model.Todo
import kotlinx.coroutines.job

@Composable
fun AddTodoAleartDialog(
    closeDialogfn: () -> Unit,
    insertTodo: (todo: Todo) -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }

    var author by remember {
        mutableStateOf("")
    }

    val focusRequester = FocusRequester()

    AlertDialog(onDismissRequest = {
        closeDialogfn
    },
        title = {
            Text("Add Todo")
        },
        text = {
            Column {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    placeholder = {
                        Text(
                            text = "Title"
                        )
                    },
                    modifier = Modifier.focusRequester(focusRequester)
                )

                LaunchedEffect(Unit) {
                    coroutineContext.job.invokeOnCompletion {
                        focusRequester.requestFocus()
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = author,
                    onValueChange = { author = it },
                    placeholder = {
                        Text(
                            text = "Author"
                        )
                    }
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                closeDialogfn()
                val todo = Todo(0,title,author)
                insertTodo(todo)
            }) {
                Text(text = "Add")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                closeDialogfn()
            }) {
                Text(text = "Dismiss")
            }
        }
    )
}