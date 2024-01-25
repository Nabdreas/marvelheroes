package com.biggerthannull.marvelheroes.feature.feed.ui.composables.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicBookDetails
import com.biggerthannull.marvelheroes.feature.feed.theme.MarvelHeroesTheme
import com.biggerthannull.marvelheroes.feature.feed.ui.composables.elements.IconImageElement

@Composable
fun DetailsBodyComponent(data: ComicBookDetails) {
    val scrollableState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollableState)
            .fillMaxWidth()
    ) {
        IconImageElement(
            url = data.thumbnail,
            modifier = Modifier
                .fillMaxWidth()
                .clip(MarvelHeroesTheme.shapes.medium),
            scale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = data.description,
            style = MarvelHeroesTheme.typography.body,
            color = MarvelHeroesTheme.colour.white
        )
    }
}

@Preview
@Composable
fun DetailsBodyComponentPreview() {
    MarvelHeroesTheme {
        DetailsBodyComponent(
            data = ComicBookDetails(
                id = 91992,
                title = "Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)",
                description = "Collects Fantastic Four (2018) #1-11, Fantastic Four Wedding Special (2018) #1. The Fantastic Four is the World’s Greatest Comics Magazine — and superstar writer Dan Slott is about to show you why! After being separated across dimensions, the Thing, the Human Torch, the Invisible Woman and Mister Fantastic reunite at long last! But as Reed and Sue return home with their children, they find that big things have changed! Ben Grimm and Alicia Masters have major plans of their own — like a wedding, years in the making! And a new fabulous foursome, the Fantastix, are muscling in on the scene! But now that the FF are back, can Doctor Doom be far behind? And what about Galactus? Brace yourself for the World-Eater vs. the Lord of Latveria, with the fate of the planet hanging in the balance!",
                thumbnail = "https://i.annihil.us/u/prod/marvel/i/mg/a/10/5ff386e1a2e88.jpg"
            )
        )
    }
}