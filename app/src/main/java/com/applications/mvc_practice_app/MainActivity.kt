package com.applications.mvc_practice_app

import android.os.Bundle
import android.provider.SyncStateContract
import androidx.appcompat.app.AppCompatActivity
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.MovieListFragmentComponents.FragmentShowMovies
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "mainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(fragmentContainer.id, FragmentShowMovies()).commit()
        supportActionBar?.title = "Movies"


    }

}