package com.example.worldcinema.mainScreen

import com.example.worldcinema.R
import com.example.worldcinema.data.MoviesList
import com.example.worldcinema.data.MoviesListItem
import com.mrz.worldcinema.constants.Constants
import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_with_text.*
import kotlinx.android.synthetic.main.row_layout.*

class MovieItem(private val content: MoviesList) : Item() {

    override fun getLayout() = R.layout.item_with_text

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        Picasso.get()
            .load(Constants.IMG_URL +content)
            .into(viewHolder.image_preview)
    }
}

data class MovieContent(
    val urlImg: String
)
