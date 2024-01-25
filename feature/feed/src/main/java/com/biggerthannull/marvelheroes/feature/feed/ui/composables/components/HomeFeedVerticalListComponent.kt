package com.biggerthannull.marvelheroes.feature.feed.ui.composables.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ReleasedComicBook
import com.biggerthannull.marvelheroes.feature.feed.theme.MarvelHeroesTheme

@Composable
fun HomeFeedVerticalListComponent(
    data: List<ReleasedComicBook>,
    onComicBookClicked: (id: Int) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(items = data, itemContent = { comicBook ->
            HomeFeedListItemComponent(
                comicBook = comicBook,
                onComicBookClicked = onComicBookClicked)
        })
    }
}

@Preview
@Composable
fun HomeFeedVerticalListComponentPreview() {
    MarvelHeroesTheme {
        HomeFeedVerticalListComponent(
            data = listOf(
                ReleasedComicBook(
                    id = 91992,
                    digitalId = 56203,
                    title = "Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)",
                    thumbnail = "http://i.annihil.us/u/prod/marvel/i/mg/a/10/5ff386e1a2e88.jpg"
                )
            ),
            onComicBookClicked = {
                // no - op
            }
        )
    }
}