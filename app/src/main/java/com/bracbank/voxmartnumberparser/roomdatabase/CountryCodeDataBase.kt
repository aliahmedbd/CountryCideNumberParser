package com.bracbank.voxmartnumberparser.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bracbank.voxmartnumberparser.model.CountryCode
import com.bracbank.voxmartnumberparser.model.Profile
import com.bracbank.voxmartnumberparser.reppsitory.CountryCodeDAO

@Database(entities = [CountryCode::class, Profile::class], version = 1, exportSchema = false)
abstract class CountryCodeDataBase : RoomDatabase() {
    abstract fun getCountryCodeDao(): CountryCodeDAO

    companion object {
        const val DB_NAME = "country_code.db"
    }
}