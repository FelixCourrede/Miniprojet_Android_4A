package com.example.tp01

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key : String, @Query("language") language: String): TmdbMovieResult

    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String, @Query("language") language: String): TmdbSeriesResult

    @GET("movie/{id}?append_to_response=credits")
    suspend fun moviedetails(@Path("id") id: String, @Query("api_key") api_key: String, @Query("language") language: String): TmdbMovieDetail
    @GET("tv/{id}?append_to_response=credits")
    suspend fun seriedetails(@Path("id") id: String, @Query("api_key") api_key: String, @Query("language") language: String): TmdbSerieDetail

    @GET("search/movie")
    suspend fun search(@Query("api_key") api_key: String, @Query("query") keyword: String): TmdbMovieResult



}

