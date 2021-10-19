package com.suatkkrer.covidtracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Country(

        @ColumnInfo(name = "name")
        @SerializedName("Country")
        val Country: String,
        @ColumnInfo(name = "CountryCode")
        @SerializedName("CountryCode")
        val CountryCode: String,
        @ColumnInfo(name = "Date")
        @SerializedName("Date")
        val Date: String,
        @ColumnInfo(name = "ID")
        @SerializedName("ID")
        val ID: String,
        @ColumnInfo(name = "NewConfirmed")
        @SerializedName("NewConfirmed")
        val NewConfirmed: Int,
        @ColumnInfo(name = "NewDeaths")
        @SerializedName("NewDeaths")
        val NewDeaths: Int,
        @ColumnInfo(name = "NewRecovered")
        @SerializedName("NewRecovered")
        val NewRecovered: Int,
        @ColumnInfo(name = "Premium")
        @SerializedName("Premium")
        val Premium: PremiumX,
        @ColumnInfo(name = "Slug")
        @SerializedName("Slug")
        val Slug: String,
        @ColumnInfo(name = "TotalConfirmed")
        @SerializedName("TotalConfirmed")
        val TotalConfirmed: Int,
        @ColumnInfo(name = "TotalDeaths")
        @SerializedName("TotalDeaths")
        val TotalDeaths: Int,
        @ColumnInfo(name = "TotalRecovered")
        @SerializedName("TotalRecovered")
        val TotalRecovered: Int
) {
    @PrimaryKey(autoGenerate = true)
    var uuid : Int = 0
}