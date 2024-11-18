package com.example.bookbase

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bookbase.component.SearchBar
import com.example.bookbase.data.DummyData
import com.example.bookbase.model.Author
import com.example.bookbase.model.Book
import com.example.bookbase.ui.theme.BackgroundDark
import com.example.bookbase.ui.theme.BackgroundLight
import com.example.bookbase.ui.theme.BookBaseTheme
import com.example.bookbase.ui.theme.OnBackgroundLight
import com.example.bookbase.ui.theme.PrimaryColor
import com.example.bookbase.ui.theme.SecondaryColor
import com.example.bookbase.ui.theme.SurfaceLight

@Composable
fun HomeScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredBooks = DummyData.books.filter {
        it.title.contains(searchQuery, ignoreCase = true) ||
                it.authorName.contains(searchQuery, ignoreCase = true)
    }

    val filteredAuthors = DummyData.authors.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
            .padding(16.dp)
    ) {
        Text(
            text = "Hello, Hanifa",
            style = MaterialTheme.typography.headlineMedium.copy(
                color = PrimaryColor,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "Your next great adventure awaits within these pages",
            style = MaterialTheme.typography.bodyMedium.copy(color = OnBackgroundLight),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        SearchBar(
            searchQuery = searchQuery,
            onQueryChanged = { query -> searchQuery = query }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            if (filteredAuthors.isNotEmpty()) {
                item {
                    SectionTitle(
                        title = "Popular Authors",
                        icon = R.drawable.ic_author,
                        Modifier.padding(top = 8.dp)
                    )
                }
                item {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(filteredAuthors) { author ->
                            AuthorItemNew(author = author, navController = navController)
                        }
                    }
                }
            }

            if (filteredBooks.isNotEmpty()) {
                item {
                    SectionTitle(
                        title = "Trending Books",
                        icon = R.drawable.ic_books,
                        Modifier.padding(top = 8.dp)
                    )
                }
                items(filteredBooks) { book ->
                    BookItemNew(book = book, navController = navController)
                }
            }
        }
    }
}

@Composable
fun SectionTitle(title: String, @DrawableRes icon: Int, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = SecondaryColor,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = SecondaryColor
            ),
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Composable
fun AuthorItemNew(author: Author, navController: NavController) {
    Card(
        modifier = Modifier
            .width(140.dp)
            .height(150.dp)
            .clickable { navController.navigate("details/author/${author.id}") }
            .padding(horizontal = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(BackgroundDark)
            ) {
                Image(
                    painter = painterResource(id = author.photoResId),
                    contentDescription = "Author Photo",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = author.name,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun BookItemNew(book: Book, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate("details/book/${book.id}") },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = book.coverResId),
                contentDescription = "Book Cover",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = PrimaryColor,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = book.genre.joinToString(", "),
                    style = MaterialTheme.typography.bodySmall.copy(color = OnBackgroundLight)
                )
                Text(
                    text = "${book.pageCount} pages",
                    style = MaterialTheme.typography.bodySmall.copy(color = OnBackgroundLight)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    BookBaseTheme {
        HomeScreen(navController = rememberNavController())
    }
}