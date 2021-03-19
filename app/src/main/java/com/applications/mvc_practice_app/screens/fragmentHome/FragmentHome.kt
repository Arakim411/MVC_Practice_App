package com.applications.mvc_practice_app.screens.fragmentHome

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.common.BaseFragment


class FragmentHome : BaseFragment(), HomeViewsMvc.FragmentHomeEvent {

    private lateinit var viewsMvc: HomeViewsMvc


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment


        viewsMvc = compositionRoot.navigatorViewsMvcFactory.newNavigatorViewsMvc(container)
        return viewsMvc.rootView
    }

    override fun onStart() {
        super.onStart()
        viewsMvc.addListener(this)
    }

    override fun onResume() {
        Log.d("XD5","onResume")
        super.onResume()
    }


    override fun onButtonClick(type: Constants.MovieListType) {
            viewerEvents?.addFragment(type)
    }



}