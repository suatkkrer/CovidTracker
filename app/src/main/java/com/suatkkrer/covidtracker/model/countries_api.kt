package com.suatkkrer.covidtracker.model

data class countries_api(
    val Country: String,
    val CountryCode: String,
    val Date: String,
    val ID: String,
    val NewConfirmed: Int,
    val NewDeaths: Int,
    val NewRecovered: Int,
   // val Premium: Premium,
    val Slug: String,
    val TotalConfirmed: Int,
    val TotalDeaths: Int,
    val TotalRecovered: Int
)