package com.example.moviesapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.models.TvShowItem
import com.example.moviesapp.repository.TvShowsRepository
import com.example.moviesapp.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowsViewModel @Inject constructor(private val tvShowRepository: TvShowsRepository) :
    ViewModel() {
    val topRatedTvShows: StateFlow<NetworkState<TvShowItem>>
        get() = tvShowRepository.topRatedTvShows

    val trendingTvShows: StateFlow<NetworkState<TvShowItem>>
        get() = tvShowRepository.trendingTvShows

    init {
        viewModelScope.launch {
            tvShowRepository.getTopRatedTvShows()
            tvShowRepository.getTrendingTvShows()
        }
    }
}