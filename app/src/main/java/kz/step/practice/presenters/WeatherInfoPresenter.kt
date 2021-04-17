package kz.step.practice.presenters

import kz.step.practice.domain.Weather
import org.jetbrains.anko.doAsync
import org.json.JSONObject
import java.net.URL

class WeatherInfoPresenter {
    private val apiKey = "71854e6150615b7d5276085b5a1cb295"

    fun updateWeather(data: Weather) {

        val apiResponse = getJson(data.cityName)

        val weather = JSONObject(apiResponse).getJSONArray("weather")
        data.description = weather.getJSONObject(0).getString("description")

        val main = JSONObject(apiResponse).getJSONObject("main")
        data.temperature = main.getString("temp")
    }

    fun isExist(city:String): Boolean {
        val apiResponse = getJson(city) ?: return true
        val code = JSONObject(apiResponse).getInt("cod")
        return code != 200
    }

    private fun getJson(city: String): String? {
        val url: String =
            "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey&units=metric&lang=ru"
        var response: String? = null
        doAsync {
            response = URL(url).readText()
        }.get()
        return response
    }
}