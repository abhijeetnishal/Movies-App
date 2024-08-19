package com.example.moviesapp.models

data class TvShowDetails(
    val id: String,
    val genres: List<Genre>,
    val name: String,
    val overview: String,
    val poster_path: String,
    val vote_average: Number,
    val number_of_seasons: Number,
    val number_of_episodes: Number,
)