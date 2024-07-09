package com.example.formulaone.circuit.data

import com.google.gson.annotations.SerializedName

data class CircuitTable(
    val season: String,
    @SerializedName("Circuits") val circuits: List<Circuit>,
)
