package com.example.thecnicaltest_kumparan.ui.userdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.thecnicaltest_kumparan.R
import com.example.thecnicaltest_kumparan.databinding.ActivityUserDetailBinding
import com.example.thecnicaltest_kumparan.domain.model.User

class UserDetailActivity : AppCompatActivity() {
    private val userDetailViewModel: UserDetailViewModel by viewModels()
    private lateinit var binding: ActivityUserDetailBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getIntentData()
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
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}