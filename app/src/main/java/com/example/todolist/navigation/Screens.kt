package com.example.todolist.navigation

sealed class Screens(val route : String){
    object HomeScreenRoute : Screens("Home_Screen_Route")
    object Add_EditScreenRoute : Screens("Add_Edit_Route")
}
