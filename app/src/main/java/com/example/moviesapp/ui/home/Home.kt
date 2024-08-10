package com.example.moviesapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesapp.ui.popularMovies.PopularMovies

@Composable
fun Home() {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)) {
            PopularMovies()
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun HomePreview() {
    Home()
}