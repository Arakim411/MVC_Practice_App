package com.applications.mvc_practice_app.screens.ListFragmentComponents

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applications.mvc_practice_app.model.FragmentToolBarData
import com.applications.mvc_practice_app.model.TMDBData
import com.applications.mvc_practice_app.model.movie.Movie
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.common.BaseFragment
import com.applications.mvc_practice_app.toStringResources
import kotlinx.android.synthetic.main.fragment_show_data.view.*
import kotlinx.coroutines.*
import java.lang.Error

private const val TAG = "fragment_show_data"
private const val param_type = "param_type"

class FragmentShowMovies : BaseFragment(), ShowDataViewsMvc.RecyclerViewEvents, ShowDataViewsMvc.DataViewsMvcEvents {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private lateinit var viewsMvc: ShowDataViewsMvc
    private var isDataLoaded = false
    private lateinit var listType: Constants.ListType
    private var page = 1
    private var maxPage = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        viewsMvc = compositionRoot.movieViewsMvcFactory.newMovieViewsMvc(container)

        return viewsMvc.rootView
    }

    override fun onStart() {
        listType = requireArguments().getParcelable<Constants.ListType>(param_type) ?: throw error("Fragment must be created by getInstance and contains in arguments movie list type")

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

    //any idea how to refactor this function ?
    private fun fetchData(type: Constants.ListType, page: Int) {
        coroutineScope.launch {
            val startTime = System.currentTimeMillis()
            viewsMvc.showProgressIcon()
            try {
                if(Constants.allMovieListType.contains(type)){
                val response = compositionRoot.fetchMovieUseCase.getMovieList(page, type)
                if (response is FetchMovieListUseCase.Result.Success && response.movieList.movies.isNotEmpty()) {
                    viewsMvc.bindMovies(response.movieList)
                    maxPage = response.movieList.totalPages
                    setToolBarData(FragmentToolBarData(listType.toStringResources(resources), this@FragmentShowMovies.page,maxPage))
                } else {
                    onFetchFailed()
                }
                }else if(Constants.allTvShowListType.contains(type)){
                    val response = compositionRoot.fetchTvShowUseCase.getTvShowList(page,type)
                    if (response is FetchTvShowListUseCase.Result.Success && response.tvShowList.tvShows.isNotEmpty()) {
                        viewsMvc.bindTvShow(response.tvShowList)
                        maxPage = response.tvShowList.totalPages
                        setToolBarData(FragmentToolBarData(listType.toStringResources(resources), this@FragmentShowMovies.page,maxPage))
                    } else {
                        onFetchFailed()
                    }
                }else{
                    throw Error("unknown list type")
                }

                isDataLoaded = true
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    //it won't trigger if for example we change activity during downloading
                    onFetchFailed()
                }
            } finally {
                val downloadingTime = System.currentTimeMillis() - startTime
                Log.i(TAG, "data downloaded in $downloadingTime millisSeconds")
                viewsMvc.hideProgressIcon()
            }
        }
    }


    private fun onFetchFailed() {
            compositionRoot.dialogNavigator.showConnectionErrorDialog()
    }

    override fun onItemClick(tmdbData: TMDBData) {
        viewerEvents?.addDetailsFragment(tmdbData)
        if(tmdbData is Movie){
            Log.d("XD5",tmdbData.title)
        }
    }

    private fun loadPage(page: Int){
        if(page > 1)
            viewsMvc.rootView.btnLastPage.visibility = View.VISIBLE
        else
            viewsMvc.rootView.btnLastPage.visibility = View.INVISIBLE

        fetchData(listType,page)
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
        fun getInstance(type: Constants.ListType): FragmentShowMovies = FragmentShowMovies().apply {
           arguments = Bundle().apply {
               putParcelable(param_type,type)
           }
        }
    }



}