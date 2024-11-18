package com.example.bookbase.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookbase.ui.theme.OnBackgroundLight
import com.example.bookbase.ui.theme.PrimaryColor
import com.example.bookbase.ui.theme.SecondaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(searchQuery: String, onQueryChanged: (String) -> Unit) {
    OutlinedTextField(
        value = searchQuery,
        onValueChange = onQueryChanged,
        modifier = Modifier
            .fillMaxWidth(),
        placeholder = {
            Text(
                text = "Search books or authors...",
                style = MaterialTheme.typography.bodyMedium,
                color = OnBackgroundLight
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = SecondaryColor
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PrimaryColor,
            unfocusedBorderColor = OnBackgroundLight,
            cursorColor = PrimaryColor
        )
    )
}