package com.aminovic.amadeustest.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.aminovic.amadeustest.presentation.components.CityRow
import com.aminovic.amadeustest.presentation.components.SearchTextField


@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val cities = viewModel.cities.collectAsLazyPagingItems()
    val state by viewModel.state.collectAsStateWithLifecycle()
    var initialLoad = remember { false }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = initialLoad) {
        if (!initialLoad) {
            viewModel.onEvent(HomeEvent.RefreshData)
            initialLoad = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                all = 16.dp,
            ),
    ) {
        Text(text = "Size: ${cities.itemCount}")
        Spacer(modifier = Modifier.height(16.dp))
        SearchTextField(
            text = state.query,
            onValueChange = {
                viewModel.onEvent(HomeEvent.OnQueryChange(it))
            },
            close = {
                viewModel.onEvent(HomeEvent.OnQueryChange(""))
                keyboardController?.hide()
                focusManager.clearFocus()
            },
            shouldShowHint = state.isHintVisible,
            onFocusChanged = {
                viewModel.onEvent(HomeEvent.OnSearchFocusChange(it.isFocused))
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
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
            when (val pagingState = cities.loadState.prepend) {
                is LoadState.NotLoading -> Unit
                is LoadState.Loading -> {
                    showLoading()
                }
                is LoadState.Error -> {
                    error(message = pagingState.error.message ?: "")
                }
            }
            when (val pagingState = cities.loadState.refresh) {
                is LoadState.NotLoading -> Unit
                is LoadState.Loading -> {
                    showLoading()
                }
                is LoadState.Error -> {
                    error(message = pagingState.error.message ?: "")
                }
            }
            items(
                items = cities,
                key = { it.cityId!! }
            ) {
                CityRow(city = it)
            }
            when (val pagingState = cities.loadState.append) {
                is LoadState.NotLoading -> Unit
                is LoadState.Loading -> {
                    showLoading()
                }
                is LoadState.Error -> {
                    error(message = pagingState.error.message ?: "")
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