package com.applications.mvc_practice_app.screens.detailsFragmentComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applications.mvc_practice_app.FragmentToolBarData
import com.applications.mvc_practice_app.R
import com.applications.mvc_practice_app.TMDBData
import com.applications.mvc_practice_app.model.movie.Movie
import com.applications.mvc_practice_app.model.tv_show.TvShow
import com.applications.mvc_practice_app.screens.common.BaseFragment

private const val PARAM_TMDB_DATA_KEY = "TMDB_DATA"

class FragmentDetails : BaseFragment() {
    private lateinit var viewsMvc: DetailsViewsMvc
    private lateinit var data: TMDBData

    override fun onCreate(savedInstanceState: Bundle?) {
        data = requireArguments().getParcelable<TMDBData>(PARAM_TMDB_DATA_KEY)
                ?: throw error("Fragment Details needs TMDBData in arguments")

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        viewsMvc = compositionRoot.detailsViewsMvcFactory.getDetailsViewsMvc(container)
        viewsMvc.bindData(data)
        return viewsMvc.rootView
    }


    override fun onStart() {
        super.onStart()
        val tempData = data

        val toolBarData = when (tempData) {
            is Movie -> FragmentToolBarData(tempData.title, null, null)
            is TvShow -> FragmentToolBarData(tempData.name, null, null)
            else -> throw error("unknown data type: $tempData")
        }
        setToolBarData(toolBarData)
    }

    companion object {
        fun getInstance(tmdbData: TMDBData): FragmentDetails =
                FragmentDetails().apply {
                    arguments = Bundle().apply {
                        putParcelable(PARAM_TMDB_DATA_KEY, tmdbData)
                    }
                }
    }


}