package com.example.formulaone.circuit.data

import com.google.gson.annotations.SerializedName

data class CircuitTable(
    val season: Int,
    @SerializedName("Circuits") val circuits: List<Circuit>,
)
