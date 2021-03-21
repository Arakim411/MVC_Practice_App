package com.applications.mvc_practice_app.model.movie

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.applications.mvc_practice_app.model.TMDBData
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
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
): TMDBData(),Parcelable {

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

