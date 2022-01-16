package com.bracbank.voxmartnumberparser.viewmodel

import androidx.lifecycle.ViewModel
import com.bracbank.voxmartnumberparser.model.CountryCode
import com.bracbank.voxmartnumberparser.reppsitory.CountryCodeRepository
import com.bracbank.voxmartnumberparser.reppsitory.CountryCodeRepositoryImpl
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CountryCodeViewModel @Inject constructor(private val repository: CountryCodeRepositoryImpl) :
    ViewModel() {

    suspend fun insertCountryCode(note: CountryCode) = repository.insertCountryCode(note)

    suspend fun updateCountryCode(note: CountryCode) = repository.updateCountryCode(note)

    suspend fun deleteCountryCode(note: CountryCode) = repository.deleteCountryCode(note)

    suspend fun deleteCountryCodeById(id: Int) = repository.deleteCountryById(id)

    suspend fun clearCountryCode() = repository.clearCountryCode()

    fun getAllCountryCode() = repository.getAllCountryCode()
}