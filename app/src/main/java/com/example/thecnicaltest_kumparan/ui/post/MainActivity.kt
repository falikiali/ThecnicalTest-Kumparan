package com.example.thecnicaltest_kumparan.ui.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thecnicaltest_kumparan.databinding.ActivityMainBinding
import com.example.thecnicaltest_kumparan.utils.ResultState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Techical Test"

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
        mainViewModel.post.observe(this, { data ->
            when(data) {
                is ResultState.Error -> Log.d("Error", data.error)
                is ResultState.Success -> mainAdapter.setData(data.data)
                is ResultState.Empty -> Log.d("Post", "Data is empty")
            }
        })

        mainViewModel.user.observe(this, { data ->
            when(data) {
                is ResultState.Error -> Log.d("Error", data.error)
                is ResultState.Success -> mainAdapter.setUser(data.data)
                is ResultState.Empty -> Log.d("User", "Data is empty")
            }
        })
    }
}