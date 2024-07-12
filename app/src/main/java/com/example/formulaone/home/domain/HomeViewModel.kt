package com.example.formulaone.home.domain

import androidx.lifecycle.ViewModel
import com.example.formulaone.core.util.Resource
import com.example.formulaone.result.data.Race
import com.example.formulaone.result.domain.ResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val resultRepository: ResultRepository,
) : ViewModel() {
    suspend fun getMostRecentResult(): Resource<Race> {
        return resultRepository.getMostRecentResult()
    }
}
