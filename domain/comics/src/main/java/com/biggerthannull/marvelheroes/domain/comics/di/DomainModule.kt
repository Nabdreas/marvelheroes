package com.biggerthannull.marvelheroes.domain.comics.di

import com.biggerthannull.marvelheroes.domain.comics.usecase.GetReleasedComicBooks
import com.biggerthannull.marvelheroes.domain.comics.usecase.GetReleasedComicBooksImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {
    @Binds
    fun bindGetReleasedComicBooks(impl: GetReleasedComicBooksImpl): GetReleasedComicBooks
}