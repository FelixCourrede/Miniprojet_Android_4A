package com.example.tp01

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import androidx.core.graphics.component1
import androidx.navigation.NavController


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
    Log.i("TestRun", movies.results.toString());
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(movies.results) { movie ->
            FloatingActionButton(
                onClick = {},
                modifier = Modifier.padding(20.dp),
                containerColor = Color.White,
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

                        Text(text = movie.title)
                    }
                }
            }
        }
    }
    Button(onClick = { navController.navigate("profil") }) {
        Text(text = "En revenir a Jeff")}
}
