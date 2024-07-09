package com.example.formulaone.driver.data

import com.google.gson.annotations.SerializedName

data class DriverTable(
    val season: String,
    @SerializedName("Drivers") val drivers: List<Driver>
)
