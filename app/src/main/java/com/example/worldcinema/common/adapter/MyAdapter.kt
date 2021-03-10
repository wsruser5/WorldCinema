package com.example.worldcinema.common.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcinema.R
import com.mrz.apiwork.model.Post
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_layout.view.*


class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //Список всех элементов
    private var myList = emptyList<Post>()

    // Нада, но внутрянку можешь удалить, по клику на элемент вызывает тост
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

//    создает новый объект ViewHolder всякий раз, когда RecyclerView нуждается в этом.
//    Это тот момент, когда создаётся layout строки списка, передается объекту ViewHolder, и каждый дочерний view-компонент может быть найден и сохранен.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    // Количество элементов
    override fun getItemCount(): Int {
        return myList.size
    }

    //Заполнение списка и считывание кликов
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //По нажатию на clrow (самому элементу списка), выполняется действие
        holder.itemView.clrow.setOnClickListener {

        }
    }

    fun setData(newList: List<Post>) {
        myList = newList
        notifyDataSetChanged()
    }

}