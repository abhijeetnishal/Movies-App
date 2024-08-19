package com.example.moviesapp.repository

import com.example.moviesapp.api.TvShowsAPI
import com.example.moviesapp.models.TvShowItem
import com.example.moviesapp.utils.NetworkState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TvShowsRepository @Inject constructor(private val tvShowsAPI: TvShowsAPI) {
    private val _topRatedTvShows = MutableStateFlow<NetworkState<TvShowItem>>(NetworkState.Idle())
    val topRatedTvShows: StateFlow<NetworkState<TvShowItem>>
        get() = _topRatedTvShows

    suspend fun getTopRatedTvShows() {
        _topRatedTvShows.emit(NetworkState.Loading())

        try {
            val response = tvShowsAPI.getTopRatedTvShows()

            if (response.isSuccessful && response.body() != null) {
                _topRatedTvShows.emit(NetworkState.Success(response.body()))
            }
        } catch (e: Exception) {
            _topRatedTvShows.emit(
                NetworkState.Error("Network request failed: ${e.localizedMessage}")
            )
        }
    }
}