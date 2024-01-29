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
import androidx.navigation.fragment.findNavController
import com.biggerthannull.marvelheroes.feature.feed.theme.MarvelHeroesTheme
import com.biggerthannull.marvelheroes.feature.feed.ui.composables.screens.HomeFeedScreen
import com.biggerthannull.marvelheroes.feature.feed.viewmodel.FeedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFeedFragment : Fragment() {

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val uiState by viewModel.uiState.collectAsState()
                MarvelHeroesTheme {
                    HomeFeedScreen(uiState = uiState) { thumbnail ->
                        navigate(thumbnail)
                    }
                }
            }
        }
    }

    private fun navigate(thumbnail: String) {
        val action = ComicsFeedFragmentDirections.actionDetailsFragment(thumbnail)
        findNavController().navigate(action)
    }
}