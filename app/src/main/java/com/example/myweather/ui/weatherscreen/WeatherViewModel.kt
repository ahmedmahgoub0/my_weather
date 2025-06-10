package com.example.myweather.ui.weatherscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweather.data.repository.LocationRepository
import com.example.myweather.data.repository.WeatherRepository
import com.example.myweather.ui.weatherscreen.uistate.WeatherUiState
import com.example.myweather.ui.weatherscreen.uistate.toUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class WeatherViewModel(
    private val locationRepository: LocationRepository,
    private val repository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val location = locationRepository.getCurrentLocation()
            val weather = repository.getWeather(location.latitude, location.longitude)
            _state.value = weather.toUiState()
            _state.update { it.copy(
                isLoading = false,
                cityName = location.cityName
            ) }
        }
    }
}
