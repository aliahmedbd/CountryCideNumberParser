package com.bracbank.voxmartnumberparser.reppsitory

import androidx.lifecycle.LiveData
import com.bracbank.voxmartnumberparser.model.CountryCode
import com.bracbank.voxmartnumberparser.roomdatabase.CountryCodeDataBase

interface CountryCodeRepository {
    fun getAllCountryCode(): LiveData<List<CountryCode>>
    suspend fun insertCountryCode(countryCode: CountryCode)
    suspend fun updateCountryCode(countryCode: CountryCode)
    suspend fun deleteCountryCode(countryCode: CountryCode)
    suspend fun deleteCountryById(id: Int)
    suspend fun clearCountryCode()
}