package com.applications.mvc_practice_app.screens.movieListFragmentComponents

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applications.mvc_practice_app.listeners.ViewerEvents
import com.applications.mvc_practice_app.model.movie.Movie
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.common.BaseFragment
import com.applications.mvc_practice_app.toStringResources
import kotlinx.android.synthetic.main.fragment_show_movies.view.*
import kotlinx.coroutines.*
import java.lang.IllegalArgumentException

private const val TAG = "fragment_movies"
private const val param_type = "param_type"

class FragmentShowMovies : BaseFragment(), ShowMoviesViewsMvc.MovieRecyclerViewEvents, ShowMoviesViewsMvc.MovieViewsMvcEvents {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private lateinit var viewsMvc: ShowMoviesViewsMvc
    private var isDataLoaded = false
    private lateinit var movieListType: Constants.MovieListType
    private var page = 1
    private var maxPage = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        viewsMvc = compositionRoot.movieViewsMvcFactory.newMovieViewsMvc(container)

        return viewsMvc.rootView
    }

    override fun onStart() {
        movieListType = requireArguments().getParcelable<Constants.MovieListType>(param_type) ?: throw error("Fragment must be created by getInstance and contains in arguments movie list type")

       viewerEvents?.setTitle(movieListType.toStringResources(resources))

        viewsMvc.addMovieRecyclerViewEvent(this)
        viewsMvc.addListener(this)
        if (!isDataLoaded) {
         loadPage(page)
        }
        super.onStart()
    }

    override fun onStop() {
        coroutineScope.coroutineContext.cancelChildren()
        viewsMvc.addMovieRecyclerViewEvent(this)
        super.onStop()
    }

    private fun fetchMovies(type: Constants.MovieListType, moviesPage: Int) {
        coroutineScope.launch {
            val startTime = System.currentTimeMillis()
            viewsMvc.showProgressIcon()
            try {
                val response = compositionRoot.fetchMovieUseCase.getMovieList(moviesPage, type)
                if (response is FetchMovieListUseCase.Result.Success && response.movieList.movies.isNotEmpty()) {
                    viewsMvc.bindMovies(response.movieList)
                   viewerEvents?.setPage(page, response.movieList.totalPages)
                    maxPage = response.movieList.totalPages
                } else {
                    onFetchFailed()
                }

                isDataLoaded = true
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    //it won't trigger if for example we change activity during downloading
                    onFetchFailed()
                }
            } finally {
                val downloadingTime = System.currentTimeMillis() - startTime
                Log.i(TAG, "movies downloaded in $downloadingTime millisSeconds")
                viewsMvc.hideProgressIcon()
            }
        }
    }


    private fun onFetchFailed() {
            compositionRoot.dialogNavigator.showConnectionErrorDialog()
    }

    override fun onMovieClick(movie: Movie) {

    }

    private fun loadPage(page: Int){
        if(page > 1)
            viewsMvc.rootView.btnLastPage.visibility = View.VISIBLE
        else
            viewsMvc.rootView.btnLastPage.visibility = View.INVISIBLE

        fetchMovies(movieListType,page)
    }

    override fun onNextClick() {
        if(page < maxPage)
        loadPage(++page)
    }

    override fun onLastClick() {
        if(page > 1)
        loadPage(--page)
    }


    companion object{
        fun getInstance(type: Constants.MovieListType): FragmentShowMovies = FragmentShowMovies().apply {
           arguments = Bundle().apply {
               putParcelable(param_type,type)
           }
        }
    }



}