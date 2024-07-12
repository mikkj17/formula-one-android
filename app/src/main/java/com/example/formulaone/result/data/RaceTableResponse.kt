package com.example.formulaone.result.data

import com.google.gson.annotations.SerializedName

data class RaceTableResponse(
    val limit: Int,
    val offset: Int,
    val total: Int,
    @SerializedName("RaceTable") val raceTable: RaceTable,
)
