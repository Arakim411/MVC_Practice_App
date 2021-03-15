package com.applications.mvc_practice_app.screens.MovieListFragmentComponents

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.applications.mvc_practice_app.R
import com.applications.mvc_practice_app.RecyclerViewData
import com.applications.mvc_practice_app.model.movie.MovieList
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.adapters.MyRecyclerViewAdapter
import com.applications.mvc_practice_app.screens.common.BaseViewMvc
import kotlinx.android.synthetic.main.fragment_show_movies.view.*
import kotlinx.android.synthetic.main.recycler_view_layout.view.*
import java.util.*
import kotlin.collections.ArrayList

private const val TAG ="movie_views_mvc"

class ShowMoviesViewsMvc(layoutInflater: LayoutInflater, parent: ViewGroup?) :
        BaseViewMvc<ShowMoviesViewsMvc.ShowMoviesEvents>(layoutInflater, parent, R.layout.fragment_show_movies) {

    private val popularMoviesLayout = rootView.popularMovies
    private val upComingMoviesLayout = rootView.upComingMovies
    private val topRatedMoviesLayout  = rootView.topRatedMovies


    init {

    }

    interface ShowMoviesEvents {
            fun onMovieClick(movieId: Int)
            fun onRefresh()
    }

    fun bindMovies(movieList: MovieList,movieListType: Constants.MovieListType){

        when(movieListType){
            Constants.MovieListType.POPULAR ->{
                val adapter = MyRecyclerViewAdapter()
                adapter.setData(ArrayList( movieList.movies))
                popularMoviesLayout.recycler_view.layoutManager = LinearLayoutManager( context,LinearLayoutManager.HORIZONTAL,false)
                popularMoviesLayout.recycler_view.adapter = adapter
            }
            Constants.MovieListType.TOP_RATED -> {log("Top Rated movies bind")}
            Constants.MovieListType.UPCOMING -> { log("Up Coming movies bind")}
        }

    }

    fun showProgressIcon(){
        log("show progress icon")
    }

    fun hideProgressIcon(){
        log("hide progress icon")
    }

    private fun log(message: String){
        Log.i(TAG,message)
    }
}