package com.bracbank.voxmartnumberparser.reppsitory

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bracbank.voxmartnumberparser.model.CountryCode

@Dao
interface CountryCodeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //if some data is same/conflict, it'll be replace with new data.
    suspend fun insertCountryCode(countryCode: CountryCode)

    @Update
    suspend fun updateCountryCode(countryCode: CountryCode)

    @Delete
    suspend fun deleteCountryCode(countryCode: CountryCode)

    @Query("SELECT * FROM CountryCode ORDER BY countryName ASC ")
    fun getAllCountryCode(): LiveData<List<CountryCode>>
    // why not use suspend ? because Room does not support LiveData with suspended functions.
    // LiveData already works on a background thread and should be used directly without using coroutines

    @Query("DELETE FROM CountryCode")
    suspend fun clearCountryCode()

    @Query("DELETE FROM CountryCode WHERE id = :id") //you can use this too, for delete note by id.
    suspend fun deleteCountryCodeById(id: Int)
}