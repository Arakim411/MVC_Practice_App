package com.applications.mvc_practice_app.screens.fragmentHome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applications.mvc_practice_app.model.FragmentToolBarData
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.common.BaseFragment


class FragmentHome : BaseFragment(), HomeViewsMvc.FragmentHomeEvent {

    private lateinit var viewsMvc: HomeViewsMvc


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        viewsMvc = compositionRoot.homeViewsMvcFactory.newNavigatorViewsMvc(container)
        return viewsMvc.rootView
    }


    override fun onStart() {
        super.onStart()
        viewsMvc.addListener(this)
       setToolBarData(FragmentToolBarData("Home",null,null))
    }


    override fun onButtonClick(type: Constants.ListType) {
            viewerEvents?.addDataFragment(type)
    }



}