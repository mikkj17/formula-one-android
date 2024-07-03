package com.example.formulaone.circuit.domain

import androidx.lifecycle.ViewModel
import com.example.formulaone.circuit.data.Circuit
import com.example.formulaone.core.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class CircuitListViewModel @Inject constructor(
    private val repository: CircuitRepository,
) : ViewModel() {
    suspend fun getCurrentCircuits(): Resource<List<Circuit>> {
        return repository.getCircuitsByYear(LocalDate.now().year)
    }
}
