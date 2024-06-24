package com.example.formulaone.core.data

import com.example.formulaone.constructor.data.ConstructorTableResponse
import com.example.formulaone.driver.data.DriverTableResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FormulaOneApi {
    @GET("drivers.json")
    suspend fun getDrivers(
        @Query("limit") limit: String,
        @Query("offset") offset: String,
    ): ApiResponse<DriverTableResponse>

    @GET("{year}/drivers.json")
    suspend fun getDriversByYear(@Path("year") year: String): ApiResponse<DriverTableResponse>

    @GET("constructors.json")
    suspend fun getConstructors(
        @Query("limit") limit: String,
        @Query("offset") offset: String,
    ): ApiResponse<ConstructorTableResponse>

    @GET("{year}/constructors.json")
    suspend fun getConstructorsByYear(
        @Path("year") year: String,
    ): ApiResponse<ConstructorTableResponse>
}
