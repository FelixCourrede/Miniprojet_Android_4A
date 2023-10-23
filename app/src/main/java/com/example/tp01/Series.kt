package com.example.tp01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.lifecycle.ViewModel.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
    fun SeriesFun(windowClass: WindowSizeClass,
               navController: NavController,
                mainViewModel: MainViewModel){

        val series by mainViewModel.series.collectAsState();

        if (series.results.isEmpty()) {
            mainViewModel.getSeriesInitiaux()
        }
        LazyVerticalGrid(columns = GridCells.Fixed(2), Modifier.padding(vertical = 45.dp)) {
            items(series.results) { serie ->
                FloatingActionButton(
                    onClick = {navController.navigate("serieDetail/${serie.id}")},
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
                            AsyncImage(model = "https://image.tmdb.org/t/p/w780/${serie.poster_path}", contentDescription = "Affiche de ${serie.name}")
                            Text(text = serie.name, textAlign = TextAlign.Center , textDecoration = TextDecoration.Underline )
                            Text(text = serie.first_air_date)

                        }
                    }
                }
            }
        }
    }

