package com.example.formulaone.constructor.data

import com.google.gson.annotations.SerializedName

data class ConstructorTableResponse(
    val limit: String,
    val offset: String,
    val total: String,
    @SerializedName("ConstructorTable") val constructorTable: ConstructorTable,
)
