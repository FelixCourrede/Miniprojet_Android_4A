package com.example.tp01

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.core.graphics.component1
import androidx.navigation.NavController
import coil.compose.AsyncImage


@Composable
fun Films(
    windowClass: WindowSizeClass,
    navController: NavController,
    filmViewModel: MainViewModel
) {


    val movies by filmViewModel.movies.collectAsState();

    if (movies.results.isEmpty()) {
        filmViewModel.getFilmsiNitiaux()
    }
    LazyVerticalGrid(columns = GridCells.Fixed(2),Modifier.padding(vertical = 45.dp)) {
        items(movies.results) { movie ->
            FloatingActionButton(
                onClick = {},
                modifier = Modifier.padding(20.dp),
                containerColor = Color.White
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AsyncImage(model = "https://image.tmdb.org/t/p/w780/${movie.poster_path}", contentDescription = "Affiche de ${movie.title}")
                        Text(text = movie.title, textAlign = TextAlign.Center , textDecoration = TextDecoration.Underline )
                        Text(text = movie.release_date)
                        
                    }
                }
            }
        }
    }
}
