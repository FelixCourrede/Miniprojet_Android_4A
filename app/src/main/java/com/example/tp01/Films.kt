package com.example.tp01

import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController


@Composable
fun Films(windowClass: WindowSizeClass, navController: NavController, filmViewModel: MainViewModel){
    Button(onClick = {navController.navigate("profil")}) {}
    val movies by filmViewModel.movies.collectAsState();
    if (movies.results.isEmpty()){
        if (movies.results.isEmpty()) {
            filmViewModel.getFilmsiNitiaux()
    }
        LazyVerticalGrid(){

        }
        print(movies.results)
}}
