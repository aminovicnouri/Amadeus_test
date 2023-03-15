package com.aminovic.amadeustest.presentation.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aminovic.amadeustest.domain.repository.WeatherRepository
import com.aminovic.amadeustest.presentation.mappers.toCityUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsVieModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val _state = MutableStateFlow(DetailsState())
    val state: StateFlow<DetailsState>
        get() = _state

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.LoadCityEvent -> {
                viewModelScope.launch {
                    _state.update { it.copy(isLoading = true) }
                    val city = repository.getCityById(event.id)?.toCityUi()
                    city?.let { _state.update { it.copy(isLoading = false, city = city) } }
                        ?: kotlin.run {
                            _state.update {
                                it.copy(
                                    isLoading = false,
                                    error = "City Not Found"
                                )
                            }
                        }
                }
            }
        }
    }
}