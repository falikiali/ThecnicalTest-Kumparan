package com.example.thecnicaltest_kumparan.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thecnicaltest_kumparan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
    }
}