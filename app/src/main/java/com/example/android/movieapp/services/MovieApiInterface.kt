package com.example.android.movieapp.services

import com.example.android.movieapp.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("https://api.themoviedb.org/3/movie/550?api_key=ce95b08e552ec8af864fa72d72c63720")
    fun getMovieList(): Call<MovieResponse>
}