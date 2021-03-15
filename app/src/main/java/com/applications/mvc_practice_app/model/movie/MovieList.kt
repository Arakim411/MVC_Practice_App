package com.applications.mvc_practice_app.model.movie

import android.util.Log
import com.google.gson.annotations.SerializedName


data class MovieList(
        @SerializedName("results")
        val movies: List<Movie>,
        @SerializedName("total_pages")
        val totalPages: Int,
        @SerializedName("page")
        val page: Int
) {
    fun info(tag: String) {
        movies.forEach {
            Log.i(tag, "${it.toString()} \n")
        }
        Log.i(tag, "Page: $page")
        Log.i(tag, "MoviesSize: ${movies.size}")
        Log.i(tag, "TotalPages: $totalPages")
    }
}


