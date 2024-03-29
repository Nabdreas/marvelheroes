package com.biggerthannull.marvelheroes.feature.feed.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biggerthannull.marvelheroes.domain.comics.usecase.GetReleasedComicBooksUseCase
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicsResult
import com.biggerthannull.marvelheroes.feature.feed.R
import com.biggerthannull.marvelheroes.feature.feed.viewmodel.state.FeedUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getReleasedComicBooksUseCase: GetReleasedComicBooksUseCase
) : ViewModel() {

    val uiState: StateFlow<FeedUIState> = flow {
        emit(FeedUIState.Loading)
        val result = getReleasedComicBooksUseCase.execute()
        emit(
            if (result is ComicsResult.Success) {
                FeedUIState.Success(result.data)
            } else {
                FeedUIState.Error(R.string.generic_error_label)
            }
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = FeedUIState.Loading
        )

}