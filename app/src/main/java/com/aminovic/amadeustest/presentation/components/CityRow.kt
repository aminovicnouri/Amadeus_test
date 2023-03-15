package com.aminovic.amadeustest.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.aminovic.amadeustest.R
import com.aminovic.amadeustest.presentation.modal.CityUi
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder
import kotlin.math.roundToInt

@Composable
fun CityRow(
    city: CityUi?
) {
    Spacer(modifier = Modifier.height(8.dp))
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = city?.image,
                    contentDescription = "country code",

                    modifier = Modifier
                        .size(25.dp)
                        .clip(shape = CircleShape),
                )
                Text(
                    text = "${city?.temp?.roundToInt()}ªC",
                    style = TextStyle(
                        fontSize = 12.sp
                    ),
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = city?.cityName ?: "",
                    modifier = Modifier
                        .placeholder(
                            visible = city == null,
                            highlight = PlaceholderHighlight.fade(highlightColor = Color.LightGray),
                            color = Color.Green
                        )
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 5.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    city?.pressure?.roundToInt()?.let {
                        WeatherDataDisplay(
                            value = it,
                            unit = "hpa",
                            icon = ImageVector.vectorResource(
                                id = R.drawable.ic_pressure
                            )
                        )
                    }
                    city?.humidity?.let {
                        WeatherDataDisplay(
                            value = it,
                            unit = "%",
                            icon = ImageVector.vectorResource(
                                id = R.drawable.ic_drop
                            )
                        )
                    }
                    city?.windSpeed?.roundToInt()?.let {
                        WeatherDataDisplay(
                            value = it,
                            unit = "km/h",
                            icon = ImageVector.vectorResource(
                                id = R.drawable.ic_wind
                            )
                        )
                    }
                }
            }

            AsyncImage(
                model = city?.country,
                contentDescription = "country code",

                modifier = Modifier
                    .size(25.dp)
                    .clip(shape = RoundedCornerShape(size = 16.dp)),
                contentScale = ContentScale.FillHeight
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}