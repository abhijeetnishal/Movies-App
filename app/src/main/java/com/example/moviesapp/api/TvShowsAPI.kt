package com.example.moviesapp.api

import com.example.moviesapp.Constants.TOP_RATED_TV_SHOW_TOKEN
import com.example.moviesapp.Constants.TRENDING_TV_SHOW_TOKEN
import com.example.moviesapp.Constants.TV_SHOW_DETAILS_TOKEN
import com.example.moviesapp.models.TvShowDetails
import com.example.moviesapp.models.TvShowItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowsAPI {
    @GET("tv/top_rated")
    suspend fun getTopRatedTvShows(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Header("Authorization") authHeader: String = "Bearer $TOP_RATED_TV_SHOW_TOKEN"
    ): Response<TvShowItem>

    @GET("trending/tv/day")
    suspend fun getTrendingTvShows(
        @Query("language") language: String = "en-US",
        @Header("Authorization") authHeader: String = "Bearer $TRENDING_TV_SHOW_TOKEN"
    ): Response<TvShowItem>

    @GET("tv/{id}")
    suspend fun getTvShowDetails(
        @Path("id") tvShowId: String,
        @Query("language") language: String = "en-US",
        @Header("Authorization") authHeader: String = "Bearer $TV_SHOW_DETAILS_TOKEN"
    ): Response<TvShowDetails>
}