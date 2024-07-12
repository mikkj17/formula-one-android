package com.example.formulaone.result.domain

import com.example.formulaone.core.data.FormulaOneApi
import com.example.formulaone.core.util.Resource
import com.example.formulaone.result.data.Race
import javax.inject.Inject

class ResultRepository @Inject constructor(
    private val api: FormulaOneApi
) {
    suspend fun getMostRecentResult(): Resource<Race> {
        val response = try {
            api.getMostRecentResult()
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "Could not fetch data...")
        }

        return Resource.Success(response.data.raceTable.races.first())
    }
}
