package com.example.moviesapp.models

data class MovieItem(
    val page: Int,
    val results: List<MovieItemResult>,
)

data class MovieItemResult(
    val id: String,
    val poster_path: String,
    val title: String,
)