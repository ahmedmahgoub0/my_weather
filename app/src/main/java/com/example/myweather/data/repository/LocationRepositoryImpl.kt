package com.example.myweather.data.repository

import android.Manifest
import android.content.Context
import android.location.Geocoder
import android.util.Log
import androidx.annotation.RequiresPermission
import com.example.myweather.data.model.Location
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.tasks.await
import java.util.Locale

class LocationRepositoryImpl(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val context: Context
) : LocationRepository {
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getCurrentLocation(): Location {
        return try {
            val location = fusedLocationProviderClient.lastLocation.await()
            val cityName = getLocationName(location.latitude, location.longitude)
            Location(latitude = location.latitude, longitude = location.longitude, cityName)
        } catch (e: Exception) {
            Location()
        }
    }

    private fun getLocationName(latitude: Double, longitude: Double): String{
        return Geocoder(context, Locale.getDefault())
            .getFromLocation(latitude, longitude, 1)?.get(0)?.adminArea ?: ""
    }
}