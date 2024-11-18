package com.example.bookbase.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import com.example.bookbase.R
import com.example.bookbase.data.DummyData
import com.example.bookbase.ui.theme.OnBackgroundLight
import com.example.bookbase.ui.theme.PrimaryColor
import com.example.bookbase.ui.theme.SecondaryColor
import com.example.bookbase.ui.theme.SurfaceLight

@Composable
fun BookDetails(bookId: Int, navController: NavController) {
    val book = DummyData.books.find { it.id == bookId }

    if (book != null) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(SurfaceLight)
                .padding(16.dp)
        ) {
            // Sampul Buku
            Image(
                painter = painterResource(id = book.coverResId),
                contentDescription = "Book Cover",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Judul Buku
            Text(
                text = book.title,
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Penulis
            Text(
                text = "Author: ${book.authorName}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = OnBackgroundLight,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Genre
            Text(
                text = "Genre: ${book.genre.joinToString(", ")}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = OnBackgroundLight
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Tahun Rilis dan Jumlah Halaman
            Text(
                text = "Released: ${book.releaseYear}",
                style = MaterialTheme.typography.bodySmall.copy(color = OnBackgroundLight)
            )
            Text(
                text = "Pages: ${book.pageCount}",
                style = MaterialTheme.typography.bodySmall.copy(color = OnBackgroundLight)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Rating
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "Star Icon",
                    tint = SecondaryColor,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = " ${book.rating}/5.0",
                    style = MaterialTheme.typography.bodyMedium.copy(color = OnBackgroundLight)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sinopsis
            Text(
                text = "Synopsis:",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = SecondaryColor,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = book.synopsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = OnBackgroundLight
                ),
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tombol Start Reading
            Button(
                onClick = { navController.navigate("details/read/$bookId") },
                colors = ButtonDefaults.buttonColors(PrimaryColor),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Start Reading", color = Color.White)
            }
        }
    } else {
        Text(
            text = "Book not found!",
            color = Color.Red,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    }
}

