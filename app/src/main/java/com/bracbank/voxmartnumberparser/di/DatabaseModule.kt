package com.bracbank.voxmartnumberparser.di

import android.content.Context
import androidx.room.Room
import com.bracbank.voxmartnumberparser.roomdatabase.CountryCodeDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideCountryCodeDatabase(@ApplicationContext context: Context): CountryCodeDataBase {
        return Room.databaseBuilder(context, CountryCodeDataBase::class.java, CountryCodeDataBase.DB_NAME).build()
    }

    @Provides
    fun provideCountryCodeDAO(countryCodeDB: CountryCodeDataBase) = countryCodeDB.getCountryCodeDao()
}