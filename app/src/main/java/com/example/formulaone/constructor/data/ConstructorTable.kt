package com.example.formulaone.constructor.data

import com.google.gson.annotations.SerializedName

data class ConstructorTable(
    val season: Int,
    @SerializedName("Constructors") val constructors: List<Constructor>,
)
