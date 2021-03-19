package com.applications.mvc_practice_app.screens.ListFragmentComponents

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.applications.mvc_practice_app.R
import com.applications.mvc_practice_app.TMDBData
import com.applications.mvc_practice_app.model.movie.MovieList
import com.applications.mvc_practice_app.model.tv_show.TvShowList
import com.applications.mvc_practice_app.screens.adapters.MyRecyclerViewAdapter
import com.applications.mvc_practice_app.screens.common.BaseViewMvc
import kotlinx.android.synthetic.main.fragment_show_data.view.*
import kotlin.collections.ArrayList

private const val TAG ="data_views_mvc"

class ShowDataViewsMvc(layoutInflater: LayoutInflater, parent: ViewGroup?) :
        BaseViewMvc<ShowDataViewsMvc.DataViewsMvcEvents>(layoutInflater, parent, R.layout.fragment_show_data) {

    private val adapter = MyRecyclerViewAdapter()

    private val recyclerView = rootView.recycler_view
   // private val topRatedMoviesLayout  = rootView.topRatedMovies


    interface RecyclerViewEvents {
            fun onItemClick(movie: TMDBData)
    }

    interface DataViewsMvcEvents {
        fun onNextClick()
        fun onLastClick()
    }

    init {
        rootView.btnNextPage.setOnClickListener {
            listeners.forEach {
                it.onNextClick()
            }
        }

        rootView.btnLastPage.setOnClickListener {
            listeners.forEach {
                it.onLastClick()
            }
        }
    }

    fun bindMovies(movieList: MovieList){
                adapter.setData(ArrayList( movieList.movies))
        recyclerView.recycler_view.layoutManager = LinearLayoutManager( context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.recycler_view.adapter = adapter
            }

    fun bindTvShow(tvShowList: TvShowList){
        adapter.setData(ArrayList( tvShowList.tvShows))
        recyclerView.recycler_view.layoutManager = LinearLayoutManager( context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.recycler_view.adapter = adapter
    }

    fun showProgressIcon(){
        rootView.btnLastPage.visibility = View.GONE
        rootView.btnNextPage.visibility = View.GONE
        rootView.loadingProgressBar.visibility = View.VISIBLE
    }

    fun hideProgressIcon(){
        rootView.btnLastPage.visibility = View.VISIBLE
        rootView.btnNextPage.visibility = View.VISIBLE
        rootView.loadingProgressBar.visibility = View.INVISIBLE
    }

    fun addMovieRecyclerViewEvent(showEvent: RecyclerViewEvents){
        adapter.registerListener(showEvent)
    }

    private fun log(message: String){
        Log.i(TAG,message)
    }


}