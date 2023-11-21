package com.example.recipe_app.data.repo

import com.example.recipe_app.data.model.Meal
import com.example.recipe_app.data.model.MealList
import com.example.recipe_app.data.network.RecipeAPI
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val api: RecipeAPI
) {

    suspend fun getRandomRecipe(): MealList {
        return api.getRandomRecipe()
    }

    suspend fun getSearchedRecipe(query: String): MealList {
        return api.getSearchedRecipe(query)
    }
}