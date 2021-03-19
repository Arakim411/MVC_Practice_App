package com.applications.mvc_practice_app.roots

import androidx.appcompat.app.AppCompatActivity
import com.applications.mvc_practice_app.MyApplication
import com.applications.mvc_practice_app.dialog.DialogNavigator
import com.applications.mvc_practice_app.screens.fragmentHome.HomeViesMvcFactory
import com.applications.mvc_practice_app.screens.ListFragmentComponents.ShowDataMvcFactory
import com.applications.mvc_practice_app.screens.detailsFragmentComponent.DetailsViewsMvcFactory

class ActivityCompositionRoot(private val appCompatActivity: AppCompatActivity) {

       private val appCompositionRoot = (appCompatActivity.application as MyApplication).appCompositionRoot
       private val layoutInflater = appCompatActivity.layoutInflater

        // Use Cases
        val fetchMovieUseCase = appCompositionRoot.fetchMovieUseCase
        val fetchTvShowUseCase = appCompositionRoot.fetchTvShowUseCase

        //ViewsMvcFactors
        val showDataViewsMvc = ShowDataMvcFactory(layoutInflater)
        val navigatorViewsMvc = HomeViesMvcFactory(layoutInflater)
        val detailsViewsMvc = DetailsViewsMvcFactory(layoutInflater)

        // navigation
        val dialogNavigator get() = DialogNavigator(appCompatActivity.supportFragmentManager)







}