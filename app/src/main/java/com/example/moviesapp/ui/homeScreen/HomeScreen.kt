package com.example.moviesapp.ui.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesapp.ui.popularMovies.PopularMovies
import com.example.moviesapp.ui.topRatedMovies.TopRatedMovies
import com.example.moviesapp.ui.topRatedTvShows.TopRatedTvShows

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        PopularMovies(navController = navController)

        Spacer(modifier = Modifier.height(32.dp))

        TopRatedMovies(navController = navController)

        Spacer(modifier = Modifier.height(32.dp))

        TopRatedTvShows(navController = navController)

        Spacer(modifier = Modifier.height(32.dp))
    }
}