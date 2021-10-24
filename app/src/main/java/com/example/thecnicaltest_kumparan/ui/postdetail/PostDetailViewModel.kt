package com.example.thecnicaltest_kumparan.ui.postdetail

import androidx.lifecycle.ViewModel
import com.example.thecnicaltest_kumparan.domain.usecase.UseCase
import com.example.thecnicaltest_kumparan.domain.usecase.UseCaseInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(private val useCase: UseCase) : ViewModel(){
    fun getComment(postId: Int) = useCase.getComment(postId)
}