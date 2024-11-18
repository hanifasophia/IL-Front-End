package com.example.bookbase.navigation

object Route {
    const val HOME = "home"
    const val SAVED = "saved"
    const val PROFILE = "profile"
    const val DETAILS = "details/{bookId}"

    fun detailsRoute(bookId: Int) = "details/$bookId"
}
