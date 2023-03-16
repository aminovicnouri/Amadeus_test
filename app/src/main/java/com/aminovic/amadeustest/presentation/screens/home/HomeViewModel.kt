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
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState>
        get() = _state
    var cities = initCitiesFlow()

    init {
        loadDataFormApi()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.RefreshData -> {
                loadDataFormApi()
            }
            is HomeEvent.OnQueryChange -> {
                _state.update { it.copy(query = event.query) }
                val query = event.query.ifBlank { null }
                cities = initCitiesFlow(query)
            }
            is HomeEvent.OnSearchFocusChange -> {
                _state.update {
                    it.copy(
                        isHintVisible = !event.isFocused && it.query.isBlank()
                    )
                }
            }
        }
    }

    private fun initCitiesFlow(query: String? = null): Flow<PagingData<CityUi>> {
        return Pager(
            pagingSourceFactory = { CityPagingSource(repository, query = query) },
            config = PagingConfig(pageSize = 100, prefetchDistance = 100)
        ).flow.map { list ->
            list.map { it.toCityUi() }
        }.cachedIn(viewModelScope)
    }

    private fun loadDataFormApi() {
        viewModelScope.launch() {
            _state.update { it.copy(isLoading = true) }
            withContext(Dispatchers.IO) {
                when (val result = repository.getWeatherData()) {
                    is Resource.Error -> {
                        _state.update { it.copy(isLoading = false, error = result.message) }
                    }
                    is Resource.Success -> {
                        result.data?.let {
                            repository.deleteAllCities()
                            repository.insertCities(result.data)
                            cities = initCitiesFlow()
                        }
                        _state.update { it.copy(isLoading = false, error = null) }
                    }
                }
            }
        }
    }

}