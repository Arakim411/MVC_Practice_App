package com.applications.mvc_practice_app

import android.app.Application
import com.applications.mvc_practice_app.screens.roots.AppCompositionRoot

class MyApplication : Application() {

    lateinit var appCompositionRoot: AppCompositionRoot

    override fun onCreate() {
        appCompositionRoot = AppCompositionRoot()
        super.onCreate()
    }
}