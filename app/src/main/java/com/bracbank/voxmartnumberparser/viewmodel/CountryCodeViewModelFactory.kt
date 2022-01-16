package com.bracbank.voxmartnumberparser.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bracbank.voxmartnumberparser.reppsitory.CountryCodeRepository

class CountryCodeViewModelFactory(
    private val repository: CountryCodeRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try {
            val constructor = modelClass.getDeclaredConstructor(CountryCodeRepository::class.java)
            return constructor.newInstance(repository)
        } catch (e: Exception) {

        }
        return super.create(modelClass)
    }
}