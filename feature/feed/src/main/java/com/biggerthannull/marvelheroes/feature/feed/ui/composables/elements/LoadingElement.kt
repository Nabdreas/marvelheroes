package com.biggerthannull.marvelheroes.feature.feed.ui.composables.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.marvelheroes.feature.feed.R
import com.biggerthannull.marvelheroes.feature.feed.theme.MarvelHeroesTheme
import org.jetbrains.annotations.TestOnly


@TestOnly
const val LOADING_ELEMENT_TEST_TAG = "loading_element_test_tag"

@Composable
fun LoadingElement() {
    Box(
        modifier = Modifier
            .testTag(LOADING_ELEMENT_TEST_TAG)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val loadingText = stringResource(id = R.string.loading)
            CircularProgressIndicator(
                modifier = Modifier.semantics { contentDescription = loadingText }
            )
        }
    }
}

@Preview
@Composable
fun LoadingElementPreview() {
    MarvelHeroesTheme {
        LoadingElement()
    }
}