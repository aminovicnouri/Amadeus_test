package com.aminovic.amadeustest.presentation.screens.details

sealed class DetailsEvent {
    data class LoadCityEvent(val id: Int): DetailsEvent()
}
