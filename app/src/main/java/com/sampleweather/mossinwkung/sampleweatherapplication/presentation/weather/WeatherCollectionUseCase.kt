package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherResponse
import io.reactivex.Observable

interface WeatherCollectionUseCase {
    fun getWeatherbyCity(city: String, degree: String):
            Observable<WeatherResponse>
}

class WeatherCollectionUseCaseImpl(
        private val provider: WeatherProvider
) : WeatherCollectionUseCase {

    override fun getWeatherbyCity(city: String, degree: String): Observable<WeatherResponse> {
        return provider.getWeatherByCity(city, degree)
    }

}