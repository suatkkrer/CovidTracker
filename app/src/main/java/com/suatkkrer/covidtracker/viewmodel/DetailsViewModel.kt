package com.suatkkrer.covidtracker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.suatkkrer.covidtracker.model.countries_api

class DetailsViewModel : ViewModel() {

    val countryLiveData = MutableLiveData<countries_api>()

    fun getDataFromRoom() {

        val country = countries_api("safdas","sadfasdf","asdgfasdg","asdgasdg",0,1,1,"sadfasf",2,3,4)
        countryLiveData.value = country
    }

}