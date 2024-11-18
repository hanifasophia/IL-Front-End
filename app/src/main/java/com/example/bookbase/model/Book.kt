package com.example.bookbase.model

data class Book(
    val id: Int,
    val title: String,
    val genre: List<String>,
    val pageCount: Int,
    val coverResId: Int,
    val synopsis: String,
    val releaseYear: Int,
    val rating: Float,
    val authorName: String
)
