package com.example.formulaone.core.data

import com.example.formulaone.circuit.data.CircuitTableResponse
import com.example.formulaone.constructor.data.ConstructorTableResponse
import com.example.formulaone.driver.data.DriverTableResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FormulaOneApi {
    @GET("drivers.json")
    suspend fun getDrivers(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): ApiResponse<DriverTableResponse>

    @GET("{year}/drivers.json")
    suspend fun getDriversByYear(@Path("year") year: Int): ApiResponse<DriverTableResponse>

    @GET("constructors.json")
    suspend fun getConstructors(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): ApiResponse<ConstructorTableResponse>

    @GET("{year}/constructors.json")
    suspend fun getConstructorsByYear(
        @Path("year") year: Int,
    ): ApiResponse<ConstructorTableResponse>

    @GET("circuits.json")
    suspend fun getCircuits(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): ApiResponse<CircuitTableResponse>

    @GET("{year}/circuits.json")
    suspend fun getCircuitsByYear(
        @Path("year") year: Int,
    ): ApiResponse<CircuitTableResponse>
}
