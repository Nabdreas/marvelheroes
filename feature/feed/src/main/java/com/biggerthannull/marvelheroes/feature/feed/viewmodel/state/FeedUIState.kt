package com.biggerthannull.marvelheroes.feature.feed.viewmodel.state

import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ReleasedComicBook

sealed class FeedUIState {
    data object Loading : FeedUIState()

    class Error(val errorMessageId: Int) : FeedUIState()

    class Success(val comics: List<ReleasedComicBook>) : FeedUIState()
}