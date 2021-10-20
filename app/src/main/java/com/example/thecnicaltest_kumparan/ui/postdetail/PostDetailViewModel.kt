package com.example.thecnicaltest_kumparan.ui.postdetail

import androidx.lifecycle.ViewModel
import com.example.thecnicaltest_kumparan.domain.usecase.UseCaseInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(private val useCaseInteractor: UseCaseInteractor) : ViewModel(){
    fun getComment(postId: Int) = useCaseInteractor.getComment(postId)
}