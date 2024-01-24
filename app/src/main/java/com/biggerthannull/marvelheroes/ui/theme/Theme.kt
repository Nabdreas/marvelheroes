package com.biggerthannull.marvelheroes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.biggerthannull.marvelheroes.ui.theme.tokens.DarkColourTokens
import com.biggerthannull.marvelheroes.ui.theme.tokens.LightColourTokens

@Composable
fun MarvelHeroesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val typography =
        MarvelHeroesTheme.MarvelHeroesTypography()

    val colours = if (darkTheme) {
        darkThemeColours()
    } else {
        lightThemeColours()
    }
    val shapes = MarvelHeroesTheme.MarvelHeroesShapes()

    CompositionLocalProvider(
        MarvelHeroesTheme.LocalTypography provides typography,
        MarvelHeroesTheme.LocalColours provides colours,
        MarvelHeroesTheme.LocalShapes provides shapes
    ) {
        MaterialTheme(
            content = content
        )
    }
}

private fun darkThemeColours(): MarvelHeroesTheme.MarvelHeroesColours {
    return MarvelHeroesTheme.MarvelHeroesColours(
        grey900 = DarkColourTokens.grey900,
        grey800 = DarkColourTokens.grey800,
        grey700 = DarkColourTokens.grey700,
        grey600 = DarkColourTokens.grey600,
        grey500 = DarkColourTokens.grey500,
        grey400 = DarkColourTokens.grey400,
        grey300 = DarkColourTokens.grey300,
        grey200 = DarkColourTokens.grey200,
        white = DarkColourTokens.white,
        black = DarkColourTokens.black,
        red = DarkColourTokens.red
    )
}

private fun lightThemeColours(): MarvelHeroesTheme.MarvelHeroesColours {
    return MarvelHeroesTheme.MarvelHeroesColours(
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