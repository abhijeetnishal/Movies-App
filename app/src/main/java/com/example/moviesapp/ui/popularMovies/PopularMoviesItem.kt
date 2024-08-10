package com.example.moviesapp.ui.popularMovies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.moviesapp.models.MovieItemResult

@Composable
fun PopularMoviesItem(movie: MovieItemResult) {
    Card(
        onClick = { /*TODO*/ }, modifier = Modifier.width(124.dp), shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(color = Color.Gray),
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
                contentDescription = null,
                )

            Spacer(modifier = Modifier.width(2.dp))

            Text(
                text = movie.title,
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp, vertical = 4.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }

    Spacer(modifier = Modifier.width(8.dp))
}