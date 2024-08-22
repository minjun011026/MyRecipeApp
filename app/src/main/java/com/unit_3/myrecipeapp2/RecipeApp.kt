package com.unit_3.myrecipeapp2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navHostController : NavHostController){
    val recipeViewModel : MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState

    NavHost(navController = navHostController, startDestination = Screen.RecipeScreen.route){
        composable(Screen.RecipeScreen.route){
            RecipeScreen(viewstate = viewstate, navigationToDetail = {
                navHostController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navHostController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(Screen.DetailScreen.route){
            val category = navHostController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?: Category("","","","")
            CategoryDetailScreen(category = category)
        }
    }
}