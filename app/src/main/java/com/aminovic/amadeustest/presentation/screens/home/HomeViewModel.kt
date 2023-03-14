package com.aminovic.amadeustest.presentation.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aminovic.amadeustest.domain.repository.WeatherRepository
import com.aminovic.amadeustest.domain.utils.Resource
import com.aminovic.amadeustest.presentation.mappers.toCityUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())

    val state: StateFlow<HomeState>
        get() = _state

    init {
        viewModelScope.launch {
            repository.getAllCities().collect { cities ->
                _state.update { _state.value.copy(cities = cities.map { it.toCityUi() }) }
            }
        }

        viewModelScope.launch {
            when (val result = repository.getWeatherData()) {
                is Resource.Error -> Unit
                is Resource.Success -> {
                    result.data?.let {
                        for (i in result.data) {
                            repository.insertCity(i)
                        }
                    }

                }
            }
        }
    }

}