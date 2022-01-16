package com.bracbank.voxmartnumberparser.reppsitory

import androidx.lifecycle.LiveData
import com.bracbank.voxmartnumberparser.model.CountryCode
import com.bracbank.voxmartnumberparser.roomdatabase.CountryCodeDataBase

class CountryCodeRepository(
    private val noteDatabase: CountryCodeDataBase
) {

    suspend fun insertCountryCode(note: CountryCode) = noteDatabase.getCountryCodeDao().insertCountryCode(note)

    suspend fun updateCountryCode(note: CountryCode) = noteDatabase.getCountryCodeDao().updateCountryCode(note)

    suspend fun deleteCountryCode(note: CountryCode) = noteDatabase.getCountryCodeDao().deleteCountryCode(note)

    suspend fun deleteCountryCodeById(id: Int) = noteDatabase.getCountryCodeDao().deleteCountryCodeById(id)

    suspend fun clearCountryCode() = noteDatabase.getCountryCodeDao().clearCountryCode()

    fun getAllCountryCode(): LiveData<List<CountryCode>> = noteDatabase.getCountryCodeDao().getAllCountryCode()
}