package com.suatkkrer.covidtracker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.suatkkrer.covidtracker.model.Country
import com.suatkkrer.covidtracker.model.PremiumX
import com.suatkkrer.covidtracker.model.countries_api

class DetailsViewModel : ViewModel() {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom() {

        val country = Country("safdas","sadfasdf","asdgfasdg","asdgasdg",0,1,1,
            PremiumX(),"sadfasf",2,3,4)
        countryLiveData.value = country
    }

}