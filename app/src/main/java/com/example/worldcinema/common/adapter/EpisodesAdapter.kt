package com.example.worldcinema.common.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.worldcinema.R
import com.example.worldcinema.data.EpisodesList
import com.example.worldcinema.mainScreen.RecyclerItemScreen
import com.mrz.worldcinema.constants.Constants
import kotlinx.android.synthetic.main.item_images.view.*


class EpisodesAdapter: RecyclerView.Adapter<EpisodesAdapter.MyViewHolder>() {

    private var myList = emptyList<EpisodesList>()
    private var imagesList = emptyList<String?>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_images, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.tvNameEpisode.text = myList[position].name
        holder.itemView.tvDateEpisode.text = myList[position].year
        holder.itemView.tvDescEpisode.text = myList[position].description

        Glide.with(holder.itemView)
            .load(Constants.IMG_URL + imagesList[position])
            .into(holder.itemView.ivEpisodePreview)

        Log.d("testGif", myList.size.toString())

        holder.itemView.content.setOnClickListener {
            val context=holder.itemView.content.context
            val intent = Intent( context, RecyclerItemScreen::class.java)

            //старт активити
            context.startActivity(intent)
        }
    }

    fun setData(newList: List<EpisodesList>,images: List<String>) {
        myList = newList
        imagesList = images
        notifyDataSetChanged()
    }

}