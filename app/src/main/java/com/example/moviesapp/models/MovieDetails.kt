package com.example.moviesapp.models

data class MovieDetails(
    val genres: List<Genre>,
    val id: String,
    val release_date: String,
    val title: String,
    val overview: String,
    val poster_path: String,
    val vote_average: Number,
)

data class Genre(
    val id: Number,
    val name: String,
)