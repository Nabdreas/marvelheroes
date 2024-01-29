package com.biggerthannull.marvelheroes.feature.feed.ui.composables.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ReleasedComicBook
import com.biggerthannull.marvelheroes.feature.feed.theme.MarvelHeroesTheme
import com.biggerthannull.marvelheroes.feature.feed.ui.composables.elements.IconImageElement

@Composable
fun HomeFeedListItemComponent(
    comicBook: ReleasedComicBook,
    onComicBookClicked: (thumbnail: String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(MarvelHeroesTheme.colour.grey800)
            .selectable(true, onClick = {
                onComicBookClicked(comicBook.thumbnail)
            }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconImageElement(
            url = comicBook.thumbnail,
            modifier = Modifier
                .padding(8.dp)
                .size(height = 110.dp, width = 85.dp)
                .clip(MarvelHeroesTheme.shapes.medium)
                .semantics {
                    contentDescription = comicBook.thumbnail
                },
            scale = ContentScale.FillBounds
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .semantics {
                    contentDescription = comicBook.title
                },
            text = comicBook.title,
            maxLines = 2,
            style = MarvelHeroesTheme.typography.h3,
            color = MarvelHeroesTheme.colour.white
        )
    }
}

@Preview
@Composable
fun HomeFeedListItemComponentPreview() {
    MarvelHeroesTheme {
        HomeFeedListItemComponent(
            comicBook = ReleasedComicBook(
                id = 91992,
                digitalId = 56203,
                title = "Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)",
                thumbnail = "http://i.annihil.us/u/prod/marvel/i/mg/a/10/5ff386e1a2e88.jpg"
            ),
            onComicBookClicked = {
                // no-op
            }
        )
    }
}