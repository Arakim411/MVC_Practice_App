package com.applications.mvc_practice_app.screens.roots

import androidx.appcompat.app.AppCompatActivity
import com.applications.mvc_practice_app.MyApplication
import com.applications.mvc_practice_app.screens.MovieListFragmentComponents.MovieViewsMvcFactory

class ActivityCompositionRoot(appCompatActivity: AppCompatActivity) {

        val appCompositionRoot = (appCompatActivity.application as MyApplication).appCompositionRoot
        val layoutInflater = appCompatActivity.layoutInflater
        val fetchMovieUseCase = appCompositionRoot.fetchMovieUseCase
        val moviesViewsMvc = MovieViewsMvcFactory(layoutInflater)

}