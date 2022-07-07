package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.example.todolist.Model.Todo
import com.example.todolist.ViewModel.main_screen.HomeScreen
import com.example.todolist.navigation.navGraph
import com.example.todolist.ui.theme.TodoListTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListTheme() {
                navGraph (
                   navController = rememberNavController()
               )
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
private fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {
    TodoListTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {

            var mTextSearch by remember { mutableStateOf("") }
            val mStateScroll = rememberLazyListState()
            val mContext = LocalContext.current
            val mList: State<List<Todo>> =
                viewModel.getAllTask.collectAsState(initial = listOf())
            val coroutineScope = rememberCoroutineScope()

            Column {
                Text(
                    text = "Todo List",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontStyle = FontStyle.Normal,
                    fontSize = 30.sp

                )

                TextField(
                    value = mTextSearch,
                    onValueChange = { mTextSearch = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 30.dp, bottom = 30.dp, end = 30.dp),
                    singleLine = true,
                    shape = RoundedCornerShape(50),
                    label = { Text(text = "Search Title") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search ICOn")
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        containerColor = MaterialTheme.colorScheme.onSecondary,
                        textColor = Color.White,
                        cursorColor = Color.White,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.LightGray,
                        focusedLeadingIconColor = Color.White,
                        unfocusedLeadingIconColor = Color.LightGray
                    )
                )

                LazyColumn(
                    state = mStateScroll
                ){
                    coroutineScope.launch {
                        mStateScroll.animateScrollToItem(0,0)
                    }
                    items(mList.value, key = {item -> item.mId!! }){ todo ->
                        var complite by remember {mutableStateOf(todo.mComplitable)}
                        if(mTextSearch.isEmpty()){
                            I
                        }
                        if (textSearch.isEmpty())
                            ItemTask(
                                task = task ,
                                isComplite = complite,
                                onCompliteChange = {
                                    complite = it
                                    task.complitable = !task.complitable
                                    viewModel.updateTask(task)
                                }
                            )
                        else
                            if (task.title.lowercase().contains(textSearch))
                                ItemTask(
                                    task = task ,
                                    isComplite = complite,
                                    onCompliteChange = {
                                        complite = it
                                        task.complitable = !task.complitable
                                        viewModel.updateTask(task)
                                    }
                                )
                    }
                }

            }

        }
    }
}*/
