package com.example.moviesapp.ui.popularMovies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviesapp.MainActivity
import com.example.moviesapp.models.PopularMovieItem
import com.example.moviesapp.ui.movieDetails.MovieDetails
import com.example.moviesapp.utils.NetworkState
import com.example.moviesapp.viewModels.MoviesViewModel

@Composable
fun PopularMovies() {
    val moviesViewModel: MoviesViewModel = hiltViewModel()
    val popularMovies: State<NetworkState<PopularMovieItem>> =
        moviesViewModel.popularMovies.collectAsState()
    val popularMoviesItems = popularMovies.value.data?.results

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            MainActivity()
        }
        composable(
            "movie-details/{id}", arguments = listOf(navArgument("id") {
                type = NavType.StringType
            })
        ) {
            MovieDetails()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .padding(start = 8.dp, end = 8.dp, top = 32.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Popular Movies",
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow {
            if (popularMoviesItems != null) {
                items(popularMoviesItems.size) {
                    PopularMoviesItem(movie = popularMoviesItems[it], onClick = {
                        navController.navigate("movie-details/$it")
                    })
                }
            }
        }
    }
}