package com.aminovic.amadeustest.presentation.screens.home

sealed class HomeEvent {
    object RefreshData : HomeEvent()

    data class OnQueryChange(val query: String) : HomeEvent()
    object OnSearch : HomeEvent()

    data class OnSearchFocusChange(val isFocused: Boolean) : HomeEvent()
}
