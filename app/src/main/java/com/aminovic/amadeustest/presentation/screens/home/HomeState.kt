package com.aminovic.amadeustest.presentation.screens.home

import com.aminovic.amadeustest.presentation.modal.CityUi

data class HomeState(
    val cities: List<CityUi> = emptyList(),
    val isLoading: Boolean = false
)
