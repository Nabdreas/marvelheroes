package com.biggerthannull.marvelheroes.domain.comics.di

import com.biggerthannull.marvelheroes.domain.comics.usecase.GetReleasedComicBooksUseCase
import com.biggerthannull.marvelheroes.domain.comics.usecase.GetReleasedComicBooksUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {
    @Binds
    fun bindGetReleasedComicBooks(impl: GetReleasedComicBooksUseCaseImpl): GetReleasedComicBooksUseCase
}