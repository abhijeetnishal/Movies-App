package com.example.moviesapp.repository

import com.example.moviesapp.api.MoviesAPI
import com.example.moviesapp.models.MovieDetails
import com.example.moviesapp.models.PopularMovieItem
import com.example.moviesapp.utils.NetworkState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val moviesAPI: MoviesAPI) {
    private val _popularMovies =
        MutableStateFlow<NetworkState<PopularMovieItem>>(NetworkState.Idle())
    val popularMovies: StateFlow<NetworkState<PopularMovieItem>>
        get() = _popularMovies

    private val _movieDetails = MutableStateFlow<NetworkState<MovieDetails>>(NetworkState.Idle())
    val movieDetails: StateFlow<NetworkState<MovieDetails>>
        get() = _movieDetails

    suspend fun getPopularMovies() {
        _popularMovies.emit(NetworkState.Loading())

        try {
            val response = moviesAPI.getPopularMovies()

            if (response.isSuccessful && response.body() != null) {
                _popularMovies.emit(NetworkState.Success(response.body()))
            } else {
                val errorMessage = "Error: ${response.errorBody()?.string()}"
                _popularMovies.value = NetworkState.Error(errorMessage)
            }
        } catch (e: Exception) {
            _popularMovies.value =
                NetworkState.Error("Network request failed: ${e.localizedMessage}")
        }
    }

    suspend fun getMovieDetails(movieId: String?) {
        _movieDetails.emit(NetworkState.Loading())

        try {
            val response = moviesAPI.getMovieDetails(movieId ?: "")

            if (response.isSuccessful && response.body() != null) {
                _movieDetails.emit(NetworkState.Success(response.body()))
            } else {
                val errorMessage = "Error: ${response.errorBody()?.string()}"
                _movieDetails.value = NetworkState.Error(errorMessage)
            }
        } catch (e: Exception) {
            _movieDetails.value =
                NetworkState.Error("Network request failed: ${e.localizedMessage}")
        }
    }
}