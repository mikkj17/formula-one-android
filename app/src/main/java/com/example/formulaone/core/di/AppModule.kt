package com.example.formulaone.core.di

import com.example.formulaone.circuit.domain.CircuitRepository
import com.example.formulaone.constructor.domain.ConstructorRepository
import com.example.formulaone.core.data.FormulaOneApi
import com.example.formulaone.core.util.Constants.BASE_URL
import com.example.formulaone.driver.domain.DriverRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideFormulaOneApi(): FormulaOneApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(FormulaOneApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDriverRepository(api: FormulaOneApi) = DriverRepository(api)

    @Singleton
    @Provides
    fun provideConstructorRepository(api: FormulaOneApi) = ConstructorRepository(api)

    @Singleton
    @Provides
    fun provideCircuitRepository(api: FormulaOneApi) = CircuitRepository(api)
}
