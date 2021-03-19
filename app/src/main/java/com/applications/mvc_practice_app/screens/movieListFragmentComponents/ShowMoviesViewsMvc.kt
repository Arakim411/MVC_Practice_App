package com.applications.mvc_practice_app.screens.movieListFragmentComponents

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.applications.mvc_practice_app.R
import com.applications.mvc_practice_app.model.movie.Movie
import com.applications.mvc_practice_app.model.movie.MovieList
import com.applications.mvc_practice_app.screens.adapters.MyRecyclerViewAdapter
import com.applications.mvc_practice_app.screens.common.BaseViewMvc
import kotlinx.android.synthetic.main.fragment_show_movies.view.*
import kotlin.collections.ArrayList

private const val TAG ="movie_views_mvc"

class ShowMoviesViewsMvc(layoutInflater: LayoutInflater, parent: ViewGroup?) :
        BaseViewMvc<ShowMoviesViewsMvc.MovieViewsMvcEvents>(layoutInflater, parent, R.layout.fragment_show_movies) {

    private val adapter = MyRecyclerViewAdapter()

    private val recyclerView = rootView.recycler_view
   // private val topRatedMoviesLayout  = rootView.topRatedMovies


    interface MovieRecyclerViewEvents {
            fun onMovieClick(movie: Movie)
    }

    interface MovieViewsMvcEvents {
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

    fun showProgressIcon(){
        rootView.loadingProgressBar.visibility = View.VISIBLE
    }

    fun hideProgressIcon(){
        rootView.loadingProgressBar.visibility = View.INVISIBLE
    }

    fun addMovieRecyclerViewEvent(showMovieEvent: MovieRecyclerViewEvents){
        adapter.registerListener(showMovieEvent)
    }



    private fun log(message: String){
        Log.i(TAG,message)
    }


}