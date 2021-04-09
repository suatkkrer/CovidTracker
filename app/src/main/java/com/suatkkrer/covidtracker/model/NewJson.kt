package com.suatkkrer.covidtracker.model

data class NewJson(
    val Countries: List<Country>,
    val Date: String,
    val Global: Global,
    val ID: String,
    val Message: String
)