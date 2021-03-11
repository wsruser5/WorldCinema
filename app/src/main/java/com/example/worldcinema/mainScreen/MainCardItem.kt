package com.example.worldcinema.mainScreen

import com.example.worldcinema.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_card.*

class MainCardContainer(
    private val onClick: (url: String) -> Unit,
    private val items: List<Item>
) : Item() {

    override fun getLayout() = R.layout.item_card

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.items_container.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(items) }
    }
}

class TitleContainer(
    private val onClick: (url: String) -> Unit,
    private val items: List<Item>
) : Item() {

    override fun getLayout() = R.layout.item_title

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.items_container.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(items) }
    }
}
