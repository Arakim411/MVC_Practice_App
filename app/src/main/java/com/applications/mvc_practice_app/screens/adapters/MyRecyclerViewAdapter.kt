package com.applications.mvc_practice_app.screens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applications.mvc_practice_app.R
import com.applications.mvc_practice_app.RecyclerViewData
import com.applications.mvc_practice_app.model.movie.Movie
import com.applications.mvc_practice_app.model.tv_show.TvShow
import com.applications.mvc_practice_app.model.tv_show.TvShowList
import com.applications.mvc_practice_app.networking.Constants
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import kotlinx.android.synthetic.main.recycler_view_layout.view.*
import kotlinx.android.synthetic.main.recycler_view_layout.view.title

class MyRecyclerViewAdapter : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    // Item can be Movie or TvShow
    private var dataList = ArrayList<RecyclerViewData>()


    class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //code in following 2 functions is repeated, there can be one function to bind, but current state allows as to future modify
        fun bindMovie(movie: Movie) {
            view.title.text = movie.title
            view.voteAverage.text = movie.voteAverage.toString()
            val imageUrl = Constants.BASE_URL + movie.posterPath
            Glide.with(view.context).load(imageUrl).into(view.image)
        }

        fun bindTvShow(tvShow: TvShow) {
            view.title.text = tvShow.name
            view.voteAverage.text = tvShow.voteAverage.toString()
            val imageUrl = Constants.BASE_URL + tvShow.posterPath
            Glide.with(view.context).load(imageUrl).into(view.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        when (val item = dataList[position]) {
            is Movie -> holder.bindMovie(item)
            is TvShow -> holder.bindTvShow(item)
            else -> throw error("Unknown itemClass ${item.javaClass}")
        }
    }

    fun setData(list: ArrayList<RecyclerViewData>) {
        dataList = list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = dataList.size

}