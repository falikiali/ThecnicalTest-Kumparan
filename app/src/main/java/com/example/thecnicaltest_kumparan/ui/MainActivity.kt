package com.example.thecnicaltest_kumparan.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thecnicaltest_kumparan.databinding.ActivityMainBinding
import com.example.thecnicaltest_kumparan.utils.ResultState
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initRecyclerView()
        observeViewModel()
    }

    private fun initRecyclerView() {
        binding.rvView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = mainAdapter
        }
    }

    private fun onClickItem() {
        mainAdapter.onItemClick = {

        }
    }

    private fun observeViewModel() {
        viewModel.post.observe(this, { data ->
            when(data) {
                is ResultState.Error -> Log.d("Error", data.error)
                is ResultState.Success -> mainAdapter.setData(data.data)
            }
        })

        viewModel.user.observe(this, { data ->
            when(data) {
                is ResultState.Error -> Log.d("Error", data.error)
                is ResultState.Success -> mainAdapter.setUser(data.data)
            }
        })
    }
}