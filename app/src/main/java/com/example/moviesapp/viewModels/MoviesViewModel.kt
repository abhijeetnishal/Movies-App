package com.example.moviesapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.models.PopularMovieItem
import com.example.moviesapp.repository.MovieRepository
import com.example.moviesapp.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {
    val popularMovies: StateFlow<NetworkState<PopularMovieItem>>
        get() = movieRepository.popularMovies

    init {
        viewModelScope.launch {
            movieRepository.getPopularMovies()
        }
    }
}