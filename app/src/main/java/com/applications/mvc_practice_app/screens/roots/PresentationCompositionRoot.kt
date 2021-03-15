package com.applications.mvc_practice_app.screens.roots

import androidx.appcompat.app.AppCompatActivity

class PresentationCompositionRoot(appCompatActivity: AppCompatActivity) {

   private val activityCompositionRoot = ActivityCompositionRoot(appCompatActivity)
    val fetchMovieUseCase get() = activityCompositionRoot.fetchMovieUseCase
    val movieViewsMvcFactory get() =  activityCompositionRoot.moviesViewsMvc

}