package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import com.sampleweather.mossinwkung.sampleweatherapplication.api.APIInterface
import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherResponse
import io.reactivex.Observable
import java.util.*

class WeatherParams {
    companion object {

        const val API_KEY = "b00035252e0d88d81e91e6b60789afc4"
    }
}

interface WeatherProvider {
    fun getWeatherByCity(city: String, degree: String):
            Observable<WeatherResponse>

}

class WeatherProviderImpl(
        private val api: APIInterface
) : WeatherProvider {

    override fun getWeatherByCity(city: String, degree: String): Observable<WeatherResponse> {
        return api.getLocationByCity(q = city,
                units = degree,
                appId = WeatherParams.API_KEY)
    }
}

