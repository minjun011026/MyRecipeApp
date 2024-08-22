package com.unit_3.myrecipeapp2

sealed class Screen(val route : String) {
    data object RecipeScreen:Screen("recipescreen")
    data object DetailScreen:Screen("detailscreen")

}