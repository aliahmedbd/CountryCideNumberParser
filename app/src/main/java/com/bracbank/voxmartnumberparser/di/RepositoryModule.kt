package com.bracbank.voxmartnumberparser.di

import com.bracbank.voxmartnumberparser.reppsitory.CountryCodeDAO
import com.bracbank.voxmartnumberparser.reppsitory.CountryCodeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideCountryCodeRepository(countryCodeDAO: CountryCodeDAO) =
        CountryCodeRepositoryImpl(countryCodeDAO)
}