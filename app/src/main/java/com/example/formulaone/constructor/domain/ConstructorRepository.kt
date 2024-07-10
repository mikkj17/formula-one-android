package com.example.formulaone.constructor.domain

import com.example.formulaone.constructor.data.Constructor
import com.example.formulaone.core.data.FormulaOneApi
import com.example.formulaone.core.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ConstructorRepository @Inject constructor(
    private val api: FormulaOneApi,
) {
    suspend fun getConstructorsByYear(year: Int): Resource<List<Constructor>> {
        val response = try {
            api.getConstructorsByYear(year)
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "Could not fetch data...")
        }

        return Resource.Success(response.data.constructorTable.constructors)
    }
}
