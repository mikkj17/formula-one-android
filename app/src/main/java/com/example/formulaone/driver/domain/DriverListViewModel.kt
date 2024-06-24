package com.example.formulaone.driver.domain

import androidx.lifecycle.ViewModel
import com.example.formulaone.core.util.Resource
import com.example.formulaone.driver.data.Driver
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class DriverListViewModel @Inject constructor(
    private val repository: DriverRepository,
) : ViewModel() {
    suspend fun getAllDrivers(): Resource<List<Driver>> {
        return repository.getAllDrivers()
    }

    suspend fun getCurrentDrivers(): Resource<List<Driver>> {
        return repository.getDriversByYear(LocalDate.now().year)
    }
}
