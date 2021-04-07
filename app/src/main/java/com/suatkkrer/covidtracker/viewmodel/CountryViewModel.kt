package com.suatkkrer.covidtracker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.suatkkrer.covidtracker.model.countries_api

class CountryViewModel : ViewModel() {


    val countries = MutableLiveData<List<countries_api>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()


    fun refreshData() {

        val country = countries_api("safdas","sadfasdf","asdgfasdg","asdgasdg",0,1,1,"sadfasf",2,3,4)
        val country1 = countries_api("safdas","sadfasdf","asdgfasdg","asdgasdg",0,1,1,"sadfasf",2,3,4)
        val country2 = countries_api("safdas","sadfasdf","asdgfasdg","asdgasdg",0,1,1,"sadfasf",2,3,4)

        val countryList = arrayListOf<countries_api>(country,country1,country2)


        countries.value = countryList
        countryError.value = false
        countryLoading.value = false

    }

}