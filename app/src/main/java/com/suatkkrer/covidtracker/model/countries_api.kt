package com.suatkkrer.covidtracker.model

import com.google.gson.annotations.SerializedName

data class countries_api(
        @SerializedName("Country")
        val Country: String,
        @SerializedName("CountryCode")
        val CountryCode: String,
        @SerializedName("Date")
        val Date: String,
        @SerializedName("ID")
        val ID: String,
        @SerializedName("NewConfirmed")
        val NewConfirmed: Int,
        @SerializedName("NewDeaths")
        val NewDeaths: Int,
        @SerializedName("NewRecovered")
        val NewRecovered: Int,
    //  val Premium: Premium,
        @SerializedName("Slug")
        val Slug: String,
        @SerializedName("TotalConfirmed")
        val TotalConfirmed: Int,
        @SerializedName("TotalDeaths")
        val TotalDeaths: Int,
        @SerializedName("TotalRecovered")
        val TotalRecovered: Int
)