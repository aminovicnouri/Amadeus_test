package com.aminovic.amadeustest.presentation.screens.details

import com.aminovic.amadeustest.presentation.modal.CityUi

data class DetailsState(
    val city: CityUi? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)