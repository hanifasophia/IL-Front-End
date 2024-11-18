package com.example.bookbase.model

data class Author(
    val id: Int,
    val name: String,
    val photoResId: Int,
    val biography: String,
    val numberOfBooks: Int,
    val activeYears: String,
    val notableWorks: List<String>,
    val books: List<Int> = emptyList()
)

