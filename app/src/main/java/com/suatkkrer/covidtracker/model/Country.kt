package com.suatkkrer.covidtracker.model

data class Country(
    val Country: String,
    val CountryCode: String,
    val Date: String,
    val ID: String,
    val NewConfirmed: Int,
    val NewDeaths: Int,
    val NewRecovered: Int,
    val Premium: PremiumX,
    val Slug: String,
    val TotalConfirmed: Int,
    val TotalDeaths: Int,
    val TotalRecovered: Int
)