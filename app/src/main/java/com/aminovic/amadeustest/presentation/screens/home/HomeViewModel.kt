package com.aminovic.amadeustest.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.aminovic.amadeustest.data.repository.CityPagingSource
import com.aminovic.amadeustest.domain.repository.WeatherRepository
import com.aminovic.amadeustest.domain.utils.Resource
import com.aminovic.amadeustest.presentation.mappers.toCityUi
import com.aminovic.amadeustest.presentation.modal.CityUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState>
        get() = _state

    var cities: Flow<PagingData<CityUi>> = Pager(
        pagingSourceFactory = { CityPagingSource(repository) },
        config = PagingConfig(pageSize = 50)
    ).flow.map { list ->
        list.map { it.toCityUi() }
    }.cachedIn(viewModelScope)

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.RefreshData -> {
                // loadDataFormApi()
            }
            is HomeEvent.OnQueryChange -> {
                _state.update { it.copy(query = event.query) }
                val query = event.query.ifBlank { null }
                cities = Pager(
                    pagingSourceFactory = { CityPagingSource(repository, query = query) },
                    config = PagingConfig(pageSize = 50)
                ).flow.map { list ->
                    list.map { it.toCityUi() }
                }.cachedIn(viewModelScope)
            }
            HomeEvent.OnSearch -> executeSearch()
            is HomeEvent.OnSearchFocusChange -> {
                _state.update {
                    it.copy(
                        isHintVisible = !event.isFocused && it.query.isBlank()
                    )
                }
            }
        }
    }

    private fun executeSearch() {
    }

    private fun loadDataFormApi() {
        viewModelScope.launch(Dispatchers.IO) {
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