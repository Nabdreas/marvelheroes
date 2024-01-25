package com.biggerthannull.marvelheroes.feature.feed.viewmodel.state

import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicBookDetails

sealed class DetailsUIState {
    data object Loading : DetailsUIState()

    class Error(val errorMessageId: Int) : DetailsUIState()

    class Success(val data: ComicBookDetails) : DetailsUIState()
}