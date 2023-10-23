package com.example.tp01

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



class TmdbSeriesResult(
    var page: Int = 0,
    val results: List<TmdbSerie> = listOf()
)
class TmdbSerie(
    var adult: Boolean = false,
    var backdrop_path: String = "",
    var id: String = "",
    var name: String = "",
    var original_language: String = "",
    var original_name: String = "",
    var overview: String = "",
    var poster_path: String = "",
    var media_type: String = "",
    val genre_ids: List<Int> = listOf(),
    var popularity: String = "",
    var first_air_date: String = "",
    var vote_average: String = "",
    var vote_count: String = "",
    val origin_country: List<String> = listOf()
)
