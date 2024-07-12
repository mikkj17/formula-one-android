package com.example.formulaone.result.data

import com.example.formulaone.constructor.data.Constructor
import com.example.formulaone.driver.data.Driver
import com.google.gson.annotations.SerializedName

data class Result(
    val number: Int,
    val position: Int,
    val positionText: String,
    val points: Float,
    @SerializedName("Driver") val driver: Driver,
    @SerializedName("Constructor") val constructor: Constructor,
    val grid: Int,
    val laps: Int,
    val status: String,
    val time: Time,
    @SerializedName("FastestLap") val fastestLap: FastestLap,
)
