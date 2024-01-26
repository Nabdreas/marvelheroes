package com.biggerthannull.marvelheroes.feature.feed.ui.composables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.biggerthannull.marvelheroes.feature.feed.theme.MarvelHeroesTheme
import com.biggerthannull.marvelheroes.feature.feed.ui.composables.components.HomeFeedVerticalListComponent
import com.biggerthannull.marvelheroes.feature.feed.ui.composables.elements.LoadingElement
import com.biggerthannull.marvelheroes.feature.feed.viewmodel.state.FeedUIState

@Composable
fun HomeFeedScreen(uiState: FeedUIState, onComicBookClicked: (id: Int) -> Unit) {
    Column(
        modifier = Modifier
            .background(MarvelHeroesTheme.colour.black)
            .fillMaxWidth()
    ) {
        when (uiState) {
            is FeedUIState.Loading -> {
                LoadingElement()
            }

            is FeedUIState.Success -> {
                HomeFeedVerticalListComponent(data = uiState.comics, onComicBookClicked = { id ->
                    onComicBookClicked(id)
                })
            }

            is FeedUIState.Error -> {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = uiState.errorMessageId)
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeFeedScreenPreview() {
    MarvelHeroesTheme {
        HomeFeedScreen(
            uiState = FeedUIState.Loading,
            onComicBookClicked = {
                // no-op
            })
    }
}