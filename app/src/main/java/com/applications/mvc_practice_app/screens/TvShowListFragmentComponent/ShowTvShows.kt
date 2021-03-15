package com.applications.mvc_practice_app.screens.TvShowListFragmentComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applications.mvc_practice_app.R


class ShowTvShows : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_tv_shows, container, false)
    }

}

