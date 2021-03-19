package com.applications.mvc_practice_app.model.tv_show

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.applications.mvc_practice_app.TMDBData
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(@PrimaryKey
                  @SerializedName("id")
                  val id: Int,
                  @SerializedName("name")
                  val name: String,
                  @SerializedName("overview")
                  val overView: String,
                  @SerializedName("poster_path")
                  val posterPath: String?,
                  @SerializedName("vote_average")
                  val voteAverage: Float?):  TMDBData(), Parcelable {

    override fun toString(): String {
        return "id: $id \n" +
                "name: $name \n" +
                "over view: $overView \n" +
                "poster path: $posterPath \n" +
                "vote average: $voteAverage \n"
    }

}
