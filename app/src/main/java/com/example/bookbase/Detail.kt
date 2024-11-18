package com.example.bookbase

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bookbase.ui.theme.BookBaseTheme
import com.example.bookbase.screen.AuthorDetails
import com.example.bookbase.screen.BookDetails
import com.example.bookbase.screen.BookReadingScreen

@Composable
fun DetailsScreen(type: String, id: Int, navController: NavController) {
    when (type) {
        "author" -> AuthorDetails(authorId = id, navController = navController)
        "book" -> BookDetails(bookId = id, navController = navController)
        "read" -> BookReadingScreen(bookId = id, navController = navController)
        else -> {
            Text(
                text = "Invalid type!",
                color = Color.Red,
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAuthorDetailsScreen() {
    BookBaseTheme {
        DetailsScreen("author", 1, rememberNavController())
    }
}