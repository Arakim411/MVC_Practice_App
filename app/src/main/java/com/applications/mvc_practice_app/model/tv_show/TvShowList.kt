package com.applications.mvc_practice_app.model.tv_show

import android.util.Log
import com.google.gson.annotations.SerializedName

data class TvShowList(
        @SerializedName("results")
        val tvShows: List<TvShow>,
        @SerializedName("total_pages")
        val totalPages: Int,
        @SerializedName("page")
        val page: Int
){
        fun info(tag: String) {
                tvShows.forEach {
                        Log.i(tag, "${it.toString()} \n")
                }
                Log.i(tag, "Page: $page")
                Log.i(tag, "TvShowsSize: ${tvShows.size}")
                Log.i(tag, "TotalPages: $totalPages")
        }
}
