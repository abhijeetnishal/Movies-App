package com.example.moviesapp.models

data class TvShowItem(
    val page: Int,
    val results: List<TvShowResult>
)

data class TvShowResult(
    val id: String,
    val poster_path: String,
    val name: String
)
