package com.example.thecnicaltest_kumparan.ui.userdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thecnicaltest_kumparan.R
import com.example.thecnicaltest_kumparan.databinding.ListItemPhotoRowBinding
import com.example.thecnicaltest_kumparan.domain.model.Photo

class UserDetailChildAdapter : RecyclerView.Adapter<UserDetailChildAdapter.ListViewHolder>() {
    private var listPhoto = ArrayList<Photo>()

    fun setDataPhoto(newListPhoto: List<Photo>?) {
        if (newListPhoto == null) return
        listPhoto.clear()
        listPhoto.addAll(newListPhoto)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemPhotoRowBinding.bind(itemView)
        fun bind(data: Photo) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.thumbnailUrl)
                    .into(ivPhoto)
                tvTitle.text = data.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_photo_row, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listPhoto[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listPhoto.size
    }
}