package com.example.thecnicaltest_kumparan.ui.photodetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.thecnicaltest_kumparan.R
import com.example.thecnicaltest_kumparan.databinding.ActivityPhotoDetailBinding
import com.example.thecnicaltest_kumparan.domain.model.Photo

class PhotoDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityPhotoDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getIntentData()
    }

    private fun getIntentData() {
        val photo = intent.getParcelableExtra<Photo>(EXTRA_DATA)

        if (photo != null) {
            setTitle(photo)
            setImageView(photo)
        }
    }

    private fun setTitle(photo: Photo) {
        title = photo.title
    }

    private fun setImageView(photo: Photo) {
        Glide.with(this)
            .load(photo.url)
            .into(binding.ivPhoto)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}