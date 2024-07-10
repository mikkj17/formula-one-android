package com.example.formulaone.constructor.data

import com.google.gson.annotations.SerializedName

data class ConstructorTableResponse(
    val limit: Int,
    val offset: Int,
    val total: Int,
    @SerializedName("ConstructorTable") val constructorTable: ConstructorTable,
)
