package com.example.myweather.di

import android.content.Context
import com.example.myweather.data.datasource.HttpClientFactory
import com.example.myweather.data.datasource.RemoteDataSourceImpl
import com.example.myweather.data.repository.LocationRepository
import com.example.myweather.data.repository.LocationRepositoryImpl
import com.example.myweather.data.datasource.RemoteDataSource
import com.example.myweather.data.repository.WeatherRepository
import com.example.myweather.data.repository.WeatherRepositoryImpl
import com.example.myweather.ui.weatherscreen.WeatherViewModel
import com.google.android.gms.location.LocationServices
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.onCreate(CIO.create()) }
    single { LocationServices.getFusedLocationProviderClient(get<Context>()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
    single<LocationRepository> { LocationRepositoryImpl(get(), get()) }

    viewModel { WeatherViewModel(get(), get()) }
}