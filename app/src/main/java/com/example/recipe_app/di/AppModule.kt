package com.example.recipe_app.di

import com.example.recipe_app.URL
import com.example.recipe_app.data.network.RecipeAPI
import com.example.recipe_app.data.repo.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRecipeAPI(): RecipeAPI {
        return Retrofit.Builder()
            .baseUrl(URL.url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesRepository(api: RecipeAPI): RecipeRepository {
        return RecipeRepository(api)
    }
}