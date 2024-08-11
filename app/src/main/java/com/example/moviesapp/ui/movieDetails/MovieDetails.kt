package com.example.moviesapp.ui.movieDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.moviesapp.models.MovieDetails
import com.example.moviesapp.viewModels.MovieDetailsViewModel

@Composable
fun MovieDetails() {
    val moviesDetailsViewModel: MovieDetailsViewModel = hiltViewModel()
    val movieDetails: State<MovieDetails?> = moviesDetailsViewModel.movieDetails.collectAsState()
    val movieGenres = movieDetails.value?.genres

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 32.dp, horizontal = 8.dp),
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500${movieDetails.value?.poster_path}",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 450.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = movieDetails.value?.title.toString(),
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Text(
                text = "Release Date: ", color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = movieDetails.value?.release_date.toString(),
                color = Color.White,
                fontSize = 14.sp,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text(
                text = "Rating: ", color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = movieDetails.value?.vote_average.toString(),
                color = Color.White,
                fontSize = 14.sp,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column {
            Text(
                text = "overview", color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = movieDetails.value?.overview.toString(),
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 14.sp,
                )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            Text(
                text = "Genres", color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(4.dp))

            LazyRow {
                if (movieGenres != null) {
                    items(movieGenres.size) {
                        Text(
                            text = movieGenres[it].name,
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                        )

                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }
        }
    }
}