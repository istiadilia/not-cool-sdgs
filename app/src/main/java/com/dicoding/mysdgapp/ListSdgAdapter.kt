package com.dicoding.mysdgapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//formatting how each collection elements will be displayed
class ListSdgAdapter(private val listSdg: ArrayList<Sdgs>) : RecyclerView.Adapter<ListSdgAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Sdgs)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    //muncul otomatis setelah di-implement

    //membuat dan menginisialisasi ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_sdgs, parent, false)
        return ListViewHolder(view)
    }

    //mengatribusikan ViewHolder dengan data
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listSdg[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
    }

    //mendapat ukuran set data
    override fun getItemCount(): Int = listSdg.size
}