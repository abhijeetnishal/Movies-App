package com.example.moviesapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.models.MovieItem
import com.example.moviesapp.repository.MovieRepository
import com.example.moviesapp.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {
    val popularMovies: StateFlow<NetworkState<MovieItem>>
        get() = movieRepository.popularMovies

    val topRatedMovies: StateFlow<NetworkState<MovieItem>>
        get() = movieRepository.topRatedMovies

    init {
        viewModelScope.launch {
            movieRepository.getPopularMovies()
            movieRepository.getTopRatedMovies()
        }
    }
}