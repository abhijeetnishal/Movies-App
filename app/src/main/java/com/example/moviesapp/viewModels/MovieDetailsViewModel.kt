package com.example.moviesapp.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.models.MovieDetails
import com.example.moviesapp.repository.MovieRepository
import com.example.moviesapp.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    val movieDetails: StateFlow<NetworkState<MovieDetails>>
        get() = movieRepository.movieDetails

    init {
        viewModelScope.launch {
            val movieId = savedStateHandle.get<String>("id")
            movieRepository.getMovieDetails(movieId)
        }
    }
}