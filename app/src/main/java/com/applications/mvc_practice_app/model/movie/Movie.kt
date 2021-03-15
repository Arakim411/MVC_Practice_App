package com.applications.mvc_practice_app.model.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.applications.mvc_practice_app.RecyclerViewData
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies_table")
data class Movie(
        @PrimaryKey
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("overview")
        val overView: String,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("release_date")
        val releaseDate: String?,
        @SerializedName("popularity")
        val popularity: Float?,
        @SerializedName("vote_average")
        val voteAverage: Float?
): RecyclerViewData() {

        override fun toString(): String {
                return "id: $id \n" +
                        "title: $title \n" +
                        "over view: $overView \n" +
                        "poster path: $posterPath \n" +
                        "release date: $releaseDate \n" +
                        "popularity: $popularity \n" +
                        "vote average: $voteAverage \n"
        }
}

