package com.dicoding.mysdgapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.mysdgapp.databinding.ItemRowSdgsBinding

// done
class SdgAdapter(private val listSdg: ArrayList<Sdgs>) : RecyclerView.Adapter<SdgAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemRowSdgsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowSdgsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    // memasukkan preview di cardview
    override fun onBindViewHolder(holder: SdgAdapter.ListViewHolder, position: Int) {
        val (number, name, type, photo) = listSdg[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemNumber.text = number
        holder.binding.tvItemName.text = name
        holder.binding.tvItemType.text = type

        // activity yang akan dilakukan setelah diklik
        holder.itemView.setOnClickListener() {
            // intent ke sdg page activity
            val intentDetail = Intent(holder.itemView.context, SdgPageActivity::class.java)
            intentDetail.putExtra(
                SdgPageActivity.EXTRA_SDG,
                listSdg[holder.adapterPosition]
            )
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listSdg.size

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Sdgs)
    }


}
