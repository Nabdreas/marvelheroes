package com.biggerthannull.marvelheroes.feature.feed.ui.composables.imageloading

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

interface ImageLoader {
    @Composable
    fun Load(
        url: String,
        modifier: Modifier,
        contentDescription: String?,
        scale: ContentScale
    )
}