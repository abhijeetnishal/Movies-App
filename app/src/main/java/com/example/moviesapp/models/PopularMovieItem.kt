package com.example.moviesapp.models

data class PopularMovieItem(
    val page: Int,
    val results: List<MovieItemResult>,
)

data class MovieItemResult(
    val id: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val overview: String
)