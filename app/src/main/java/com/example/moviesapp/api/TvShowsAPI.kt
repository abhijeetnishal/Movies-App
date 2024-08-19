package com.example.moviesapp.api

import com.example.moviesapp.Constants.TOP_RATED_TV_SHOW_TOKEN
import com.example.moviesapp.models.TvShowItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TvShowsAPI {
    @GET("tv/top_rated")
    suspend fun getTopRatedTvShows(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Header("Authorization") authHeader: String = "Bearer $TOP_RATED_TV_SHOW_TOKEN"
    ): Response<TvShowItem>
}