package kz.step.practice.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.step.practice.R
import kz.step.practice.domain.Weather
import kz.step.practice.viewHolders.WeatherViewHolder

class WeatherAdapter(var weatherList: MutableList<Weather>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("RecyclerView", "onCreateViewHolder")
        var itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.viewholder_weather,
                parent,
                false
            )

        return WeatherViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("RecyclerView", "onBindViewHolder")
        (holder as WeatherViewHolder).bind(weatherList[position])
    }

    fun addWeather(weather : Weather) {
        weatherList.add(weather)
    }
}