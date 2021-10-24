package com.example.thecnicaltest_kumparan.ui.postdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thecnicaltest_kumparan.databinding.ActivityPostDetailBinding
import com.example.thecnicaltest_kumparan.domain.model.Post
import com.example.thecnicaltest_kumparan.domain.model.User
import com.example.thecnicaltest_kumparan.ui.post.MainActivity
import com.example.thecnicaltest_kumparan.ui.userdetail.UserDetailActivity
import com.example.thecnicaltest_kumparan.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostDetailBinding
    private val postDetailViewModel: PostDetailViewModel by viewModels()
    private val postDetailAdapter = PostDetailAdapter()

    companion object {
        const val DETAIL_POST = "detail_post"
        const val USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Detail Post Page"

        getIntentData()
        initRecyclerView()
    }

    private fun getIntentData() {
        val post = intent.getParcelableExtra<Post>(DETAIL_POST)
        val user = intent.getParcelableExtra<User>(USER)

        if (post != null && user != null) {
            showDataDetailPost(post, user)
        }

        if (user != null) {
            onClickUserName(user)
        }
    }

    private fun showDataDetailPost(post: Post, user: User) {
        binding.apply {
            tvTitle.text = post.title
            tvBody.text = post.body
            tvUserName.text = user.name
            tvUserCompany.text = user.company
        }
        observeViewModel(post.id)
    }

    private fun onClickUserName(user: User) {
        binding.tvUserName.setOnClickListener {
            val intent = Intent(this, UserDetailActivity::class.java).apply {
                putExtra(UserDetailActivity.EXTRA_USER, user)
            }
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        binding.rvComments.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = postDetailAdapter
        }
    }

    private fun observeViewModel(postId: Int) {
        postDetailViewModel.getComment(postId).observe(this, { data ->
            if (data is ResultState.Success) postDetailAdapter.setData(data.data)
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}