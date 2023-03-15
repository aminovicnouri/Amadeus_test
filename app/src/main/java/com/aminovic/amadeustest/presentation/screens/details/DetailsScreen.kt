package com.aminovic.amadeustest.presentation.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aminovic.amadeustest.presentation.screens.components.WeatherCard
import com.aminovic.amadeustest.presentation.ui.theme.Colors.DarkBlue
import com.aminovic.amadeustest.presentation.ui.theme.Colors.DeepBlue

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
                    .background(DarkBlue),
                verticalArrangement = Arrangement.Center
            ) {
                WeatherCard(
                    city = city,
                    backgroundColor = DeepBlue
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