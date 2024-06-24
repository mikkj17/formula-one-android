package com.example.formulaone.constructor.domain

import androidx.lifecycle.ViewModel
import com.example.formulaone.constructor.data.Constructor
import com.example.formulaone.core.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ConstructorListViewModel @Inject constructor(
    private val repository: ConstructorRepository,
) : ViewModel() {
    suspend fun getCurrentConstructors(): Resource<List<Constructor>> {
        return repository.getConstructorsByYear(LocalDate.now().year)
    }
}
