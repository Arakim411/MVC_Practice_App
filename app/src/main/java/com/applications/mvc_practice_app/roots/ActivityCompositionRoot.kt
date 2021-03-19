package com.applications.mvc_practice_app.roots

import androidx.appcompat.app.AppCompatActivity
import com.applications.mvc_practice_app.MyApplication
import com.applications.mvc_practice_app.dialog.DialogNavigator
import com.applications.mvc_practice_app.screens.fragmentHome.HomeViesMvcFactory
import com.applications.mvc_practice_app.screens.movieListFragmentComponents.MovieViewsMvcFactory

class ActivityCompositionRoot(private val appCompatActivity: AppCompatActivity) {

       private val appCompositionRoot = (appCompatActivity.application as MyApplication).appCompositionRoot
       private val layoutInflater = appCompatActivity.layoutInflater

        val fetchMovieUseCase = appCompositionRoot.fetchMovieUseCase
        val moviesViewsMvc = MovieViewsMvcFactory(layoutInflater)
        val navigatorViewsMvc = HomeViesMvcFactory(layoutInflater)
        val dialogNavigator get() = DialogNavigator(appCompatActivity.supportFragmentManager)







}