package com.example.formulaone.result.data

import com.google.gson.annotations.SerializedName

data class FastestLap(
    val rank: Int,
    val lap: Int,
    val time: Time,
    @SerializedName("AverageSpeed") val averageSpeed: AverageSpeed,
)
