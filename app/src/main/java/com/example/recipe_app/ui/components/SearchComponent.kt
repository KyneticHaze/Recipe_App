package com.example.recipe_app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchComponent(onSearchClicked: (query: String) -> Unit) {
    var query by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            value = query,
            onValueChange = {
                if (it.isNotBlank()) {
                    message = ""
                }
                query = it
            },
            label = { Text(text = "Search") },
            singleLine = true,
            isError = message.isNotBlank(),
            trailingIcon = {
                IconButton(onClick = {
                    if (query.isNotBlank()) {
                        onSearchClicked(query)
                    } else {
                        message = "Enter a query first"
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Clear",
                        tint = Color.Gray
                    )
                }
            })
        if (message.isNotBlank()) {
            Text(
                text = message, style = TextStyle(
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 14.sp
                ), modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}