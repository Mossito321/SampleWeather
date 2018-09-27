package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherListResponse
import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherResponse
import io.reactivex.Observable

interface WeatherCollectionUseCase {
    fun getWeatherbyCity(city: String, degree: String):
            Observable<WeatherResponse>

    fun getWeatherListbyCity(city: String, degree: String):
            Observable<WeatherListResponse>
}

class WeatherCollectionUseCaseImpl(
        private val provider: WeatherProvider
) : WeatherCollectionUseCase {

    override fun getWeatherbyCity(city: String, degree: String): Observable<WeatherResponse> {
        return provider.getWeatherByCity(city, degree)
    }

    override fun getWeatherListbyCity(city: String, degree: String): Observable<WeatherListResponse> {
        return provider.getListWeatherByCity(city, degree)
    }

}