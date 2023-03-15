package com.aminovic.amadeustest.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aminovic.amadeustest.domain.modal.City
import com.aminovic.amadeustest.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class CityPagingSource(
    private val repository: WeatherRepository
) : PagingSource<Int, City>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, City> =
        try {
            withContext(Dispatchers.IO) {
                val size = params.loadSize
                val pageNumber = params.key ?: 0
                val cities = repository.getCities(size, pageNumber)
                val prevKey = if (pageNumber == 1) null else pageNumber - 1
                val nextKey = if (cities.isEmpty()) null else pageNumber + 1
                LoadResult.Page(cities, prevKey, nextKey)
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }


    override fun getRefreshKey(state: PagingState<Int, City>): Int? {
        return state.anchorPosition
    }
}