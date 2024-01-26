package com.biggerthannull.marvelheroes.feature.feed.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.biggerthannull.marvelheroes.feature.feed.ui.composables.screens.ComicDetailsScreen
import com.biggerthannull.marvelheroes.feature.feed.viewmodel.ComicBookDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicBookDetailsFragment : Fragment() {

    private val viewModel: ComicBookDetailsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val uiState by viewModel.uiState.collectAsState()
                ComicDetailsScreen(uiState)
            }
        }
    }
}