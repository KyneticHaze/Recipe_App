package com.example.recipe_app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipe_app.data.model.Meal
import com.example.recipe_app.data.model.MealList

@Composable
fun SuccessComponent(recipes: MealList, onSearchClicked: (query: String) -> Unit) {
    Column {
        Text(
            text = "Recipe Finder", style = TextStyle(
                fontWeight = FontWeight(900),
                fontSize = 32.sp,
                fontFamily = FontFamily.Cursive
            ), modifier = Modifier.padding(8.dp)
        )
        SearchComponent(onSearchClicked = onSearchClicked)
        RecipesList(recipes = recipes)
    }
}