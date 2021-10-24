package com.example.thecnicaltest_kumparan.ui.photodetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thecnicaltest_kumparan.databinding.ActivityPhotoDetailBinding
import com.example.thecnicaltest_kumparan.domain.model.Photo
import com.squareup.picasso.Picasso

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
        with(binding) {
            Picasso.get().load(photo.url).into(ivPhoto)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}