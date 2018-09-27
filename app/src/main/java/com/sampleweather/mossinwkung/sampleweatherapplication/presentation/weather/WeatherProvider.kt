package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import com.sampleweather.mossinwkung.sampleweatherapplication.api.APIInterface
import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherListResponse
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

    fun getListWeatherByCity(city: String, degree: String):
            Observable<WeatherListResponse>

}

class WeatherProviderImpl(
        private val api: APIInterface
) : WeatherProvider {

    override fun getWeatherByCity(city: String, degree: String): Observable<WeatherResponse> {
        return api.getWeatherByCity(q = city,
                units = degree,
                appId = WeatherParams.API_KEY)
    }

    override fun getListWeatherByCity(city: String, degree: String): Observable<WeatherListResponse> {
        return api.getWeatherListByCity(q = city,
                units = degree,
                appId = WeatherParams.API_KEY)
    }

}

