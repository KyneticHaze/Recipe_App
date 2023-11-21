package com.example.recipe_app.data.network

import com.example.recipe_app.data.model.Meal
import com.example.recipe_app.data.model.MealList
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeAPI {

    @GET("random.php")
    suspend fun getRandomRecipe(): MealList

    @GET("search.php")
    suspend fun getSearchedRecipe(
        @Query("s") query: String
    ): MealList
}