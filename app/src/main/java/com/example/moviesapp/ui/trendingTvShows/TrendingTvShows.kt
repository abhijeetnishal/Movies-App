package com.example.moviesapp.ui.trendingTvShows

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.moviesapp.ui.components.TvShowsItem
import com.example.moviesapp.viewModels.TvShowsViewModel

@Composable
fun TrendingTvShows(navController: NavController) {
    val tvShowsViewModel: TvShowsViewModel = hiltViewModel()
    val trendingTvShows = tvShowsViewModel.trendingTvShows.collectAsState()
    val trendingTvShowsItems = trendingTvShows.value.data?.results

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Trending Tv Shows",
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow {
            if (trendingTvShowsItems != null) {
                items(trendingTvShowsItems.size) {
                    TvShowsItem(tvShow = trendingTvShowsItems[it], onClick = {
                        navController.navigate("tv-show-details/$it")
                    })
                }
            }
        }
    }
}