package com.example.thecnicaltest_kumparan.ui.postdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thecnicaltest_kumparan.R
import com.example.thecnicaltest_kumparan.databinding.ListItemCommentRowBinding
import com.example.thecnicaltest_kumparan.domain.model.Comment

class PostDetailAdapter : RecyclerView.Adapter<PostDetailAdapter.ListViewHolder>() {
    private var listComment = ArrayList<Comment>()

    fun setData(newListComment: List<Comment>?) {
        if (newListComment == null) return
        listComment.clear()
        listComment.addAll(newListComment)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemCommentRowBinding.bind(itemView)
        fun bind(data: Comment) {
            with(binding) {
                tvName.text = data.name
                tvComment.text = data.body
                ("<" + data.email + ">").also { tvEmail.text = it }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_comment_row, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listComment[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listComment.size
    }
}