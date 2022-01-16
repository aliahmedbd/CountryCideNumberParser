package com.bracbank.voxmartnumberparser.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CountryCode")
data class CountryCode(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val countryName: String?,
    val countryShortName: String?,
    val countryCode: String?,
    val nationalPrefix: String?,
    val countryIcon: String?
)