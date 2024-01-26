package com.biggerthannull.marvelheroes.feature.feed.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biggerthannull.marvelheroes.domain.comics.usecase.GetComicBookDetailsUseCase
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicBookDetailsResult
import com.biggerthannull.marvelheroes.feature.feed.R
import com.biggerthannull.marvelheroes.feature.feed.viewmodel.state.DetailsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ComicBookDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCaseGetComicBookDetailsUseCase: GetComicBookDetailsUseCase
): ViewModel() {
    private val comicBookId = savedStateHandle.get<Int>("comicBookId")?: 0

    val uiState: StateFlow<DetailsUIState> = flow {
        emit(DetailsUIState.Loading)
        val result = useCaseGetComicBookDetailsUseCase.execute(comicBookId)
        emit(
            if (result is ComicBookDetailsResult.Success) {
                DetailsUIState.Success(result.data)
            } else {
                DetailsUIState.Error(R.string.generic_error_label)
            }
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = DetailsUIState.Loading
        )
}