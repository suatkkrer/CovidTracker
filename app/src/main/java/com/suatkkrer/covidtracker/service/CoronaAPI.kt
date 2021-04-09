package com.suatkkrer.covidtracker.service

import com.suatkkrer.covidtracker.model.CountryArray
import com.suatkkrer.covidtracker.model.NewJson
import com.suatkkrer.covidtracker.model.countries_api
import io.reactivex.Single
import retrofit2.http.GET

interface CoronaAPI {

    @GET("summary")
    fun getCountries():Single<NewJson>

}