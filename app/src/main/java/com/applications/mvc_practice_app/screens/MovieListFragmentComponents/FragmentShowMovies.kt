package com.applications.mvc_practice_app.screens.MovieListFragmentComponents

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applications.mvc_practice_app.MyApplication
import com.applications.mvc_practice_app.R
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.common.BaseFragment
import kotlinx.coroutines.*
import java.util.*

private const val TAG = "fragment_movies"

class FragmentShowMovies : BaseFragment(), ShowMoviesViewsMvc.ShowMoviesEvents {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private lateinit var viewsMvc: ShowMoviesViewsMvc
    private var isDataLoaded = false
    private var page = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        viewsMvc = compositionRoot.movieViewsMvcFactory.newMovieViewsMvc(container)

        return viewsMvc.rootView
    }

    override fun onStart() {
        viewsMvc.addListener(this)
        if (!isDataLoaded) {
            fetchMovies()
        }
        super.onStart()
    }

    override fun onStop() {
        coroutineScope.coroutineContext.cancelChildren()
        viewsMvc.removeListener(this)
        super.onStop()
    }

    fun fetchMovies() {
        coroutineScope.launch {
            val startTime = System.currentTimeMillis()
            viewsMvc.showProgressIcon()
            try {
                for (i in Constants.allMovieListType) {
                    val response = compositionRoot.fetchMovieUseCase.getMovieList(page, i)

                    if (response is FetchMovieListUseCase.Result.Success) {
                        viewsMvc.bindMovies(response.movieList, i)
                    } else {
                        onFetchFailed()
                    }
                }
                isDataLoaded = true
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    //it won't trigger if for example we change activity during downloading
                    onFetchFailed()
                }
            } finally {
                val downloadingTime =  System.currentTimeMillis() - startTime
                Log.i(TAG,"movies downloaded in $downloadingTime millisSeconds")
                viewsMvc.hideProgressIcon()
            }
        }
    }


    fun onFetchFailed() {

    }

    override fun onMovieClick(movieId: Int) {

    }

    override fun onRefresh() {

    }

}