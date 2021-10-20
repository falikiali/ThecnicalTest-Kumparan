package com.example.thecnicaltest_kumparan.ui.post

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thecnicaltest_kumparan.R
import com.example.thecnicaltest_kumparan.databinding.ListItemPostRowBinding
import com.example.thecnicaltest_kumparan.domain.model.Post
import com.example.thecnicaltest_kumparan.domain.model.User
import com.example.thecnicaltest_kumparan.ui.postdetail.PostDetailActivity

class MainAdapter : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {
    private var listPost = ArrayList<Post>()
    private val listUser = ArrayList<User>()

    fun setData(newListPost: List<Post>?) {
        if (newListPost == null) return
        listPost.clear()
        listPost.addAll(newListPost)
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
            with(binding) {
                ("\"" + data.title + "\"").also { tvTitle.text = it }
                tvBody.text = data.body
                listUser.forEach { user ->
                    if (user.id == data.userId) {
                        (user.name + " From " + user.company).also { tvUsers.text = it }
                    }
                }
            }

            listUser.forEach { user ->
                if (user.id == data.userId) {
                    with(itemView) {
                        setOnClickListener {
                            val intent = Intent(context, PostDetailActivity::class.java).apply {
                                putExtra(PostDetailActivity.DETAIL_POST, data)
                                putExtra(PostDetailActivity.USER, user)
                            }
                            context.startActivity(intent)
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_post_row, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listPost[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listPost.size
    }
}