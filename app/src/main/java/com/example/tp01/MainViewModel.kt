package com.example.tp01

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<TmdbMovieResult>(TmdbMovieResult());
    val series = MutableStateFlow<TmdbSeriesResult>(TmdbSeriesResult());
    val movie = MutableStateFlow<TmdbMovieDetail>(TmdbMovieDetail())

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build();

    val api = retrofit.create(Api::class.java)

    fun getFilmsiNitiaux(){
            viewModelScope.launch {
                movies.value = api.lastmovies("166e544a3195c0c362b7c9294e90775d", "fr")
            }
        }

    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies("3202f76ed4f5e7931188d0f0ec9e27fa", "fr")
        }
    }

    fun getSeriesInitiaux(){
        viewModelScope.launch {
            series.value = api.lastseries("166e544a3195c0c362b7c9294e90775d", "fr")
        }
    }

    fun getMovieDetail(movieid: String){
        viewModelScope.launch {
            movie.value = api.moviedetails(movieid, "166e544a3195c0c362b7c9294e90775d", "fr")
        }
    }
}