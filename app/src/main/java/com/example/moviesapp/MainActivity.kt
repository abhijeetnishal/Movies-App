package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviesapp.ui.homeScreen.HomeScreen
import com.example.moviesapp.ui.movieDetails.MovieDetails
import com.example.moviesapp.ui.tvShowDetails.TvShowDetails
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}

@Composable
fun Home() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable(
            "movie-details/{id}", arguments = listOf(navArgument("id") {
                type = NavType.StringType
            })
        ) {
            MovieDetails()
        }
        composable("tv-show-details/{id}", arguments = listOf(navArgument("id") {
            type = NavType.StringType
        })) {
            TvShowDetails()
        }
    }
}

