package com.aminovic.amadeustest.presentation.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.aminovic.amadeustest.R
import com.aminovic.amadeustest.presentation.screens.components.CityRow
import com.aminovic.amadeustest.presentation.screens.components.SearchTextField


@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetails: (Int) -> Unit
) {
    val cities = viewModel.cities.collectAsLazyPagingItems()
    val state by viewModel.state.collectAsState()
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                all = 16.dp,
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "size: ${cities.itemCount}")
        Row(
            Modifier.fillMaxWidth(),
        ) {
            SearchTextField(
                modifier = Modifier.weight(1f),
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
            IconButton(onClick = { viewModel.onEvent(HomeEvent.RefreshData) }) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = stringResource(R.string.refresh_button),
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(visible = state.isLoading) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(text = "Loading data from server")
                if (state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .then(Modifier.size(24.dp)),
                    )
                }
            }
        }
        AnimatedVisibility(visible = (state.error != null && cities.itemCount == 0)) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = stringResource(R.string.network_error),
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 16.dp,
                    bottom = 8.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
            ) { city ->
                city?.let { CityRow(city = it, onClick = navigateToDetails) }
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