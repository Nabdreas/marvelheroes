package com.biggerthannull.marvelheroes.data.comics.di

import com.biggerthannull.marvelheroes.data.comics.datasource.ComicsDataSource
import com.biggerthannull.marvelheroes.data.comics.datasource.ComicsDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindComicsDataSource(impl: ComicsDataSourceImpl): ComicsDataSource
}