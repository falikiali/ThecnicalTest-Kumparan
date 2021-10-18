package com.example.thecnicaltest_kumparan.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thecnicaltest_kumparan.R
import com.example.thecnicaltest_kumparan.databinding.ListItemPostRowBinding
import com.example.thecnicaltest_kumparan.domain.model.Post
import com.example.thecnicaltest_kumparan.domain.model.User

class MainAdapter : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {
    private var listData = ArrayList<Post>()
    private val listUser = ArrayList<User>()
    var onItemClick: ((Post) -> Unit)? = null

    fun setData(newListData: List<Post>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    fun setUser(newListUser: List<User>?) {
        if (newListUser == null) return
        listUser.clear()
        listUser.addAll(newListUser)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemPostRowBinding.bind(itemView)
        fun bind(data: Post) {
            val user = listUser[data.userId - 1]
            with(binding) {
                tvTitle.text = data.title
                tvBody.text = data.body
                (user.name + " From " + user.company).also { tvUsers.text = it }
            }
        }

        init {
            binding.root.setOnClickListener { onItemClick?.invoke(listData[bindingAdapterPosition]) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_post_row, parent, false))
    }

    override fun onBindViewHolder(holder: MainAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}