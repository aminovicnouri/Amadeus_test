package com.aminovic.amadeustest.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aminovic.amadeustest.R
import com.aminovic.amadeustest.presentation.modal.CityUi
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun WeatherCard(
    city: CityUi,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        backgroundColor = backgroundColor,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .padding(16.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${
                    city.time?.format(
                        DateTimeFormatter.ofPattern("HH:mm")
                    )
                }",
                modifier = Modifier.align(Alignment.End),
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(16.dp))
            city.image?.let { painterResource(id = it) }?.let {
                Image(
                    painter = it,
                    contentDescription = "weather type",
                    modifier = Modifier.width(200.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${city.temp?.roundToInt()}ºC",
                fontSize = 50.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            city.weather.first().description?.let {
                Text(
                    text = it,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            city.cityName?.let {
                Text(
                    text = it,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                city.pressure?.roundToInt()?.let {
                    WeatherDataDisplay(
                        value = it,
                        unit = "hpa",
                        icon = ImageVector.vectorResource(
                            id = R.drawable.ic_pressure
                        ),
                        iconTint = Color.White
                    )
                }
                city.humidity?.let {
                    WeatherDataDisplay(
                        value = it,
                        unit = "%",
                        icon = ImageVector.vectorResource(
                            id = R.drawable.ic_drop
                        ),
                        iconTint = Color.White
                    )
                }
                city.windSpeed?.roundToInt()?.let {
                    WeatherDataDisplay(
                        value = it,
                        unit = "km/h",
                        icon = ImageVector.vectorResource(
                            id = R.drawable.ic_wind
                        ),
                        iconTint = Color.White
                    )
                }
            }
        }
    }
}