package com.example.thecnicaltest_kumparan.ui.userdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thecnicaltest_kumparan.databinding.ActivityUserDetailBinding
import com.example.thecnicaltest_kumparan.domain.model.User
import com.example.thecnicaltest_kumparan.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailActivity : AppCompatActivity() {
    private val userDetailViewModel: UserDetailViewModel by viewModels()
    private lateinit var binding: ActivityUserDetailBinding
    private val userDetailAdapter = UserDetailAdapter()

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        title = "Detail User Page"

        getIntentData()
        initRecyclerView()
    }

    private fun getIntentData() {
        val user = intent.getParcelableExtra<User>(EXTRA_USER)

        if (user != null) {
            showDetailUser(user)
        }
    }

    private fun showDetailUser(user: User) {
        binding.apply {
            tvName.text = user.name
            tvAddress.text = user.address
            tvCompany.text = user.company
            tvEmail.text = user.email
            tvPhone.text = user.phone
            tvWebsite.text = user.website
        }
        observeViewModel(user.id)
    }

    private fun initRecyclerView() {
        binding.rvAlbums.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = userDetailAdapter
        }
    }

    private fun observeViewModel(userId: Int) {
        userDetailViewModel.getAlbum(userId).observe(this, { data ->
            if (data is ResultState.Success) {
                userDetailAdapter.setData(data.data)
            }
        })

        userDetailViewModel.listPhoto.observe(this, { photo ->
            if (photo is ResultState.Success) {
                userDetailAdapter.setDataPhoto(photo.data)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}