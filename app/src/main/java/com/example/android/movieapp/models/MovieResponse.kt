package com.example.android.movieapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse (
    @SerializedName("result")
    val movies: List<Movie>
    ):Parcelable{
        constructor(): this(mutableListOf())
    }