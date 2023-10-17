package com.example.tp01

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class TmdbMovieResult(
    var page: Int = 0,
    val results: List<TmdbMovie> = listOf())

class TmdbMovie(
    var overview: String = "",
    val release_date: String = "",
    val id: String = "",
    val title: String = "",
    val original_title: String = "",
    val backdrop_path: String? = "",
    val genre_ids: List<Int> = listOf(),
    val poster_path: String? = "")

