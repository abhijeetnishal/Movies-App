package com.example.moviesapp.api

import com.example.moviesapp.Constants.MOVIE_DETAILS_TOKEN
import com.example.moviesapp.Constants.POPULAR_MOVIES_TOKEN
import com.example.moviesapp.Constants.TOP_RATED_MOVIES_TOKEN
import com.example.moviesapp.models.MovieDetails
import com.example.moviesapp.models.MovieItem
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
        @Header("Authorization") authHeader: String = "Bearer $POPULAR_MOVIES_TOKEN"
    ): Response<MovieItem>

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") movieId: String,
        @Query("language") language: String = "en-US",
        @Header("Authorization") authHeader: String = "Bearer $MOVIE_DETAILS_TOKEN"
    ): Response<MovieDetails>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Header("Authorization") authHeader: String = "Bearer $TOP_RATED_MOVIES_TOKEN"
    ): Response<MovieItem>


}