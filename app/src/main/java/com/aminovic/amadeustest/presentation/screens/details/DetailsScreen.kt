package com.aminovic.amadeustest.presentation.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aminovic.amadeustest.R
import com.aminovic.amadeustest.presentation.screens.components.WeatherCard
import com.aminovic.amadeustest.presentation.ui.theme.Colors.DarkBlue

@Composable
fun DetailsScreen(
    viewModel: DetailsVieModel = hiltViewModel(),
    cityId: Int,
    popup: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(DetailsEvent.LoadCityEvent(id = cityId))
    }

    state.city?.let { city ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background),
                verticalArrangement = Arrangement.Center
            ) {
                WeatherCard(
                    city = city,
                    backgroundColor = DarkBlue
                )
            }
            IconButton(onClick = popup, modifier = Modifier.align(Alignment.TopStart)) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back_button),
                    tint = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(16.dp)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            state.error?.let {
                Text(
                    text = it,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }
        }
    }
}