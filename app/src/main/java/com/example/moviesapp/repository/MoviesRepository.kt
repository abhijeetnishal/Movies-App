package com.example.moviesapp.repository

import com.example.moviesapp.api.MoviesAPI
import com.example.moviesapp.models.MovieDetails
import com.example.moviesapp.models.MovieItem
import com.example.moviesapp.utils.NetworkState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val moviesAPI: MoviesAPI) {
    private val _popularMovies = MutableStateFlow<NetworkState<MovieItem>>(NetworkState.Idle())
    val popularMovies: StateFlow<NetworkState<MovieItem>>
        get() = _popularMovies

    private val _movieDetails = MutableStateFlow<NetworkState<MovieDetails>>(NetworkState.Idle())
    val movieDetails: StateFlow<NetworkState<MovieDetails>>
        get() = _movieDetails

    private val _topRatedMovies = MutableStateFlow<NetworkState<MovieItem>>(NetworkState.Idle())
    val topRatedMovies: StateFlow<NetworkState<MovieItem>>
        get() = _topRatedMovies

    suspend fun getPopularMovies() {
        _popularMovies.emit(NetworkState.Loading())

        try {
            val response = moviesAPI.getPopularMovies()

            if (response.isSuccessful && response.body() != null) {
                _popularMovies.emit(NetworkState.Success(response.body()))
            } else {
                val errorMessage = "Error: ${response.errorBody()?.string()}"
                _popularMovies.emit(NetworkState.Error(errorMessage))
            }
        } catch (e: Exception) {
            _popularMovies.emit(
                NetworkState.Error("Network request failed: ${e.localizedMessage}")
            )
        }
    }

    suspend fun getTopRatedMovies() {
        _topRatedMovies.value = NetworkState.Loading()

        try {
            val response = moviesAPI.getTopRatedMovies()

            if (response.isSuccessful && response.body() != null) {
                _topRatedMovies.value = NetworkState.Success(response.body())
            } else {
                val errorMessage = "Error: ${response.errorBody()?.string()}"
                _topRatedMovies.value = NetworkState.Error(errorMessage)
            }
        } catch (e: Exception) {
            _topRatedMovies.value =
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
                _movieDetails.emit(NetworkState.Error(errorMessage))
            }
        } catch (e: Exception) {
            _movieDetails.emit(
                NetworkState.Error("Network request failed: ${e.localizedMessage}")
            )
        }
    }
}