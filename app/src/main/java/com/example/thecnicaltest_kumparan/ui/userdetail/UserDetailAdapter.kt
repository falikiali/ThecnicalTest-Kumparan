package com.example.thecnicaltest_kumparan.ui.userdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thecnicaltest_kumparan.R
import com.example.thecnicaltest_kumparan.databinding.ListItemAlbumRowBinding
import com.example.thecnicaltest_kumparan.domain.model.Album
import com.example.thecnicaltest_kumparan.domain.model.Photo

class UserDetailAdapter : RecyclerView.Adapter<UserDetailAdapter.ListViewHolder>() {
    private var listAlbum = ArrayList<Album>()
    private var listPhoto = ArrayList<Photo>()

    fun setData(newListAlbum: List<Album>?) {
        if (newListAlbum == null) return
        listAlbum.clear()
        listAlbum.addAll(newListAlbum)
        notifyDataSetChanged()
    }

    fun setDataPhoto(newListPhoto: List<Photo>?) {
        if (newListPhoto == null) return
        listPhoto.clear()
        listPhoto.addAll(newListPhoto)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemAlbumRowBinding.bind(itemView)
        fun bind(data: Album) {
            with(binding) {
                tvTitle.text = data.title

                val childAdapter = UserDetailChildAdapter()
                val dataChildAdapter = ArrayList<Photo>()
                listPhoto.forEach {
                    if (it.albumId == data.id) {
                        dataChildAdapter.add(it)
                    }
                }
                childAdapter.setDataPhoto(dataChildAdapter)


                rvPhotos.apply {
                    layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = childAdapter
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserDetailAdapter.ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_album_row, parent, false))
    }

    override fun onBindViewHolder(holder: UserDetailAdapter.ListViewHolder, position: Int) {
        val data = listAlbum[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listAlbum.size
    }

}