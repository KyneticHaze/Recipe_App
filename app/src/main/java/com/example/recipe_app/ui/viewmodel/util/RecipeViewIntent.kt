package com.example.recipe_app.ui.viewmodel.util

sealed class RecipeViewIntent {
    data object LoadRandomRecipe: RecipeViewIntent()
    data class SearchRecipes(val query: String): RecipeViewIntent()
}
