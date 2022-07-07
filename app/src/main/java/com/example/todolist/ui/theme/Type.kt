package com.example.todolist.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.todolist.R

// Set of Material typography styles to start with

val myCustomFont = FontFamily(
    Font(R.font.bold, FontWeight.Bold),
    Font(R.font.light, FontWeight.Light),
    Font(R.font.medium, FontWeight.Medium),
    Font(R.font.semibold, FontWeight.SemiBold),
    Font(R.font.regular, FontWeight.Normal),
)

val Typography = Typography(
    headlineMedium = TextStyle(
        fontFamily = myCustomFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp

    ),
    bodyLarge = TextStyle(
        fontFamily = myCustomFont,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp

    ),
    bodyMedium = TextStyle(
        fontFamily = myCustomFont,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp

    ),
    bodySmall = TextStyle(
        fontFamily = myCustomFont,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp

    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
