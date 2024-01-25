package com.biggerthannull.marvelheroes.data.comics.di

import com.biggerthannull.marvelheroes.data.comics.datasource.ComicBooksDataSource
import com.biggerthannull.marvelheroes.data.comics.datasource.ComicBooksDataSourceImpl
import com.biggerthannull.marvelheroes.data.comics.repository.ComicsRepositoryImpl
import com.biggerthannull.marvelheroes.domain.comics.repository.ComicsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindComicBooksDataSource(impl: ComicBooksDataSourceImpl): ComicBooksDataSource

    @Binds
    fun bindComicsRepository(impl: ComicsRepositoryImpl): ComicsRepository
}