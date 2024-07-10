package com.example.formulaone.driver.data

import com.google.gson.annotations.SerializedName

data class DriverTableResponse(
    val limit: Int,
    val offset: Int,
    val total: Int,
    @SerializedName("DriverTable") val driverTable: DriverTable,
)
