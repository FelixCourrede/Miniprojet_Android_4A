package com.example.tp01

import androidx.compose.runtime.Composable
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import java.util.Locale
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalCoilApi::class)
    @Composable
    fun DetailMovie(navController: NavController, movieId: String) {

        val MovieDetailVM: MainViewModel = viewModel()
        val movie by MovieDetailVM.movie.collectAsState()
        fun getGenres(genres: List<Genre>): String {
            var genresString = ""
            for (genre in genres) {
                genresString += genre.name + " & "
            }
            return genresString.dropLast(2)
        }
        if (movie.title == "") {
            MovieDetailVM.getMovieDetail(movieId)
        }
            LazyColumn(Modifier.padding(top = 32.dp)) {

                // Titre + Image de fond du film
                item {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = movie.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                        )

                    }

                }
                // Affiche + Date de sortie + Genre
                item {
                    Row(
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AsyncImage(
                            model = "https://image.tmdb.org/t/p/w1280" + movie.poster_path,
                            contentDescription = "Affiche du film",
                            modifier = Modifier.size(250.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                        ) {
                            Text(
                                text = movie.release_date,
                                color = Color.Gray,
                                modifier = Modifier.padding(top = 15.dp, end = 10.dp),
                                fontSize = 15.sp
                            )

                            Text(
                                text = getGenres(movie.genres),
                                fontStyle = FontStyle.Italic,
                                modifier = Modifier.padding(top = 15.dp, end = 15.dp)
                            )
                        }
                    }
                }
                // Synopsis
                item {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Synopsis",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            modifier = Modifier.padding(top = 15.dp, end = 15.dp)
                        )
                        Text(
                            text = movie.overview,
                            modifier = Modifier.padding(top = 15.dp, end = 15.dp)
                        )
                    }
                }
                if(movie.credits.cast.isNotEmpty()){
                    item {
                        Text(
                            text = "Têtes d'affiches",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            modifier = Modifier.padding(top = 15.dp, end = 15.dp)
                        )
                    }
                    items(movie.credits.cast.take(10)){ cast ->
                        FloatingActionButton(
                            onClick = { navController.navigate("DetailPerson/${cast.id}") },
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
                                AsyncImage(model = "https://image.tmdb.org/t/p/w780"+cast.profile_path, contentDescription = "Photo Acteur", modifier = Modifier.size(250.dp))
                                    Text(
                                        text = cast.name,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        modifier = Modifier.padding(top = 5.dp)
                                    )
                                    Text(
                                        text = cast.character,
                                        color = Color.Black,
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(top = 15.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }