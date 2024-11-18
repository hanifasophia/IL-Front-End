package com.example.bookbase

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookbase.ui.theme.BackgroundDark
import com.example.bookbase.ui.theme.BackgroundLight
import com.example.bookbase.ui.theme.BookBaseTheme
import com.example.bookbase.ui.theme.OnBackgroundLight
import com.example.bookbase.ui.theme.PrimaryColor
import com.example.bookbase.ui.theme.SurfaceLight

@Composable
fun ProfileScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(BackgroundLight)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfilePhoto()

        Spacer(modifier = Modifier.height(16.dp))
        InfoCard(
            title = "Name",
            value = "Hanifa Sophia Rani"
        )

        Spacer(modifier = Modifier.height(16.dp))
        InfoCard(
            title = "Email",
            value = "hanifasophiar@gmail.com"
        )

        Spacer(modifier = Modifier.height(16.dp))
        InfoCard(
            title = "University",
            value = "Lampung University"
        )

        Spacer(modifier = Modifier.height(16.dp))
        InfoCard(
            title = "Major",
            value = "Informatics Engineering"
        )
    }
}

@Composable
fun ProfilePhoto() {
    Card(
        modifier = Modifier
            .size(180.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = BackgroundDark)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profil),
            contentDescription = "Profile Photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(7.dp, Color.White, RoundedCornerShape(20.dp))
        )
    }
}

@Composable
fun InfoCard(title: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = OnBackgroundLight
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    BookBaseTheme {
        ProfileScreen()
    }
}
