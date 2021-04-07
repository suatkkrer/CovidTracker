package com.suatkkrer.covidtracker.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.suatkkrer.covidtracker.view.CountryDetailsArgs
import com.suatkkrer.covidtracker.R
import com.suatkkrer.covidtracker.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_country_details.*


class CountryDetails : Fragment() {

    private lateinit var viewModel: DetailsViewModel
    private var countryUuid = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        viewModel.getDataFromRoom()

        arguments?.let {
            countryUuid = CountryDetailsArgs.fromBundle(it).countryUuid
        }

        observeLiveData()

    }

    private fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {
                countryName.text = country.Country
                countryCode.text = country.CountryCode
                countryConfirmed.text = country.NewConfirmed.toString()
                countryTotalConfirmed.text = country.TotalConfirmed.toString()
                countryNewDeaths.text = country.NewDeaths.toString()
                countryTotalDeaths.text = country.TotalDeaths.toString()
                countryNewRecovered.text = country.NewRecovered.toString()
                countryTotalRecovered.text = country.TotalRecovered.toString()
            }
        })
    }

}