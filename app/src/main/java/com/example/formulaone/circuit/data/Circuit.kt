package com.example.formulaone.circuit.data

import com.google.gson.annotations.SerializedName

data class Circuit(
    val circuitId: String,
    val url: String,
    val circuitName: String,
    @SerializedName("Location") val location: Location,
)
