package com.dicoding.mysdgapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mysdgapp.databinding.ItemRowSdgsBinding

class SdgAdapter(private val listSdg: ArrayList<Sdgs>) : RecyclerView.Adapter<SdgAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Sdgs)
    }

    class ListViewHolder(var binding: ItemRowSdgsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowSdgsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SdgAdapter.ListViewHolder, position: Int) {
        val (name, description, photo) = listSdg[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener() {
            val intentDetail = Intent(holder.itemView.context, SdgPageActivity::class.java)
            intentDetail.putExtra(
                SdgPageActivity.EXTRA_SDG,
                listSdg[holder.adapterPosition]
            )
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listSdg.size

}