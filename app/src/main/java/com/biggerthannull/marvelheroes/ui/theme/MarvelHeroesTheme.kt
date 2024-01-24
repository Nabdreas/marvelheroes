package com.biggerthannull.marvelheroes.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biggerthannull.marvelheroes.ui.theme.tokens.LightColourTokens

object MarvelHeroesTheme {
    val typography: MarvelHeroesTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val colour: MarvelHeroesColours
        @Composable
        @ReadOnlyComposable
        get() = LocalColours.current

    val shapes: MarvelHeroesShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

    @Immutable
    data class MarvelHeroesTypography(
        val h1: TextStyle = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            letterSpacing = (-0.02).sp
        ),
        val h2: TextStyle = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            letterSpacing = (-0.01).sp
        ),
        val h3: TextStyle = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        ),
        val body: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = (-0.01).sp
        ),
        val button: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        ),
        val basicText: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp
        )
    )

    @Immutable
    data class MarvelHeroesColours(
        val grey900: Color,
        val grey800: Color,
        val grey700: Color,
        val grey600: Color,
        val grey500: Color,
        val grey400: Color,
        val grey300: Color,
        val grey200: Color,
        val white: Color,
        val black: Color,
        val red: Color
    )

    @Immutable
    data class MarvelHeroesShapes(
        val small: Shape = RoundedCornerShape(8.0.dp),
        val medium: Shape = RoundedCornerShape(12.0.dp),
        val large: Shape = RoundedCornerShape(16.0.dp)
    )

    val LocalTypography = staticCompositionLocalOf {
        MarvelHeroesTypography()
    }

    val LocalShapes = staticCompositionLocalOf {
        MarvelHeroesShapes()
    }

    // reload values here?
    val LocalColours = staticCompositionLocalOf {
        MarvelHeroesColours(
            grey900 = LightColourTokens.grey900,
            grey800 = LightColourTokens.grey800,
            grey700 = LightColourTokens.grey700,
            grey600 = LightColourTokens.grey600,
            grey500 = LightColourTokens.grey500,
            grey400 = LightColourTokens.grey400,
            grey300 = LightColourTokens.grey300,
            grey200 = LightColourTokens.grey200,
            white = LightColourTokens.white,
            black = LightColourTokens.black,
            red = LightColourTokens.red
        )
    }
}