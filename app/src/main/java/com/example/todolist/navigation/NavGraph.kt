package com.example.todolist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todolist.ViewModel.add_edit_task.AddEditScreen
import com.example.todolist.ViewModel.main_screen.HomeScreen

@Composable
fun navGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreenRoute.route
    ) {
        composable(
            route = Screens.HomeScreenRoute.route
        ) {
            HomeScreen(
                navigateToAddEditScreen = { todoId ->
                    navController.navigate(Screens.Add_EditScreenRoute.route + "/${todoId}")
                }
            )
        }

        composable(
            route = Screens.Add_EditScreenRoute.route + "/{todoId}",
            arguments = listOf(navArgument("todoId") {
                type = NavType.IntType
            }
            )
        ) { navBackStackEntry ->
            val todoId = navBackStackEntry.arguments?.getInt("todoId") ?: 0
            AddEditScreen (
                todoId = todoId,
                navigateToHomeScreen = {
                    navController.popBackStack()
                }
            )
        }
    }
}