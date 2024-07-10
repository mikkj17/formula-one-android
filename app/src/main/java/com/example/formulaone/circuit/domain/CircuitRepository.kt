package com.example.formulaone.circuit.domain

import com.example.formulaone.circuit.data.Circuit
import com.example.formulaone.core.data.FormulaOneApi
import com.example.formulaone.core.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CircuitRepository @Inject constructor(
    private val api: FormulaOneApi,
) {
    suspend fun getCircuitsByYear(year: Int): Resource<List<Circuit>> {
        val response = try {
            api.getCircuitsByYear(year)
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "Could not fetch data...")
        }

        return Resource.Success(response.data.circuitTable.circuits)
    }
}
