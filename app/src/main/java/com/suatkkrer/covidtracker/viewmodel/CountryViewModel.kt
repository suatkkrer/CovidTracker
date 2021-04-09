package com.suatkkrer.covidtracker.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.suatkkrer.covidtracker.model.Country
import com.suatkkrer.covidtracker.model.CountryArray
import com.suatkkrer.covidtracker.model.NewJson
import com.suatkkrer.covidtracker.model.countries_api
import com.suatkkrer.covidtracker.service.AcountryAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.*

class CountryViewModel : ViewModel() {


    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    private val apiService = AcountryAPIService()
    private val disposable = CompositeDisposable()


    fun refreshData() {

        getDataFromAPI()

       /* val country = countries_api("safdas","sadfasdf","asdgfasdg","asdgasdg",0,1,1,"sadfasf",2,3,4)
        val country1 = countries_api("safdas","sadfasdf","asdgfasdg","asdgasdg",0,1,1,"sadfasf",2,3,4)
        val country2 = countries_api("safdas","sadfasdf","asdgfasdg","asdgasdg",0,1,1,"sadfasf",2,3,4)

        val countryList = arrayListOf<countries_api>(country,country1,country2)


        countries.value = countryList
        countryError.value = false
        countryLoading.value = false*/

    }


    private fun getDataFromAPI(){

        countryLoading.value = true

        disposable.add(
            apiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<NewJson>(){
                    override fun onSuccess(t: NewJson) {
                        countries.value = t.Countries
                        countryError.value = false
                        countryLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        countryError.value = true
                        countryLoading.value = false
                        e.printStackTrace()
                        Log.e("ASFASDFASDF",e.toString())
                    }

                })
        )

    }


}