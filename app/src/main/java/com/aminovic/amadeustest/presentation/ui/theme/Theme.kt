package com.aminovic.amadeustest.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aminovic.amadeustest.R

@Composable
fun AmadeusTestTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        darkColors
    } else {
        lightColors
    }

    val sfProText = FontFamily(
        Font(
            resId = R.font.sf_pro_text_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resId = R.font.sf_pro_text_medium,
            weight = FontWeight.Medium
        ),
        Font(
            resId = R.font.sf_pro_text_bold,
            weight = FontWeight.Bold
        ),
    )
    val typography = Typography(
        h1 = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        ),
        h2 = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        h3 = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        ),
        body1 = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        body2 = TextStyle(
            fontFamily = sfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}