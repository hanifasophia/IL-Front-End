package com.example.bookbase

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bookbase.data.DummyData
import com.example.bookbase.model.SavedBook
import com.example.bookbase.ui.theme.BackgroundLight
import com.example.bookbase.ui.theme.BookBaseTheme
import com.example.bookbase.ui.theme.OnBackgroundLight
import com.example.bookbase.ui.theme.PrimaryColor
import com.example.bookbase.ui.theme.SecondaryColor
import com.example.bookbase.ui.theme.SurfaceLight

@Composable
fun SavedScreen(navController: NavController) {
    val savedBooks = DummyData.books.map {
        SavedBook(
            book = it,
            progress = (10..90).random()
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(16.dp)
    ) {
        Text(
            text = "Continue Reading",
            style = MaterialTheme.typography.headlineMedium.copy(
                color = PrimaryColor,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(savedBooks.chunked(2)) { rowBooks ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowBooks.forEach { savedBook ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(vertical = 8.dp)
                        ) {
                            SavedBookItem(
                                savedBook = savedBook,
                                navController = navController
                            )
                        }
                    }
                    if (rowBooks.size < 2) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun SavedBookItem(savedBook: SavedBook, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(SurfaceLight)
            .clickable { navController.navigate("details/book/${savedBook.book.id}") },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = savedBook.book.coverResId),
            contentDescription = "Book Cover",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Text(
            text = savedBook.book.title,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = OnBackgroundLight,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearProgressIndicator(
                progress = savedBook.progress / 100f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(50.dp)),
                color = PrimaryColor
            )
            Text(
                text = "${savedBook.progress}%",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = SecondaryColor,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SavedScreenPreview() {
    BookBaseTheme {
       SavedScreen(navController = rememberNavController())
    }
}
