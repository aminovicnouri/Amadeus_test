package com.aminovic.amadeustest.presentation.screens.home

data class HomeState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
)
