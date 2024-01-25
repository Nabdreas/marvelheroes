package com.biggerthannull.marvelheroes.feature.feed.ui.composables.imageloading

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.biggerthannull.marvelheroes.feature.feed.R

class ImageLoaderImpl : ImageLoader {
    @Composable
    override fun Load(
        url: String,
        modifier: Modifier,
        contentDescription: String?,
        scale: ContentScale
    ) {
        CoilImageLoader().LoadImage(
            url = url,
            modifier = modifier,
            contentDescription = contentDescription,
            scale = scale
        )
    }
}

internal class CoilImageLoader {
    @Composable
    fun LoadImage(
        url: String,
        modifier: Modifier,
        scale: ContentScale = ContentScale.Fit,
        contentDescription: String?
    ) {
        val imageModel = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .placeholder(R.drawable.ic_launcher_foreground)

        AsyncImage(
            modifier = modifier,
            model = imageModel.build(),
            contentScale = scale,
            contentDescription = contentDescription
        )
    }
}