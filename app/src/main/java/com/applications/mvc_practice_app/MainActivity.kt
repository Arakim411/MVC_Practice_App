package com.applications.mvc_practice_app

import android.os.Bundle
import com.applications.mvc_practice_app.listeners.ViewerEvents
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.fragmentHome.FragmentHome
import com.applications.mvc_practice_app.screens.ListFragmentComponents.FragmentShowMovies
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "mainActivity"

class MainActivity : BaseActivity(), ViewerEvents {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMyToolbar(myToolbar)


        if (savedInstanceState == null)
            compositionRoot.fragmentRoots.addDataFragment(FragmentHome(), fragmentContainer.id)

    }


    override fun setTitle(title: kotlin.String) {
        myToolbar.setTitle(title)
    }

    override fun setPage(page: Int?, maxPage: Int?) {
        if (page != null && maxPage != null) {
            myToolbar.setPage(page, maxPage)
            myToolbar.setPageEnabled(true)
        } else
            myToolbar.setPageEnabled(false)
    }

    override fun addDataFragment(type: Constants.ListType) {
        compositionRoot.fragmentRoots.addDataFragment(FragmentShowMovies.getInstance(type), fragmentContainer.id)
    }

    override fun addDetailsFragment(data: TMDBData) {
        compositionRoot.fragmentRoots.addDetailsFragment(data,fragmentContainer.id)
    }


}