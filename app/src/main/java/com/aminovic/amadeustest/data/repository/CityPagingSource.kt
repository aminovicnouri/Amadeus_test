package com.aminovic.amadeustest.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aminovic.amadeustest.domain.modal.City
import com.aminovic.amadeustest.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class CityPagingSource(
    private val repository: WeatherRepository,
    private val query: String? = null
) : PagingSource<Int, City>() {
    private val pageCache = LinkedHashMap<Int, List<City>>()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, City> =
        try {
            withContext(Dispatchers.IO) {
                val size = params.loadSize
                val pageNumber = params.key ?: 1
                val cachedPage = pageCache[pageNumber]
                if (cachedPage != null) {
                    LoadResult.Page(cachedPage, prevKey = pageNumber - 1, nextKey = pageNumber + 1)
                }

                val cities = repository.getCities(query, size, pageNumber)
                val prevKey = if (pageNumber == 1) null else pageNumber - 1
                val nextKey = if (cities.isEmpty()) null else pageNumber + 1
                val result = LoadResult.Page(cities, prevKey, nextKey)

                pageCache[pageNumber] = cities
                if (pageCache.size > 4) {
                    val oldestPageNumber = pageCache.keys.first()
                    pageCache.remove(oldestPageNumber)
                }

                result
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }


    override fun getRefreshKey(state: PagingState<Int, City>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}