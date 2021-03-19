package com.applications.mvc_practice_app.screens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applications.mvc_practice_app.R
import com.applications.mvc_practice_app.TMDBData
import com.applications.mvc_practice_app.model.movie.Movie
import com.applications.mvc_practice_app.model.tv_show.TvShow
import com.applications.mvc_practice_app.networking.Constants
import com.applications.mvc_practice_app.screens.ListFragmentComponents.ShowDataViewsMvc
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class MyRecyclerViewAdapter : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    // Item can be Movie or TvShow
    private var dataList = ArrayList<TMDBData>()

    private val events = HashSet<ShowDataViewsMvc.RecyclerViewEvents>()

    class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //code in following 2 functions is repeated, there can be one function to bind, but current state allows as to future modify
        fun bindMovie(movie: Movie, listeners: HashSet<ShowDataViewsMvc.RecyclerViewEvents>) {
            view.title.text = movie.title
            view.ratingBar.rating = movie.voteAverage?.div(2f) ?: 0f
            //  view.voteAverage.text = movie.voteAverage.toString()
            val imageUrl = Constants.BASE_URL_FOR_PHOTO + movie.posterPath
            Glide.with(view.context).load(imageUrl).into(view.image)
            view.setOnClickListener {
                listeners.forEach {
                    it.onItemClick(movie)
                }
            }

        }

        fun bindTvShow(tvShow: TvShow, listeners: HashSet<ShowDataViewsMvc.RecyclerViewEvents>) {
            view.title.text = tvShow.name
            view.ratingBar.rating = tvShow.voteAverage?.div(2f) ?: 0f
            val imageUrl = Constants.BASE_URL_FOR_PHOTO + tvShow.posterPath
            Glide.with(view.context).load(imageUrl).into(view.image)

            view.setOnClickListener {
                listeners.forEach {
                    it.onItemClick(tvShow)
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return MyRecyclerViewAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyRecyclerViewAdapter.MyViewHolder, position: Int) {
        when (val item = dataList[position]) {
            is Movie -> holder.bindMovie(item, events)
            is TvShow -> holder.bindTvShow(item,events)
            else -> throw error("Unknown itemClass ${item.javaClass}")

        }
    }

    fun setData(list: ArrayList<TMDBData>) {
        dataList = list
        //we add empty item to know when user is at the end of page
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = dataList.size

    fun registerListener(events: ShowDataViewsMvc.RecyclerViewEvents) {
        this.events.add(events)
    }


}