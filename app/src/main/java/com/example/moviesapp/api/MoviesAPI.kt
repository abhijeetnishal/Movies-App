package com.example.moviesapp.api

import com.example.moviesapp.models.MovieDetails
import com.example.moviesapp.models.PopularMovieItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Header("Authorization") authHeader: String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3ZWMyYTU2ZDkzNjQ0NjYyM2ExOTNhMWY5YWExYmQ2NyIsIm5iZiI6MTcyMzI2ODg3NC4yMzY2ODUsInN1YiI6IjY2YWZhNjc0NzM4NjM5MTBhNmMyMmQ4ZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1LT96DnAew9l_hyLbY9RTAAAm04zF1z35BQFJDcu-m8"
    ): Response<PopularMovieItem>

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") movieId: String,
        @Query("language") language: String = "en-US",
        @Header("Authorization") authHeader: String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3ZWMyYTU2ZDkzNjQ0NjYyM2ExOTNhMWY5YWExYmQ2NyIsIm5iZiI6MTcyMzM1ODkzNy4xMTUyODQsInN1YiI6IjY2YWZhNjc0NzM4NjM5MTBhNmMyMmQ4ZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.SJaQyYjCUbmAWujlwzDwu_wZt6RKkZ-1gvCQxJ0SGa8"
    ): Response<MovieDetails>
}