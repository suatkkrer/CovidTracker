package com.suatkkrer.covidtracker.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.suatkkrer.covidtracker.R
import com.suatkkrer.covidtracker.adapter.CountryAdapter
import com.suatkkrer.covidtracker.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_countries.*

class Countries : Fragment() {

    private lateinit var viewModel : CountryViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.refreshData()

        countryRecycler.layoutManager = LinearLayoutManager(context)
        countryRecycler.adapter = countryAdapter

        observeLiveData()


        /* fragment_button.setOnClickListener {
            val action = CountriesDirections.actionCountriesToCountryDetails()
            Navigation.findNavController(it).navigate(action)
        } */
    }


    private fun observeLiveData() {
        viewModel.countries.observe(viewLifecycleOwner, Observer {countries ->
            countries?.let {
                countryRecycler.visibility = View.VISIBLE
                countryAdapter.updateList(countries)
            }
        })

        viewModel.countryError.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                if (it) {
                    internetError.visibility = View.VISIBLE
                } else {
                    internetError.visibility = View.GONE
                }
            }
        })
        viewModel.countryLoading.observe(viewLifecycleOwner, Observer { loading ->
            loading?.let {
                if (it) {
                    countryLoadingProgressBar.visibility = View.VISIBLE
                    countryRecycler.visibility = View.GONE
                    internetError.visibility = View.GONE
                } else {
                    countryLoadingProgressBar.visibility = View.GONE
                }
            }
        })

    }


}