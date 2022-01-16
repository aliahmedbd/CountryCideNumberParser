package com.bracbank.voxmartnumberparser.reppsitory

import androidx.lifecycle.LiveData
import com.bracbank.voxmartnumberparser.model.CountryCode
import javax.inject.Inject

/**
 * Created by rivaldy on 07,February,2021
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class CountryCodeRepositoryImpl @Inject constructor(private val countryCodeDao: CountryCodeDAO) :
    CountryCodeRepository {

    override fun getAllCountryCode() = countryCodeDao.getAllCountryCode()

    override suspend fun insertCountryCode(countryCode: CountryCode) =
        countryCodeDao.insertCountryCode(countryCode)

    override suspend fun updateCountryCode(countryCode: CountryCode) =
        countryCodeDao.updateCountryCode(countryCode)

    override suspend fun deleteCountryCode(countryCode: CountryCode) =
        countryCodeDao.deleteCountryCode(countryCode)

    override suspend fun deleteCountryById(id: Int) = countryCodeDao.deleteCountryCodeById(id)

    override suspend fun clearCountryCode() = countryCodeDao.clearCountryCode()
}