package com.suatkkrer.covidtracker.service

import com.suatkkrer.covidtracker.model.CountryArray
import com.suatkkrer.covidtracker.model.NewJson
import com.suatkkrer.covidtracker.model.countries_api
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AcountryAPIService {


    private val BASE_URL = "https://api.covid19api.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CoronaAPI::class.java)

    fun getData() : Single<NewJson>{
        return api.getCountries()
    }


}