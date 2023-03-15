package com.aminovic.amadeustest.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.aminovic.amadeustest.presentation.components.CityRow


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val cities = viewModel.cities.collectAsLazyPagingItems()
    var initialLoad = remember { false }

    LaunchedEffect(key1 = initialLoad) {
        if (!initialLoad) {
            viewModel.onEvent(HomeEvent.RefreshData)
            initialLoad = false
        }
    }

    Column {
        Text(text = "Size: ${cities.itemCount}")
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 16.dp,
                    vertical = 32.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Cities",
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
            when (val state = cities.loadState.prepend) {
                is LoadState.NotLoading -> Unit
                is LoadState.Loading -> {
                    showLoading()
                }
                is LoadState.Error -> {
                    error(message = state.error.message ?: "")
                }
            }
            when (val state = cities.loadState.refresh) {
                is LoadState.NotLoading -> Unit
                is LoadState.Loading -> {
                    showLoading()
                }
                is LoadState.Error -> {
                    error(message = state.error.message ?: "")
                }
            }
            items(
                items = cities,
                key = { it.cityId!! }
            ) {
                CityRow(city = it)
            }
            when (val state = cities.loadState.append) {
                is LoadState.NotLoading -> Unit
                is LoadState.Loading -> {
                    showLoading()
                }
                is LoadState.Error -> {
                    error(message = state.error.message ?: "")
                }
            }
        }
    }
}

private fun LazyListScope.showLoading() {
    item {
        CircularProgressIndicator(modifier = Modifier.padding(16.dp))
    }
}

private fun LazyListScope.error(
    message: String
) {
    item {
        Text(
            text = message,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.error
        )
    }
}