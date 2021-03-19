package com.applications.mvc_practice_app

import android.os.Bundle
import com.applications.mvc_practice_app.listeners.ViewerEvents
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.fragmentHome.FragmentHome
import com.applications.mvc_practice_app.screens.movieListFragmentComponents.FragmentShowMovies
import kotlinx.android.synthetic.main.activity_main.*


private const val TAG = "mainActivity"

class MainActivity : BaseActivity(), ViewerEvents {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMyToolbar(myToolbar)

        if(savedInstanceState== null)
        compositionRoot.fragmentRoots.addFragment(FragmentHome(),fragmentContainer.id)

    }


    override fun setTitle(title: kotlin.String) {
        myToolbar.title = title
    }

    override fun setPage(page: Int, maxPage: Int) {
       myToolbar.setPage(page,maxPage)
    }

    override fun addFragment(type: Constants.MovieListType) {
        compositionRoot.fragmentRoots.addFragment(FragmentShowMovies.getInstance(type),fragmentContainer.id)
    }


}