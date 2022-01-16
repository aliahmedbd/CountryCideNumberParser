package com.bracbank.voxmartnumberparser.viewmodel

import androidx.lifecycle.ViewModel
import com.bracbank.voxmartnumberparser.model.CountryCode
import com.bracbank.voxmartnumberparser.reppsitory.CountryCodeRepository

class CountryCodeViewModel(
    private val repository: CountryCodeRepository
) : ViewModel() {

    suspend fun insertCountryCode(note: CountryCode) = repository.insertCountryCode(note)

    suspend fun updateCountryCode(note: CountryCode) = repository.updateCountryCode(note)

    suspend fun deleteCountryCode(note: CountryCode) = repository.deleteCountryCode(note)

    suspend fun deleteCountryCodeById(id: Int) = repository.deleteCountryCodeById(id)

    suspend fun clearCountryCode() = repository.clearCountryCode()

    fun getAllCountryCode() = repository.getAllCountryCode()
}