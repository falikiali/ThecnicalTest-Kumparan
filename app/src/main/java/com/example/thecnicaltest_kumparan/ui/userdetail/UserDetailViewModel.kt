package com.example.thecnicaltest_kumparan.ui.userdetail

import androidx.lifecycle.ViewModel
import com.example.thecnicaltest_kumparan.domain.usecase.UseCaseInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(private val useCaseInteractor: UseCaseInteractor) : ViewModel() {
    fun getAlbum(userId: Int) = useCaseInteractor.getAlbum(userId)

    fun getPhoto(albumId: Int) = useCaseInteractor.getPhoto(albumId)
}