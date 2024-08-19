package com.example.moviesapp.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.repository.TvShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowDetailsViewModel @Inject constructor(
    private val tvShowRepository: TvShowsRepository, private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val tvShowDetails
        get() = tvShowRepository.tvShowDetails

    init {
        viewModelScope.launch {
            val tvShowId = savedStateHandle.get<String>("id")
            tvShowRepository.getTvShowDetails(tvShowId?:"")
        }
    }
}