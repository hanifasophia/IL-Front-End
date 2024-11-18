package com.example.bookbase.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bookbase.BookItemNew
import com.example.bookbase.data.DummyData
import com.example.bookbase.ui.theme.BackgroundDark
import com.example.bookbase.ui.theme.BackgroundLight
import com.example.bookbase.ui.theme.OnBackgroundLight
import com.example.bookbase.ui.theme.PrimaryColor
import com.example.bookbase.ui.theme.SecondaryColor
import com.example.bookbase.ui.theme.SurfaceLight

@Composable
fun AuthorDetails(authorId: Int, navController: NavController) {
    val author = DummyData.authors.find { it.id == authorId }

    if (author != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundLight)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally // Konten di tengah
        ) {
            // Foto Penulis
            Box(
                modifier = Modifier
                    .size(150.dp) // Ukuran gambar lingkaran
                    .clip(CircleShape) // Membuat gambar menjadi lingkaran
                    .background(BackgroundDark)
            ) {
                Image(
                    painter = painterResource(id = author.photoResId),
                    contentDescription = "Author Photo",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Card untuk Detail Penulis
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = SurfaceLight)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    // Nama Penulis
                    Text(
                        text = author.name,
                        style = MaterialTheme.typography.headlineMedium.copy(
                            color = PrimaryColor,
                            fontWeight = FontWeight.Bold
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Biografi
                    Text(
                        text = author.biography,
                        style = MaterialTheme.typography.bodyMedium.copy(color = OnBackgroundLight),
                        modifier = Modifier.padding(bottom = 16.dp),
                        textAlign = TextAlign.Center
                    )

                    // Informasi Tambahan
                    Text(
                        text = "Active Years: ${author.activeYears}",
                        style = MaterialTheme.typography.bodyMedium.copy(color = OnBackgroundLight),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Number of Books: ${author.numberOfBooks}",
                        style = MaterialTheme.typography.bodyMedium.copy(color = OnBackgroundLight),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Notable Works:",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = SecondaryColor,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    author.notableWorks.forEach { work ->
                        Text(
                            text = "- $work",
                            style = MaterialTheme.typography.bodyMedium.copy(color = OnBackgroundLight),
                            modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                        )
                    }

                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            // Buku yang Ditulis
            Text(
                text = "Books by ${author.name}:",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = SecondaryColor,
                    fontWeight = FontWeight.Bold
                )
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(author.books) { bookId ->
                    val book = DummyData.books.find { it.id == bookId }
                    if (book != null) {
                        BookItemNew(book = book, navController = navController)
                    }
                }
            }
        }
    } else {
        // Jika ID penulis tidak ditemukan
        Text(
            text = "Author not found!",
            color = Color.Red,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    }
}
