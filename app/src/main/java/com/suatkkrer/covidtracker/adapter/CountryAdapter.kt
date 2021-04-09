package com.suatkkrer.covidtracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.suatkkrer.covidtracker.R
import com.suatkkrer.covidtracker.model.Country
import com.suatkkrer.covidtracker.model.countries_api
import com.suatkkrer.covidtracker.view.CountriesDirections
import kotlinx.android.synthetic.main.list_row.view.*
import java.util.ArrayList

class CountryAdapter (val countryList: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(var view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_row,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country_row.text = countryList[position].Country
        holder.view.countrycode_row.text = countryList[position].CountryCode

        holder.view.setOnClickListener {
            val action = CountriesDirections.actionCountriesToCountryDetails()
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateList(newCountryList : List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

}