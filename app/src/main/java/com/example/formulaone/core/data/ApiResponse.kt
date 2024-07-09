package com.example.formulaone.core.data

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("MRData") val data: T
)
