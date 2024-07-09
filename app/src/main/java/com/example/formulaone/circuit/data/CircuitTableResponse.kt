package com.example.formulaone.circuit.data

import com.google.gson.annotations.SerializedName

data class CircuitTableResponse(
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("CircuitTable") val circuitTable: CircuitTable,
)
