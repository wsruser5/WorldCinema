package com.example.worldcinema

import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_with_text.*
import kotlinx.android.synthetic.main.row_layout.*

class MovieItem(private val content: MovieContent) : Item() {

    override fun getLayout() = R.layout.item_with_text

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        Picasso.get()
            .load(content.url)
            .into(viewHolder.image_preview)
    }
}

class MovieTitle(private val content: CategoryTitle) : Item() {

    override fun getLayout() = R.layout.row_layout

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.tvrow.text = content.categoryName
    }
}


data class MovieContent(
    val url: String
)

data class CategoryTitle(
    val categoryName: String
)