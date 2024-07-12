package com.example.formulaone.result.data

import com.google.gson.annotations.SerializedName

data class RaceTable(
    val season: Int,
    val round: Int,
    @SerializedName("Races") val races: List<Race>,
)
