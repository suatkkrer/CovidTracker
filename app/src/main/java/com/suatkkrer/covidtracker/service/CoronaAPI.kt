package com.suatkkrer.covidtracker.service

import com.suatkkrer.covidtracker.model.countries_api
import io.reactivex.Single
import retrofit2.http.GET

interface CoronaAPI {

    @GET("summary")
    fun getCountries():Single<List<countries_api>>

}