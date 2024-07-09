package com.example.formulaone.driver.data

import com.google.gson.annotations.SerializedName

data class DriverTableResponse(
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("DriverTable") val driverTable: DriverTable,
)
