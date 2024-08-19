package com.example.moviesapp.ui.tvShowDetails

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.moviesapp.viewModels.TvShowDetailsViewModel

@Composable
fun TvShowDetails() {
    val tvShowDetailsViewModel: TvShowDetailsViewModel = hiltViewModel()
    val tvShowDetails = tvShowDetailsViewModel.tvShowDetails.collectAsState().value.data

    val tvShowGenres = tvShowDetails?.genres

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(start = 8.dp, end = 8.dp, top = 32.dp, bottom = 16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500${tvShowDetails?.poster_path}",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 450.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = tvShowDetails?.name.toString(),
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Text(
                text = "Seasons: ", color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = tvShowDetails?.number_of_seasons.toString(),
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
                text = tvShowDetails?.vote_average.toString(),
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
                text = tvShowDetails?.overview.toString(),
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
                if (tvShowDetails != null) {
                    items(tvShowGenres!!.size) {
                        Text(
                            text = tvShowGenres[it].name,
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