package com.biggerthannull.marvelheroes.feature.feed.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biggerthannull.marvelheroes.domain.comics.usecase.GetReleasedComicBooksUseCase
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicsResult
import com.biggerthannull.marvelheroes.feature.feed.R
import com.biggerthannull.marvelheroes.feature.feed.viewmodel.state.FeedUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getReleasedComicBooksUseCase: GetReleasedComicBooksUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<FeedUIState>(FeedUIState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val result = getReleasedComicBooksUseCase.execute()
            if (result is ComicsResult.Success) {
                FeedUIState.Success(result.data)
            } else {
                FeedUIState.Error(R.string.generic_error_label)
            }
        }
    }


//    val uiState: StateFlow<FeedUIState> = flow {
//        val result = getReleasedComicBooksUseCase.execute()
//        emit(
//            if (result is ComicsResult.Success) {
//                FeedUIState.Success(result.data)
//            } else {
//                FeedUIState.Error(R.string.generic_error_label)
//            }
//        )
//    }
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(),
//            initialValue = FeedUIState.Loading
//        )

}