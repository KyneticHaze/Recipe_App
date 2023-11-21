package com.example.recipe_app.ui.viewmodel.util

import com.example.recipe_app.data.model.MealList

sealed class RecipeViewState {
    data object Loading: RecipeViewState()
    data class Success(val recipes: MealList): RecipeViewState()
    data class Error(val message: String): RecipeViewState()
}
