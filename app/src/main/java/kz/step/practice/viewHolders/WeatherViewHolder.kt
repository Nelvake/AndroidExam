package kz.step.practice.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.step.practice.R
import kz.step.practice.domain.Weather

class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var cityNameTextView: TextView? = null
    var tempTextView: TextView? = null
    var descriptionTextView: TextView? = null

    init {
        cityNameTextView = itemView.findViewById(R.id.textview_viewholder_city_name)
        tempTextView = itemView.findViewById(R.id.textview_viewholder_temperature)
        descriptionTextView = itemView.findViewById(R.id.textview_viewholder_description)
    }

    fun bind(weather: Weather){
        cityNameTextView?.text = weather.cityName
        tempTextView?.text = weather.temperature
        descriptionTextView?.text = weather.description
    }
}