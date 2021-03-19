package com.applications.mvc_practice_app.screens.detailsFragmentComponent

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.applications.mvc_practice_app.R
import com.applications.mvc_practice_app.TMDBData
import com.applications.mvc_practice_app.model.movie.Movie
import com.applications.mvc_practice_app.model.tv_show.TvShow
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.common.BaseViewMvc
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.ratingBar

class DetailsViewsMvc(layoutInflater: LayoutInflater, view: ViewGroup?): BaseViewMvc<DetailsViewsMvc>(layoutInflater,view, R.layout.fragment_details) {

    val image = rootView.dataImage
    val raitingBar = rootView.ratingBar
    val overview = rootView.overview


    interface DetailsViewsMvcEvents {

    }

    fun bindData(tmdbData: TMDBData){

        if(tmdbData is Movie) {
            val imageUrl = Constants.BASE_URL_FOR_PHOTO + tmdbData.posterPath
            Glide.with(context).load(imageUrl).into(image)
            raitingBar.rating = tmdbData.voteAverage?.div(2f) ?: 0f
            overview.text = tmdbData.overView
        }

        if(tmdbData is TvShow){
            val imageUrl = Constants.BASE_URL_FOR_PHOTO + tmdbData.posterPath
            Glide.with(context).load(imageUrl).into(image)
            raitingBar.rating = tmdbData.voteAverage?.div(2f) ?: 0f
            overview.text = tmdbData.overView
        }
    }


}