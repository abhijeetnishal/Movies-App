package com.example.moviesapp.repository

import android.util.Log
import com.example.moviesapp.api.MoviesAPI
import com.example.moviesapp.models.MovieDetails
import com.example.moviesapp.models.PopularMovieItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val moviesAPI: MoviesAPI) {
    private val _popularMovies = MutableStateFlow<PopularMovieItem?>(null)
    val popularMovies: StateFlow<PopularMovieItem?>
        get() = _popularMovies

    private val _movieDetails = MutableStateFlow<MovieDetails?>(null)
    val movieDetails: StateFlow<MovieDetails?>
        get() = _movieDetails

    suspend fun getPopularMovies() {
        val response = moviesAPI.getPopularMovies()

        if (response.isSuccessful && response.body() != null) {
            _popularMovies.emit(response.body()!!)
        } else {
            Log.e(
                "MovieRepository",
                "API call failed or response is null: ${response.errorBody()?.string()}"
            )
        }
    }

    suspend fun getMovieDetails(movieId: String?) {
        val response = moviesAPI.getMovieDetails(movieId ?: "")

        if (response.isSuccessful && response.body() != null) {
            _movieDetails.emit(response.body()!!)
        } else {
            Log.e(
                "MovieRepository",
                "API call failed or response is null: ${response.errorBody()?.string()}"
            )
        }
    }
}