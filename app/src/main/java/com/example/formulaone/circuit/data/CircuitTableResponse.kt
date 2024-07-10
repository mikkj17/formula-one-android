package com.example.formulaone.circuit.data

import com.google.gson.annotations.SerializedName

data class CircuitTableResponse(
    val limit: Int,
    val offset: Int,
    val total: Int,
    @SerializedName("CircuitTable") val circuitTable: CircuitTable,
)
