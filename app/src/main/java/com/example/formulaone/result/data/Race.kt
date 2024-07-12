package com.example.formulaone.result.data

import com.example.formulaone.circuit.data.Circuit
import com.google.gson.annotations.SerializedName

data class Race(
    val season: Int,
    val round: Int,
    val url: String,
    val raceName: String,
    @SerializedName("Circuit") val circuit: Circuit,
    val date: String,
    val time: String,
    @SerializedName("Results") val results: List<Result>
)
