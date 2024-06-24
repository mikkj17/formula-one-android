package com.example.formulaone.driver.domain

import com.example.formulaone.core.data.FormulaOneApi
import com.example.formulaone.core.util.Resource
import com.example.formulaone.driver.data.Driver
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class DriverRepository @Inject constructor(
    private val api: FormulaOneApi
) {
    val driversByYear = mutableMapOf<Int, List<Driver>>()

    suspend fun getDriversByYear(year: Int): Resource<List<Driver>> {
        val response = try {
            api.getDriversByYear(year.toString())
        } catch (e: Exception) {
            return Resource.Error("Could not fetch data...")
        }

        return Resource.Success(response.MRData.DriverTable.Drivers)
    }

    suspend fun getAllDrivers() = getDrivers(1000, 0)

    private suspend fun getDrivers(
        limit: Int,
        offset: Int
    ): Resource<List<Driver>> {
        val response = try {
            api.getDrivers(limit = limit.toString(), offset = offset.toString())
        } catch (e: Exception) {
            return Resource.Error("Could not fetch data...")
        }

        return Resource.Success(response.MRData.DriverTable.Drivers)
    }
}
