package com.aminovic.amadeustest.presentation.screens.details

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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

    val isRotated = rememberSaveable { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (isRotated.value) 360F else 0F,
        animationSpec = tween(durationMillis = 500, easing = FastOutLinearInEasing)
    )

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(DetailsEvent.LoadCityEvent(id = cityId))
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center
        ) {
            state.city?.let { city ->
                WeatherCard(
                    city = city,
                    backgroundColor = DarkBlue
                )
            }
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
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = it,
                    color = MaterialTheme.colors.onSurface,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(8.dp))

                IconButton(onClick = {
                    isRotated.value = !isRotated.value
                    viewModel.onEvent(DetailsEvent.LoadCityEvent(id = cityId))
                }) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = stringResource(R.string.refresh_button),
                        tint = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .padding(16.dp)
                            .rotate(rotationAngle)
                    )
                }
            }
        }
    }
}